package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//Created by Jacob Kaiserman
@TeleOp
public class main extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor hanger;
    private Servo drone;

    @Override
    public void runOpMode() throws InterruptedException { //if broken delete throws
        float x;
        float y;
        float clockwise;
        double fl;
        double fr;
        double bl;
        double br;
        double speed = 1;

        //maps hardware
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        hanger = hardwareMap.get(DcMotor.class, "hanger");
        drone = hardwareMap.get(Servo.class, "drone");

        drone = hardwareMap.get(Servo.class, "drone");
        drone.setDirection(Servo.Direction.REVERSE);

        //reverse direction of motors since diagonal axles are reversed
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        if (opModeIsActive()) {
            //set motors to brake
            frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            //arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            drone.setPosition(1);


            while (opModeIsActive()) {
                //sets x & y axis of movement
                x = gamepad1.left_stick_x;
                y = -gamepad1.left_stick_y;
                //sets rotation
                clockwise = gamepad1.right_stick_x;


                telemetry.addData("A", gamepad1.dpad_up);
                //y-axis movement
                if (gamepad1.dpad_up) {
                    y = (float) 1.0;
                } else if (gamepad1.dpad_down) {
                    y = (float) -1.0;
                }

                //x-axis movement
                if (gamepad1.dpad_right) {
                    x = (float) 1.0;
                } else if (gamepad1.dpad_left) {
                    x = (float) -1.0;
                }

                //rotation
                if (gamepad1.back) {
                    clockwise = (float) -1.0;
                } else if (gamepad1.guide) {
                    clockwise = (float) 1.0;
                }
                clockwise /= 2;
                fl = y + x + clockwise;
                fr = y - x - clockwise;
                bl = y - x + clockwise;
                br = y + x - clockwise;

                if(gamepad1.a){
                    hanger.setPower(1);
                }
                else if(gamepad1.b){
                    hanger.setPower(-1);
                }
                else{
                    hanger.setPower(0);
                }

                if(gamepad1.right_bumper){
                    drone.setPosition(0.5);

                }
                if(gamepad1.left_bumper){
                    drone.setPosition(1);

                }

                    speed = 0.5;
                    fl /= speed;
                    fr /= speed;
                    bl /= speed;
                    br /= speed;

                    telemetry.addData("SPEED", speed);
                    telemetry.addData("FLP", fl);
                    telemetry.addData("FRP", fr);
                    telemetry.addData("BLP", bl);
                    telemetry.addData("BRP", br);
                    telemetry.addData("Clockwise", clockwise);
                    telemetry.addData("Arm-L", gamepad1.left_trigger);
                    telemetry.addData("Arm-R", gamepad1.right_trigger);

                    frontLeft.setPower(fl);
                    frontRight.setPower(fr);
                    backLeft.setPower(bl);
                    backRight.setPower(br);

                    telemetry.update();
                }
            }
        }
    }
