package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotDrive extends LinearOpMode
{
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;
    DcMotor Sweeper;
    Servo cDrop;
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
        Sweeper = hardwareMap.dcMotor.get("motor_6");
//        cSensor = hardwareMap.colorSensor.get("color_sensor");
//        cSensor.enableLed(false);
    }

    public void fDrive(double speed, int distance)
    {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while (LeftF.getCurrentPosition() < distance)
        {
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

    public void rDrive(double speed, int distance)
    {
        speed = -speed;
        distance = -distance;
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(LeftF.getCurrentPosition() > distance)
        {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);

        while(LeftF.getCurrentPosition() < -5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }

    public void pTurnLeft(double speed, int distance)
    {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(RightF.getCurrentPosition() < distance)
        {
            LeftF.setPower(-speed);
            LeftR.setPower(-speed);
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);

        while(RightF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }

    public void pTurnRight(double speed, int distance)
    {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(LeftF.getCurrentPosition() < distance)
        {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
            RightF.setPower(-speed);
            RightR.setPower(-speed);
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
        }
    }

    public void tLeft(double speed, int distance)
    {
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(RightF.getCurrentPosition() < distance)
        {
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);

        while(RightF.getCurrentPosition() > 5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }

    public void tRight(double speed, int distance)
    {
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(LeftF.getCurrentPosition() < distance)
        {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
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
        }
    }

    public void rTurnRight(double speed, int distance)
    {
        distance = -distance;
        speed = -speed;
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(RightF.getCurrentPosition() > distance)
        {
            RightF.setPower(speed);
            RightR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);

        while(RightF.getCurrentPosition() < -5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }

    public void rTurnLeft(double speed, int distance)
    {
        speed = -speed;
        distance = -distance;
        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        while(LeftF.getCurrentPosition() > distance)
        {
            LeftF.setPower(speed);
            LeftR.setPower(speed);
        }

        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);

        while(LeftF.getCurrentPosition() < -5)
        {
            LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
            RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        }
    }

    public void stopRobot(long time) throws InterruptedException
    {
        LeftF.setPower(0);
        LeftR.setPower(0);
        RightF.setPower(0);
        RightR.setPower(0);
        LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        sleep(time);
    }
}