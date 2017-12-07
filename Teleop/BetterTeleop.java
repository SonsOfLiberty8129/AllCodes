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
    private DcMotor grabMotor = null;
    private Servo gripServo = null;

    public BetterTeleop() {}

    public void init()
    {
        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        grabMotor = hardwareMap.dcMotor.get("grabMotor");
        gripServo = hardwareMap.servo.get("gripServo");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        gripServo.setPosition(0.55941);
    }

    public void loop()
    {


        leftMotor.setPower(-gamepad1.left_stick_y);
        rightMotor.setPower(-gamepad1.right_stick_y);

        armMotor.setPower(-gamepad2.right_stick_y);
        grabMotor.setPower(gamepad2.left_stick_y);

        if (gamepad2.y) {
            gripServo.setPosition(1);
        } else
        {
            gripServo.setPosition(0);
        }
    }
}

