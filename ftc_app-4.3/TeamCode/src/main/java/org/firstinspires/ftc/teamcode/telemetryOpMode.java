package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class telemetryOpMode extends LinearOpMode {



    public void telemetryOpMode(String args[]){
        runOpMode();

    }


    @Override
    public void runOpMode() {


        telemetry.addData("Status", "Initialized Telemetry Mode");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
       while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            telemetry.addData("left stick y", gamepad1.left_stick_y);
           telemetry.addData("right stick y", gamepad1.right_stick_y);





        }
    }
}