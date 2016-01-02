package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

public class Autonomous extends RobotDrive {

    public void runOpMode() throws InterruptedException {
        setSweeperPower(.80);
        frontDrive(.80, 4200);
        rightTurn(.80, 1000);
        frontDrive(.80, 6400);
        rightTurn(.80, 500);
        setSweeperPower(0);
        frontDrive(.50, 1500);
        setClimberDrop(1);
    }

}
