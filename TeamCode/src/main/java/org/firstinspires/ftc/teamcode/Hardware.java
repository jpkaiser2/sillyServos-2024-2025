//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos-2024-2025
package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
public class Hardware {

    // gain access to methods in the calling OpMode.
    private LinearOpMode myOpMode = null;

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    public DcMotor frontLeftMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backRightMotor = null;



    // Defines a constructor that allows the OpMode to pass a reference to itself.
    public Hardware (LinearOpMode opmode) {
        myOpMode = opmode;
    }

    public void init() {
        // Declare motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeft");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeft");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRight");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRight");

        // Reverse the left front motor.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }

}
