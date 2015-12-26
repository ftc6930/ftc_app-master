package com.qualcomm.ftcrobotcontroller.opmodes;

import android.graphics.Color;

import com.qualcomm.hardware.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * TeleOp Mode
 * <p>
 * Enables control of the robot via the gamepad
 */
public class cSensorTest extends OpMode
{
    ColorSensor cSensor;
    /**
     * Constructor
     */
    public cSensorTest() {}

    @Override
    public void init()
    {
        cSensor = hardwareMap.colorSensor.get("color_sensor");
    }

    @Override
    public void loop()
    {

        cSensor.enableLed(true);
		/*
		 * Send telemetry data back to driver station. Note that if we are using
		 * a legacy NXT-compatible motor controller, then the getPower() method
		 * will return a null value. The legacy NXT-compatible motor controllers
		 * are currently write only.
		 */
        telemetry.addData("Blue", cSensor.blue());
        telemetry.addData("Red", cSensor.red());

    }

    /*
     * Code to run when the op mode is first disabled goes here
     *
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#stop()
     */
    @Override
    public void stop(){}
}