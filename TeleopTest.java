package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by daflu on 9/10/2017.
 */

@TeleOp(name = "TeleOpTest")

public class TeleOpTest extends LinearOpMode
{
    Trumpware robot   = new Trumpware();

    public DcMotor leftMotor;
    public DcMotor rightMotor;


    @Override
    public void runOpMode() throws InterruptedException
    {

        robot.init(hardwareMap);

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");

        robot.leftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive())
        {
            double power;

            if (gamepad1.a)
                power = 1;
            else
                power = 1;

            leftMotor.setPower(power);
            rightMotor.setPower(power);

            idle();

        }

    }
}
