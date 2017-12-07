import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

/**
 * Created by phs-robotics on 11/6/2017.
 */
@TeleOp (name = "MinuteMan")
public class LiterativeTeleOp extends OpMode
{

    Trumpware robot = new Trumpware();

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor armMotor;
    DcMotor grabMotor;
    CRServo gripServo;

    public double deadzone = 0.1;

    @Override
    public void init()
    {
        robot.init(hardwareMap);

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        grabMotor = hardwareMap.dcMotor.get("grabMotor");
        gripServo = hardwareMap.crservo.get("gripServo");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
}

    @Override
    public void loop() {

        double leftPower = -this.gamepad1.left_stick_y;
        double rightPower = -this.gamepad1.right_stick_y;
        double grabPower = -this.gamepad2.left_stick_y;
        double armPower = this.gamepad2.right_stick_y;
        double gripPower = this.gamepad2.right_trigger;

        if (Math.abs(leftPower) < deadzone)
        {
            leftPower = 0;
        }

        if (Math.abs(rightPower) < deadzone)
        {
            rightPower = 0;
        }

        if (Math.abs(armPower) < deadzone)
        {
            armPower = 0;
        }

        if (Math.abs(grabPower) < deadzone)
        {
            grabPower = 0;
        }

        if (Math.abs(gripPower) < deadzone)
        {
            gripPower = 0;
        }


        leftMotor.setPower(Range.clip(leftPower, -1, 1));
        rightMotor.setPower(Range.clip(rightPower, -1, 1));
        grabMotor.setPower(Range.clip(grabPower, -1, 1));
        armMotor.setPower(Range.clip(armPower, -1, 1));
        gripServo.setPower(Range.clip(gripPower, 0, -0.5));



    }

    @Override
    public void stop()

    {}


}


