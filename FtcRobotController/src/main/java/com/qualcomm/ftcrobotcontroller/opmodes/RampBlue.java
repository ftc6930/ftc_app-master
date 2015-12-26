package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class RampBlue extends LinearOpMode
{
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;
    ColorSensor cSensor;

    @Override
    public void runOpMode() throws InterruptedException
    {
        RightR = hardwareMap.dcMotor.get("motor_1");
        RightR.setDirection(DcMotor.Direction.REVERSE);
        RightF = hardwareMap.dcMotor.get("motor_2");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        LeftR = hardwareMap.dcMotor.get("motor_3");
        LeftF = hardwareMap.dcMotor.get("motor_4");
        cSensor = hardwareMap.colorSensor.get("color_sensor");
        cSensor.enableLed(false);

        LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);

        waitForStart();

        LeftF.setTargetPosition(2000);
        LeftR.setTargetPosition(2000);
        RightF.setTargetPosition(2000);
        RightR.setTargetPosition(2000);

        LeftF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        LeftR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        LeftF.setPower(0.5);
        LeftR.setPower(0.5);
        RightF.setPower(0.5);
        RightR.setPower(0.5);

        if(LeftF.getCurrentPosition() > 1950 && LeftR.getCurrentPosition() > 1950 && RightF.getCurrentPosition() > 1950 && RightR.getCurrentPosition() > 1950)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }

        LeftF.setTargetPosition(3000);
        LeftR.setTargetPosition(3000);

        LeftF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        LeftR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        LeftF.setPower(0.5);
        LeftR.setPower(0.5);
        RightF.setPower(0);
        RightR.setPower(0);

        if(LeftF.getCurrentPosition() > 2950 && LeftR.getCurrentPosition() > 2950)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }

        LeftF.setTargetPosition(4000);
        LeftR.setTargetPosition(4000);
        RightF.setTargetPosition(4000);
        RightR.setTargetPosition(4000);

        LeftF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        LeftR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        LeftF.setPower(0.5);
        LeftR.setPower(0.5);
        RightF.setPower(0.5);
        RightR.setPower(0.5);

        if(LeftF.getCurrentPosition() > 3950 && LeftR.getCurrentPosition() > 3950 && RightF.getCurrentPosition() > 3950 && RightR.getCurrentPosition() > 3950)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }
}

