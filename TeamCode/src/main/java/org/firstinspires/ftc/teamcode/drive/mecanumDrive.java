// Do not use this file. It is inefficient. Use main.java instead.


package org.firstinspires.ftc.teamcode.drive;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import org.firstinspires.ftc.teamcode.Hardware;

// Defines as TeleOp
@TeleOp
public class mecanumDrive extends LinearOpMode {

    // Instance Variables
    public LinearOpMode opMode = null; // Declare your opMode here
    public Hardware robot = new Hardware(opMode);

    final double speedFactor = 0.5;

    // Main function
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
        waitForStart();

        if (opModeIsActive()) {
            //set motors to brake
            robot.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        }
    }
}
