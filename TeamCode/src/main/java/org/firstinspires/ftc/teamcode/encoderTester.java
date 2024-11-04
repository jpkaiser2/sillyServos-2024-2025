package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class encoderTester extends LinearOpMode {

    private encoderDriveObject robotDrive;

    @Override
    public void runOpMode() {
        // Initialize the RobotDrive object
        robotDrive = new encoderDriveObject(this);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // Run the movement sequence
        movementSequence();

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }

    public void movementSequence() {
        // Move forward
        robotDrive.encoderDrive(encoderDriveObject.DRIVE_SPEED, 24, 24, 24, 24, 5.0);  // All wheels forward

        // Strafe right
        robotDrive.strafeDrive(encoderDriveObject.DRIVE_SPEED, 12, 5.0);

        // Rotate clockwise
        robotDrive.encoderDrive(encoderDriveObject.TURN_SPEED, 12, -12, 12, -12, 4.0);  // Rotate right

        // Move backward
        robotDrive.encoderDrive(encoderDriveObject.DRIVE_SPEED, -12, -12, -12, -12, 4.0);  // All wheels backward
    }
}
