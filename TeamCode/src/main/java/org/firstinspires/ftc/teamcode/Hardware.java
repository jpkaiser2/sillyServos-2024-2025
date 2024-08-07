//Created by Jacob Kaiserman
//Silly Servos FTC Team #24213 - https://github.com/jpkaiser2/sillyServos
package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
public class Hardware {

    /* Declare OpMode members. */
    private LinearOpMode myOpMode = null;   // gain access to methods in the calling OpMode.

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)

    private DcMotor frontLeft = null;
    private DcMotor backLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backRight = null;
    private DcMotor arm = null;
    private Servo drone = null;
   // private DcMotor hanger = null;



    // Define a constructor that allows the OpMode to pass a reference to itself.
    public Hardware (LinearOpMode opmode) {
        myOpMode = opmode;
    }

    public void init(){
        drone = myOpMode.hardwareMap.get(Servo.class, "drone");
        drone.setDirection(Servo.Direction.REVERSE);

        frontLeft = myOpMode.hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = myOpMode.hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = myOpMode.hardwareMap.get(DcMotor.class, "frontRight");
        backRight = myOpMode.hardwareMap.get(DcMotor.class, "backRight");
       // hanger = myOpMode.hardwareMap.get(DcMotor.class, "hanger");
        //arm = myOpMode.hardwareMap.get(DcMotor.class, "arm");

        // To drive forward, the motor on one side needs to be reversed because the axles point in opposite directions.
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        myOpMode.telemetry.addData(">", "Hardware Initialized");
        myOpMode.telemetry.update();
    }


    //call drive function to drive in x direction for n ticks
    public void drive(String direction, double power, long time) {
        //switch statement for different directions
        switch(direction){
            case "stop":
                //code to stop
                frontLeft.setPower(0);
                frontLeft.setPower(0);
                backLeft.setPower(0);
                frontRight.setPower(0);
                backRight.setPower(0);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "stopped");
                break;
            case "forward":
                //code for forward
                frontLeft.setPower(power);
                frontLeft.setPower(power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved forward");
                break;
            case "backward":
                //code for backward
                frontLeft.setPower(-power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(-power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved backward");
                break;
            case "left":
                //code for left
                frontLeft.setPower(-power);
                backLeft.setPower(power);
                frontRight.setPower(power);
                backRight.setPower(-power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved left");
                break;
            case "right":
                //code for right
                frontLeft.setPower(power);
                backLeft.setPower(-power);
                frontRight.setPower(-power);
                backRight.setPower(power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved right");
                break;
            default:
                myOpMode.telemetry.addData(">", "no direction set");
                myOpMode.telemetry.update();
        }

    }
    public void turn(String direction, double power, long time) {
        switch(direction){
            case "left":
                //code for forward
                frontLeft.setPower(-power);
                backLeft.setPower(-power);
                frontRight.setPower(power);
                backRight.setPower(power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved forward");
                break;
            case "right":
                //code for backward
                frontLeft.setPower(power);
                backLeft.setPower(power);
                frontRight.setPower(-power);
                backRight.setPower(-power);
                myOpMode.sleep(time);
                myOpMode.telemetry.addData(">", "moved backward");
                break;
            default:
                myOpMode.telemetry.addData(">", "no direction set");
                myOpMode.telemetry.update();
        }
    }
    public void stop(){
        frontLeft.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        myOpMode.sleep(100);
        myOpMode.telemetry.addData(">", "stopped");
    }


}
