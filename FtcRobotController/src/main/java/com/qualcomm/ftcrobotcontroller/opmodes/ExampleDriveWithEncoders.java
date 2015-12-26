package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class ExampleDriveWithEncoders extends OpMode {

    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;

    final static int ENCODER_CPR = 1440;     //Encoder Counts per Revolution
    final static double GEAR_RATIO = 2;      //Gear Ratio
    final static int WHEEL_DIAMETER = 4;     //Diameter of the wheel in inches
    final static int DISTANCE = 24;          //Distance in inches to drive

    final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;

    @Override
    public void init()
    {
        RightR = hardwareMap.dcMotor.get("motor_1");
        RightR.setDirection(DcMotor.Direction.REVERSE);
        RightF = hardwareMap.dcMotor.get("motor_2");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        LeftR = hardwareMap.dcMotor.get("motor_3");
        LeftF = hardwareMap.dcMotor.get("motor_4");
        LeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void start() {
        LeftF.setTargetPosition((int) COUNTS);
        LeftR.setTargetPosition((int) COUNTS);
        RightF.setTargetPosition((int) COUNTS);
        RightR.setTargetPosition((int) COUNTS);

        LeftF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        LeftR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        RightR.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        LeftF.setPower(0.5);
        LeftR.setPower(0.5);
        RightF.setPower(0.5);
        RightR.setPower(0.5);
    }

    @Override
    public void loop() {
        telemetry.addData("Motor Target", COUNTS);
        telemetry.addData("Left Position", LeftF.getCurrentPosition());
        telemetry.addData("Right Position", RightF.getCurrentPosition());
    }
}

