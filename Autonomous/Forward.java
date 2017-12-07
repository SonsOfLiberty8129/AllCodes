package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by daflu on 9/9/2017.
 */
@Autonomous (name = "WorkPls")
public class Forward extends LinearOpMode {

    Trumpware robot = new Trumpware();

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;




        public void runOpMode() throws InterruptedException
        {

            leftMotor = hardwareMap.dcMotor.get("leftDrive");
            rightMotor = hardwareMap.dcMotor.get("rightDrive");


            leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


            waitForStart();

            DriveForwardTime(1, 4000);

        }

    public void DriveForward(double power) {
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
    }

    public void Stop() {

        DriveForward(0);
    }

    public void DriveForwardTime(double power, long time) throws InterruptedException {
        DriveForward(power);
        Thread.sleep(time);

    }
}

