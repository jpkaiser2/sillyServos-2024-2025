// Created by Jacob Kaiserman
// Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos-2024-2025
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp
public class teleMain extends LinearOpMode {
    // Declare motors and servos
    public DcMotor frontLeftMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor armMotor = null;
    public Servo claw1 = null;
    public Servo claw2 = null;

    // Arm ticks per degree
    final double armTicksPerDegree = 28 * 250047.0 / 4913.0 * 100.0 / 20.0 * 1 / 360.0;

    // Arm positions in encoder ticks
    final double armCollapsedIntoRobot = 0;
    final double armCollect = 0.004 * armTicksPerDegree;
    final double armClearBarrier = 0.0005 * armTicksPerDegree;
    final double armScoreSampleInLow = 100 * armTicksPerDegree;

    // Number of degrees to adjust the arm position by
    final double errorFactor = 1 * armTicksPerDegree;

    // Variables for arm position
    double armPosition = armCollapsedIntoRobot;
    double armPositionErrorFactor;

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize motors
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        backRightMotor = hardwareMap.dcMotor.get("backRight");
        armMotor = hardwareMap.dcMotor.get("armMotor");

        // Initialize claw servos
        claw1 = hardwareMap.servo.get("claw1");
        claw2 = hardwareMap.servo.get("claw2");

        // Reverse left side motors for correct movement
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        //backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set arm motor behavior
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ((DcMotorEx) armMotor).setCurrentAlert(5, CurrentUnit.AMPS);
        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;  // Forward/backward
            double x = gamepad1.left_stick_x * 1.1;  // Strafing (adjusted for sensitivity)
            double rx = -gamepad1.right_stick_x;  // Rotation

            // Calculate motor power for mecanum drive
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            // Set motor power for each wheel
            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            // Arm position control
            if (gamepad1.right_bumper) {
                armMotor.setTargetPosition(2);
            } else if (gamepad1.left_bumper) {
                armMotor.setTargetPosition(-2);
            } else if (gamepad1.y) {
                armPosition = armScoreSampleInLow;
            }

            // Adjust arm position with error factor
            //armPositionErrorFactor = errorFactor * (gamepad1.right_trigger - gamepad1.left_trigger);
            //armMotor.setTargetPosition((int) (armPosition + armPositionErrorFactor));
            ((DcMotorEx) armMotor).setVelocity(2100);

            // Control claw servos
            if (gamepad1.x) {
                // Open the claw: claw1 moves to 0.8, claw2 moves to 0.2
                claw1.setPosition(0.8);
                claw2.setPosition(0.2);
            } else if (gamepad1.a) {
                // Close the claw: claw1 moves to 0.2, claw2 moves to 0.8
                claw1.setPosition(0.2);
                claw2.setPosition(0.8);
            }

            // Check for current limit on arm motor and provide telemetry
            if (((DcMotorEx) armMotor).isOverCurrent()) {
                telemetry.addLine("MOTOR EXCEEDED CURRENT LIMIT!");
            }

            telemetry.addData("Arm Target: ", armMotor.getTargetPosition());
            telemetry.addData("Arm Encoder: ", armMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}
