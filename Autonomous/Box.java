package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.io.InterruptedIOException;

/**
 * Created by phs-robotics on 10/11/2017.
 */
@Autonomous
public class Box extends LinearOpMode {

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

        DriveForwardTime(0.6, 5000);

        TurnRightTime(0.6, 1000);

        DriveForwardTime(0.6, 5000);

        TurnRightTime(0.6, 1000);

        DriveForwardTime(0.6, 5000);

        TurnRightTime(0.6, 1000);

        DriveForwardTime(0.6, 5000);

    }

    public void TurnLeftTime (double power, long time) throws InterruptedException
    {

        TurnLeft(power);
        Thread.sleep(time);

    }

    public void TurnRightTime (double power, long time) throws InterruptedException
    {

        TurnRight(power);
        Thread.sleep(time);

    }

    public void DriveForwardTime (double power, long time) throws InterruptedException
    {

        DriveForward(power);
        Thread.sleep(time);

    }

    public void DriveForward (double power)
    {

        leftMotor.setPower(-power);
        rightMotor.setPower(power);

    }

    public void TurnRight (double power)
    {

        leftMotor.setPower(power);
        rightMotor.setPower(power);

    }

    public void TurnLeft (double power)
    {

        leftMotor.setPower(-power);
        rightMotor.setPower(-power);

    }
}
