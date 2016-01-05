package com.qualcomm.ftcrobotcontroller.opmodes;

public class NewAutonomous extends RobotDrive {

    public void runOpMode() throws InterruptedException {

        initDevices();
        waitForStart();
        fDrive(.80, 14000);
        stopRobot(500);
    }

}
