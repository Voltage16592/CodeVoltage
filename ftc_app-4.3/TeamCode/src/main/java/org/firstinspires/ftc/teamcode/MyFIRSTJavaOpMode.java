package org.firstinspires.ftc.teamcode.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MyFIRSTJavaOpMode extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;



    public void MyFIRSTJavaOpMode(String args[]){
        runOpMode();

    }


    @Override
    public void runOpMode() {

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPowerY = 0;
        double tgtPowerX = 0;
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            tgtPowerY = -this.gamepad1.left_stick_y;
            tgtPowerX = -this.gamepad1.right_stick_x;
            if(tgtPowerX != 0 && tgtPowerY == 0){
                if (tgtPowerX < 0){
                    leftMotor.setDirection(DcMotor.Direction.FORWARD);
                    rightMotor.setDirection(DcMotor.Direction.FORWARD);
                }
                else{
                    leftMotor.setDirection(DcMotor.Direction.REVERSE);
                    rightMotor.setDirection(DcMotor.Direction.REVERSE);
                }
                rightMotor.setPower(tgtPowerX);
                leftMotor.setPower(tgtPowerX);
            } else if(tgtPowerY != 0 && tgtPowerX == 0){
                if(tgtPowerY > 0){
                    leftMotor.setDirection(DcMotor.Direction.FORWARD);
                    rightMotor.setDirection(DcMotor.Direction.REVERSE);
                }
                else{
                    leftMotor.setDirection(DcMotor.Direction.REVERSE);
                    rightMotor.setDirection(DcMotor.Direction.FORWARD);
                }
                rightMotor.setPower(tgtPowerY);
                leftMotor.setPower(tgtPowerY);
            }
            else {
                //make sure to try to replace 0.5 with and int for tgtPowerX
                if (gamepad1.b){
                    leftMotor.setPower(0);
                    rightMotor.setPower(0);
                }
                if (tgtPowerX < 0){
                    leftMotor.setDirection(DcMotor.Direction.FORWARD);
                    rightMotor.setDirection(DcMotor.Direction.REVERSE);
                    leftMotor.setPower(0.5 * tgtPowerY);
                    rightMotor.setPower(tgtPowerY);
                }
                else {
                    leftMotor.setDirection(DcMotor.Direction.FORWARD);
                    rightMotor.setDirection(DcMotor.Direction.REVERSE);
                    rightMotor.setPower(0.5 * tgtPowerY);
                    leftMotor.setPower(tgtPowerY);
                }
            }



        }
    }
}