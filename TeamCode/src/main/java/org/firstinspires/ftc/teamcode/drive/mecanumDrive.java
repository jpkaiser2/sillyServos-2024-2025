package org.firstinspires.ftc.teamcode.drive;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Hardware;

// Defines as TeleOp
@TeleOp
public class mecanumDrive extends LinearOpMode {

    // Instance Variables
    public LinearOpMode opMode = null; // Declare your opMode here
    public Hardware robot = new Hardware(opMode);

    // Main function
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init();
    }

}
