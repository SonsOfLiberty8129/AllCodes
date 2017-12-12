import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by phs-robotics on 12/6/2017.
 */
@TeleOp(name = "Commander")
public class BetterTeleop extends OpMode {

    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    private DcMotor armMotor = null;
    private DcMotor cubeGrip = null;
    private DcMotor Idol_Arm = null;
    private Servo clawServo = null;



    public BetterTeleop() {}

    public void init()
    {
        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        cubeGrip = hardwareMap.dcMotor.get("cubeGrip");
        Idol_Arm = hardwareMap.dcMotor.get("IdolArmMotor");
        clawServo = hardwareMap.servo.get("gripServo");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        cubeGrip.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void loop()
    {
        leftMotor.setPower(gamepad1.left_stick_y);
        rightMotor.setPower(gamepad1.right_stick_y);

        armMotor.setPower(gamepad2.left_stick_y);

        if(gamepad2.dpad_right)
        {
            cubeMotor(1, 0.5);

            Stop();
        }
        if(gamepad2.dpad_left)
        {
            cubeMotor(-1  , 0.5);

            Stop();
        }

        Idol_Arm.setPower(-gamepad2.right_stick_y);

        if(gamepad2.a)
        {
            clawServo.setPosition(0);
        }
        if(gamepad2.b)
        {
            clawServo.setPosition(0.25);
        }


    }
    public void cubeMotor (int distance, double power)
    {
        cubeGrip.setMode(DcMotor.RunMode.RESET_ENCODERS);

        cubeGrip.setTargetPosition(distance);

        cubeGrip.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        cubeGrip.setPower(power);
    }

    public void Stop()
    {
        cubeGrip.setPower(0);
    }

}


