package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class TestTeleop extends OpMode
{
    double cPosition;
    double cDelta = 0.02;
    /*
        double z1Position;
        double z2Position;
        double z1Delta = 0.02;
        double z2Delta = 0.02;
    */
    double wPosition;
    double wDelta = 0.01;
    double lPosition;
    double lDelta = 0.02;
    double rPosition;
    double rDelta = 0.02;
    double fPosition;
    double fDelta = 0.01;
    double sSpeed = 0;
    double sDelta = 1;
    float right;
    float left;
    float dSwitch = 1;
    float lSwitch = 1;
    double bPosition;
    DcMotor RightF;
    DcMotor RightR;
    DcMotor LeftF;
    DcMotor LeftR;
    DcMotor Winch;
    DcMotor Sweeper;
    DcMotor RollP;
    DcMotor Lift;
    Servo cDrop;
    Servo winchAngle;
    Servo churroLatch;
    Servo rotBox;
    Servo Flip;
    Servo Brake;
//  Servo zipLine1;
//  Servo zipLine2;

    public TestTeleop() {}

    @Override
    public void init()
    {
        RightR = hardwareMap.dcMotor.get("motor_1");
        RightR.setDirection(DcMotor.Direction.REVERSE);
        RightF = hardwareMap.dcMotor.get("motor_2");
        RightF.setDirection(DcMotor.Direction.REVERSE);
        LeftR = hardwareMap.dcMotor.get("motor_3");
        LeftF = hardwareMap.dcMotor.get("motor_4");
        Winch = hardwareMap.dcMotor.get("motor_5");
        Sweeper = hardwareMap.dcMotor.get("motor_6");
        RollP = hardwareMap.dcMotor.get("motor_7");
        Lift = hardwareMap.dcMotor.get("motor_8");
        cDrop = hardwareMap.servo.get("servo_1");
        Brake = hardwareMap.servo.get("servo_2");
        cPosition = 0.0;

/*
        zipLine1 = hardwareMap.servo.get("servo_2");
        zipLine2 = hardwareMap.servo.get("servo_7");
        z1Position = 1.0;
        z2Position = 0.0;
*/
        winchAngle = hardwareMap.servo.get("servo_3");
        wPosition = 0.3;
        churroLatch = hardwareMap.servo.get("servo_4");
        lPosition = 0.0;
        rotBox = hardwareMap.servo.get("servo_5");
        rPosition = 0.0;
        Flip = hardwareMap.servo.get("servo_6"); //Door
        fPosition = 0.0;
        bPosition = 0.7;
    }

    @Override
    public void loop()
    {
/*        LeftF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        LeftR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightF.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        RightR.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
*/
        float throttleL = -gamepad1.left_stick_y;
        float throttleR= -gamepad1.right_stick_y;
        if (throttleL >= 0)
        {
            throttleL = throttleL * throttleL;
        } else
        {
            throttleL = -throttleL * throttleL;
        }
        if (throttleR >= 0)
        {
            throttleR = throttleR * throttleR;
        } else
        {
            throttleR = -throttleR * throttleR;
        }
        float direction = gamepad1.left_stick_x;
        if (direction >= 0)
        {
            direction = direction * direction;
        } else
        {
            direction = -direction * direction;
        }
        if (gamepad1.dpad_left)
        {
            dSwitch += 2;
        }
        if (gamepad1.dpad_right)
        {
            dSwitch -= 2;
        }
        dSwitch = Range.clip(dSwitch, -1, 1);
        if(dSwitch > 0)
        {
            right = throttleL - direction;
            left = throttleL + direction;
            right = Range.clip(right, -1, 1);
            left = Range.clip(left, -1, 1);
        }
        if(dSwitch < 0)
        {
            right = -throttleL;
            left = -throttleR;
        }
        RightF.setPower(right);
        RightR.setPower(right);
        LeftF.setPower(left);
        LeftR.setPower(left);

        if(gamepad1.a)
        {
            sSpeed = -1;
        }
        if(gamepad1.b)
        {
            sSpeed = 0;
        }
        if(gamepad1.y)
        {
            sSpeed = 1;
        }
        Sweeper.setPower(sSpeed);

        if (gamepad1.right_bumper)
        {
            cPosition += cDelta;
        }
        if (gamepad1.right_trigger > 0)
        {
            cPosition -= cDelta;
        }
        cPosition = Range.clip(cPosition, 0, 1);
        cDrop.setPosition(cPosition);

        if (gamepad1.left_bumper)
        {
            lPosition += lDelta;
        }
        if (gamepad1.left_trigger > 0)
        {
            lPosition -= lDelta;
        }
        lPosition = Range.clip(lPosition, 0, 1);
        churroLatch.setPosition(lPosition);

/*
        if (gamepad2.right_trigger > 0)
        {
            zPosition -= zDelta;
        }
        if (gamepad2.right_bumper)
        {
            zPosition += zDelta;
        }
        zPosition = Range.clip(zPosition, 0, 1);
        zipLine.setPosition(zPosition);

        if (gamepad2.left_trigger > 0)
        {
            z2Position -= z2Delta;
        }
        if (gamepad2.left_bumper)
        {
            z2Position += z2Delta;
        }
        z2Position = Range.clip(z2Position, 0, 1);
        zipLine2.setPosition(z2Position);
*/
        if (gamepad2.dpad_left)
        {
            lSwitch += 2;
        }
        if (gamepad2.dpad_right)
        {
            lSwitch -= 2;
        }
        lSwitch = Range.clip(lSwitch, -1, 1);
        if(lSwitch > 0)
        {
            Lift.setPower(gamepad2.right_stick_y);
            rPosition = gamepad2.left_stick_x;
            rPosition = rPosition/2;
            rPosition += 0.542;
            if(gamepad2 .left_stick_x == -1)
            {
                rPosition = 0;
            }
            rPosition = Range.clip(rPosition, 0, 1);
            rotBox.setPosition(rPosition);
            Winch.setPower(0);
            RollP.setPower(0);
            if(gamepad2.x)
            {
                fPosition = 0.5;
//                fPosition += fDelta;
            }
            if(gamepad2.b)
            {
                fPosition = 0.1;
//                fPosition -= fDelta;
            }
//            fPosition = Range.clip(fPosition, 0, 1);
            wPosition = 0.3;
        }
        if(lSwitch < 0)
        {
            Winch.setPower(gamepad2.right_stick_y);
            RollP.setPower(gamepad2.left_stick_y);
            if(gamepad2.right_trigger > 0.5)
            {
                Lift.setPower(1);
            }
            else
            {
                Lift.setPower(0);
            }

            rotBox.setPosition(0.5);
            fPosition = 0.1;
            if (gamepad2.y)
            {
                wPosition -= wDelta;
            }
            if (gamepad2.a)
            {
                wPosition += wDelta;
            }
            wPosition = Range.clip(wPosition, 0, 1);
            if(gamepad2.right_stick_button)
            {
                bPosition = 1;
            }
            if(gamepad2.left_stick_button)
            {
                bPosition = 0.7;
            }
        }
        Flip.setPosition(fPosition);
        winchAngle.setPosition(wPosition);
        Brake.setPosition(bPosition);

        telemetry.addData("Box Left-Right", rPosition);
        telemetry.addData("Box Flip", fPosition);
        telemetry.addData("climber drop", String.format("%.2f", cPosition));
        //telemetry.addData("zip servo", String.format("%.2f", z1Position));
        telemetry.addData("left pwr", String.format("%.2f", left));
        telemetry.addData("right pwr", String.format("%.2f", right));
    }

    @Override
    public void stop(){}
}