package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * FourWheelDrive Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class FourWheelDrive extends OpMode
{
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;

    /**
     * Constructor
     */
    public FourWheelDrive() {}

    @Override
    public void init()
    {
        RightF = hardwareMap.dcMotor.get("motor_1");
        RightR = hardwareMap.dcMotor.get("motor_2");
        LeftF = hardwareMap.dcMotor.get("motor_3");
        LeftR = hardwareMap.dcMotor.get("motor_4");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        RightR.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        float throttle = -gamepad1.left_stick_y;
        if (throttle >= 0)
        {
            throttle = throttle * throttle;
        }
        else
        {
            throttle = -throttle * throttle;
        }

        float direction = gamepad1.left_stick_x;
        if (direction >= 0)
        {
            direction = direction * direction;
        }
        else
        {
            direction = -direction * direction;
        }
        float right = throttle - direction;
        right = right / 2;
        float left = throttle + direction;
        left = left / 2;
        RightF.setPower(right);
        RightR.setPower(right);
        LeftF.setPower(left);
        LeftR.setPower(left);

		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */
        telemetry.addData("Text", "*** Robot Data***");
        //telemetry.addData("arm", "arm:  " + String.format("%.2f", armPosition));
        //telemetry.addData("claw", "claw:  " + String.format("%.2f", clawPosition));
        telemetry.addData("left tgt pwr", "left  pwr: " + String.format("%.2f", left));
        telemetry.addData("right tgt pwr", "right pwr: " + String.format("%.2f", right));

    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop(){}
}