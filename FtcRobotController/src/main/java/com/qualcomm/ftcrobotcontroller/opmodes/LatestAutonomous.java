package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Owner on 12/23/2015.
 */
public class LatestAutonomous extends RobotDrive {
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;
    DcMotor Sweeper;
    Servo cDrop;

    public void runOpMode() throws InterruptedException {
        RightR = hardwareMap.dcMotor.get("motor_1");
        RightR.setDirection(DcMotor.Direction.REVERSE);
        RightF = hardwareMap.dcMotor.get("motor_2");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        LeftR = hardwareMap.dcMotor.get("motor_3");
        LeftF = hardwareMap.dcMotor.get("motor_4");
        Sweeper = hardwareMap.dcMotor.get("motor_6");
        cDrop = hardwareMap.servo.get("servo_1");

        frontDrive(.80, 4200);
        rightTurn(.80, 1000);
        frontDrive(.80, 7000);
        rightTurn(.80, 500);
        frontDrive(.80, 1400);
        cDrop.setPosition(1);
    }

    public void frontDrive(double speed, int distance) {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while (LeftF.getCurrentPosition() < distance) {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while (LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }

    }

    public void leftTurn(double speed, int distance) {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while (RightF.getCurrentPosition() < distance) {
            LeftF.setPower(-speed);
            LeftR.setPower(-speed);
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while (LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }

    }

    public void rightTurn(double speed, int distance) {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while (LeftF.getCurrentPosition() < distance) {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
            RightF.setPower(-speed);
            RightR.setPower(-speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while (LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }

    }


}
