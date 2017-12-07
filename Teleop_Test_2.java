package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by phs-robotics on 11/6/2017.
 */
@TeleOp (name = "AnotherTeleopTest")
public class Teleop_Test_2 extends LinearOpMode
{
    Trumpware robot = new Trumpware();

    public DcMotor leftMotor;
    public DcMotor rightMotor;

    @Override
    public void runOpMode() {
        double left;
        double right;
        double drive;
        double turn;
        double max;

        robot.init(hardwareMap);

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");

        telemetry.addData("", "Hello Driver");    //
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            drive = -gamepad1.left_stick_y;
            turn  =  gamepad1.right_stick_x;


            left  = drive + turn;
            right = drive - turn;

            max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0)
            {
                left /= max;
                right /= max;
            }

            robot.leftMotor.setPower(left);
            robot.rightMotor.setPower(right);
        }
    }

}
