package org.firstinspires.ftc.teamcode.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
class MyFIRSTJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");

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
            tgtPowerX = -this.gamepad2.right_stick_x;
            if(tgtPowerX != 0 && tgtPowerY == 0){
                rightMotor.setPower(tgtPowerX);
                leftMotor.setPower(-tgtPowerX);
            } else if(tgtPowerY != 0 && tgtPowerX == 0){
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
                    leftMotor.setPower(0.5 * tgtPowerY);
                    rightMotor.setPower(tgtPowerY);
                }
                else {
                    rightMotor.setPower(0.5 * tgtPowerY);
                    leftMotor.setPower(tgtPowerY);
                }
            }



        }
    }
}
