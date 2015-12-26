package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class EncoderTest extends LinearOpMode
{
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;
    DcMotor Sweeper;
    ColorSensor cSensor;

    @Override
    public void runOpMode()
    {
        RightR = hardwareMap.dcMotor.get("motor_1");
        RightR.setDirection(DcMotor.Direction.REVERSE);
        RightF = hardwareMap.dcMotor.get("motor_2");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        LeftR = hardwareMap.dcMotor.get("motor_3");
        LeftF = hardwareMap.dcMotor.get("motor_4");
        Sweeper = hardwareMap.dcMotor.get("motor_6");
        cSensor = hardwareMap.colorSensor.get("color_sensor");
        cSensor.enableLed(false);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);

      //  waitForStart();

        Sweeper.setPower(-1);
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        while(LeftF.getCurrentPosition() < 3000)
        {
            LeftF.setPower(0.75);
            LeftR.setPower(0.75);
            RightF.setPower(0.75);
            RightR.setPower(0.75);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(RightR.getCurrentPosition() > -3300)
        {

            LeftF.setPower(0);
            LeftR.setPower(0);
            RightF.setPower(0.75);
            RightR.setPower(0.75);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        while(RightF.getCurrentPosition() < 1000)
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0.5);
            RightR.setPower(0.5);
        }
        while(LeftF.getCurrentPosition() < 1000);
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0);
            RightR.setPower(0);
        }
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        Sweeper.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        while(RightF.getCurrentPosition() < 1000)
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0.5);
            RightR.setPower(0.5);
        }
        while(LeftF.getCurrentPosition() < 1000);
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0);
            RightR.setPower(0);
        }
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());

        while(RightF.getCurrentPosition() < 1000)
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0.5);
            RightR.setPower(0.5);
        }
        while(LeftF.getCurrentPosition() < 1000);
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0);
            RightR.setPower(0);
        }
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        while(RightF.getCurrentPosition() < 1000)
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0.5);
            RightR.setPower(0.5);
        }
        while(LeftF.getCurrentPosition() < 1000);
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0);
            RightR.setPower(0);
        }
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        while(RightF.getCurrentPosition() < 1000)
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0.5);
            RightR.setPower(0.5);
        }
        while(LeftF.getCurrentPosition() < 1000);
        {
            LeftF.setPower(0.5);
            LeftR.setPower(0.5);
            RightF.setPower(0);
            RightR.setPower(0);
        }
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        while(LeftF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
        }

        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        telemetry.addData("LeftF Position", LeftF.getCurrentPosition());
    }
}


