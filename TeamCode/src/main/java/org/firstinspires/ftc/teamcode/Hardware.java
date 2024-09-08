// Created by Jacob Kaiserman
// Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;

// imports necessary components

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class Hardware {

    // Instance Variables
    private LinearOpMode opMode = null;   // gain access to methods in the calling OpMode.
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;

    // Defines the Hardware constructor
    public Hardware (LinearOpMode newOpMode) {
        opMode = newOpMode;
        opMode.init();
    }
    
    public void init(){

    }

    public void moveForward(){

    }

    public void moveBackward(){

    }

    public void moveRight(){

    }

    public void moveLeft(){

    }

}
