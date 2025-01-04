// Created by Jacob Kaiserman
// Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos-2024-2025
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class teleMain extends LinearOpMode {
    public DcMotor frontLeftMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotorEx armMotor = null;
    public Servo claw1 = null;
    public Servo claw2 = null;

    @Override
    public void runOpMode() {
        // Motor Initialization
        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeft");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRight");
        armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");

        // Servo Initialization
        claw1 = hardwareMap.servo.get("claw1");
        claw2 = hardwareMap.servo.get("claw2");

        // Reverse back left for correct mecanum movement
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Arm motor setup
        armMotor.setTargetPosition(0);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initialize claw positions
        claw1.setPosition(0);
        claw2.setPosition(0.8);

        int armTargetPosition = 0;

        waitForStart();

        while (opModeIsActive()) {
            // Drive control
            double y = -gamepad1.left_stick_y;  // Forward/backward
            double x = gamepad1.left_stick_x * 1.1;  // Strafing
            double rx = -gamepad1.right_stick_x;  // Rotation

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);

            // Arm control
            if (gamepad1.right_bumper) {
                armTargetPosition += 10; // Raise the arm
            }
            else if (gamepad1.left_bumper) {
                armTargetPosition -= 10; // Lower the arm
            }

            if (gamepad1.dpad_up) {
                // Collect sample position
                armTargetPosition = 5200;
            }
            else if (gamepad1.dpad_right) {
                // Score sample in low basket position
                armTargetPosition = 3000;
            }
            else if (gamepad1.dpad_down) {
                // Collapsed arm position
                armTargetPosition = 0;
            }
            else if (gamepad1.dpad_left) {
                // Clear barrier position
                armTargetPosition = 4900;
            }

            // Only update target position if it has changed
            if (armMotor.getTargetPosition() != armTargetPosition) {
                armMotor.setTargetPosition(armTargetPosition);
                armMotor.setPower(0.7);
            }

            // Claw control
            if (gamepad1.x) {
                claw1.setPosition(0.4);
                claw2.setPosition(0.2);
            }
            else if (gamepad1.a) {
                claw1.setPosition(0.0);
                claw2.setPosition(0.8);
            }
        }
    }
}
