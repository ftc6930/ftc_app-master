package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.hardware.DcMotor;

public class AutoTestTwoTeleOp extends PushBotTelemetry {

    public AutoTestTwoTeleOp () {

    }
    @Override public void start () {
        super.start ();

        reset_drive_encoders ();
    }

    @Override public void loop () {
        DcMotor Right;
        DcMotor Left;
        DcMotor BackLeft;
        DcMotor BackRight;


        Right = hardwareMap.dcMotor.get("motor_2");
        Left = hardwareMap.dcMotor.get("motor_4");
        BackRight = hardwareMap.dcMotor.get("motor_1");
        BackLeft = hardwareMap.dcMotor.get("motor_3");

        Right.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        reset_drive_encoders();





        switch (v_state) {

            case 0:

                reset_drive_encoders ();


                v_state++;

                break;

            case 1:

                run_using_encoders ();

                //Left.setPower(0.5);
                //Right.setPower(0.5);
                //BackLeft.setPower(0.5);
                //BackRight.setPower(0.5);
                drive_using_encoders(0.5, 0.5, 2880, 2880);

                if (have_drive_encoders_reached (2880, 2880)) {

                    reset_drive_encoders();

                    Left.setPower(0);
                    Right.setPower(0);
                    BackLeft.setPower(0);
                    BackRight.setPower(0);


                    v_state++;
                }
                break;

            case 2:
                if (have_drive_encoders_reset ()) {
                    v_state++;
                }
                break;

            case 3:
                run_using_encoders ();
                //Left.setPower(0.5);
                //Right.setPower(-0.5);
                //BackLeft.setPower(0.5);
                //BackRight.setPower(-0.5);
                drive_using_encoders(0.5, -0.5, 2180, 2180);

                if (have_drive_encoders_reached (2180, 2180)) {

                    reset_drive_encoders ();
                    Left.setPower(0);
                    Right.setPower(0);
                    BackLeft.setPower(0);
                    BackRight.setPower(0);
                    v_state++;
                }
                break;

            case 4:
                if (have_drive_encoders_reset ()) {
                    v_state++;
                }
                break;

            case 5:
                run_using_encoders ();
                //Left.setPower(0.5);
                //Right.setPower(0.5);
                //BackLeft.setPower(0.5);
                //BackRight.setPower(0.5);
                drive_using_encoders(0.5, 0.5, 5760, 5760);

                if (have_drive_encoders_reached (5760, 5760)) {

                    reset_drive_encoders ();
                    Left.setPower(0);
                    Right.setPower(0);
                    BackLeft.setPower(0);
                    BackRight.setPower(0);
                    v_state++;
                }
                break;

            case 6:
                if (have_drive_encoders_reset ()) {
                    v_state++;
                }
                break;

            default:

                break;

        }


        update_telemetry (); // Update common telemetry
        telemetry.addData ("18", "State: " + v_state);

    }
    /**
     * This class member remembers which state is currently active.  When the
     * start method is called, the state will be initialized (0).  When the loop
     * starts, the state will change from initialize to state_1.  When state_1
     * actions are complete, the state will change to state_2.  This implements
     * a state machine for the loop method.
     */
    private int v_state = 0;

}
