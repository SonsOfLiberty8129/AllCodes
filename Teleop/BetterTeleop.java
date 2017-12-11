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
    private DcMotor gripMotor = null;


    public BetterTeleop() {}

    public void init()
    {
        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        gripMotor = hardwareMap.dcMotor.get("gripMotor");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        gripMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void loop()
    {
        leftMotor.setPower(gamepad1.left_stick_y);
        rightMotor.setPower(gamepad1.right_stick_y);

        armMotor.setPower(gamepad2.right_stick_y);
        gripMotor.setPower(gamepad2.right_trigger);
        gripMotor.setPower(-gamepad2.left_trigger);



    }

}


