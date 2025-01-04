package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.roadrunner.*;

import java.lang.Math;


@Autonomous(name = "BlueRightAuto1", group = "Autonomous")
public class BlueRightAuto1 extends LinearOpMode {

    public class Arm {
        private DcMotorEx armMotor;

        public Arm() {
            armMotor = hardwareMap.get(DcMotorEx.class, "armMotor");
            armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        public class MoveArm implements Action {
            private int targetPosition;
            private boolean initialized = false;

            public MoveArm(int targetPosition) {
                this.targetPosition = targetPosition;
            }

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    armMotor.setTargetPosition(targetPosition);
                    armMotor.setPower(0.7);
                    initialized = true;
                }
                packet.put("Arm Position", armMotor.getCurrentPosition());
                return armMotor.isBusy();
            }
        }

        public Action moveToPosition(int position) {
            return new MoveArm(position);
        }
    }

    public class Claw {
        private Servo claw1, claw2;

        public Claw() {
            claw1 = hardwareMap.get(Servo.class, "claw1");
            claw2 = hardwareMap.get(Servo.class, "claw2");
        }

        public class SetClaw implements Action {
            private double position1, position2;

            public SetClaw(double position1, double position2) {
                this.position1 = position1;
                this.position2 = position2;
            }

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                claw1.setPosition(position1);
                claw2.setPosition(position2);
                return false;
            }
        }

        public Action setPosition(double position1, double position2) {
            return new SetClaw(position1, position2);
        }
    }

    @Override
    public void runOpMode() {
        Pose2d startPose = new Pose2d(-24.03, 68.65, 0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);
        Arm arm = new Arm();
        Claw claw = new Claw();

        // Create the first trajectory action using lineToX and lineToY
        TrajectoryActionBuilder traj1 = drive.actionBuilder(startPose)
                .lineToX(48.68)
                .lineToY(43.30);

        // Create the second trajectory action
        TrajectoryActionBuilder trag2 = drive.actionBuilder(new Pose2d(48.68, 43.30, 0))
                .lineToX(59.12)
                .lineToY(59.02);

        Actions.runBlocking(claw.setPosition(0, 0.8));

        waitForStart();
        if (isStopRequested()) return;

        Actions.runBlocking(
                new SequentialAction(
                        traj1.build(),
                        arm.moveToPosition(ArmPresets.ARM_COLLECT_SAMPLE),
                        claw.setPosition(0.4, 0.2),
                        arm.moveToPosition(ArmPresets.ARM_SCORE_SAMPLE_LOW),
                        trag2.build(),
                        claw.setPosition(0, 0.8)
                )
        );
    }
}
