import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by phs-robotics on 10/11/2017.
 */

public class Trumpware {

    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;
    public DcMotor armMotor = null;
    public DcMotor grabMotor = null;
    public CRServo gripServo = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public Trumpware() {
    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor = hwMap.dcMotor.get("leftDrive");
        rightMotor = hwMap.dcMotor.get("rightDrive");
        armMotor = hwMap.dcMotor.get("armMotor");
        grabMotor = hwMap.dcMotor.get("grabMotor");
        gripServo = hwMap.crservo.get("gripServo");

        leftMotor.setPower(0);
        rightMotor.setPower(0);
        armMotor.setPower(0);
        grabMotor.setPower(0);
        gripServo.setPower(0);

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        grabMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void waitForTick(long periodMs) {

        long remaining = periodMs - (long) period.milliseconds();

        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        period.reset();
    }
}
