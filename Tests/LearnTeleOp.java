package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * Created by daflu on 9/10/2017.
 */

@TeleOp(name = "TeleOpTestAgain")

public class LearnTeleOp extends LinearOpMode
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

            robot.leftMotor.setPower(-gamepad1.left_stick_y);
            robot.rightMotor.setPower(-gamepad1.right_stick_y);

            idle();
        }

    }
}
