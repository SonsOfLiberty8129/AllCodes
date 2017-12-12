import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by phs-robotics on 12/12/2017.
 */
@TeleOp(name = "Arm")
public class Arm extends OpMode {

    private DcMotor Idol_Arm = null;
    private Servo clawServo = null;

    public Arm(){}

    public void init()
    {
        Idol_Arm = hardwareMap.dcMotor.get("IdolArmMotor");
        clawServo = hardwareMap.servo.get("gripServo");
    }

    public void loop()
    {
        Idol_Arm.setPower(gamepad1.left_stick_y);

        if(gamepad1.a)
        {
            clawServo.setPosition(0);
        }
        if(gamepad1.b)
        {
            clawServo.setPosition(0.25);
        }
    }
}
