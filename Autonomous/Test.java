import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by phs-robotics on 12/14/2017.
 */
@Autonomous(name = "Test")
public class Test extends LinearOpMode {

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    Servo knockServo = null;
    ColorSensor color_sensor = null;
    Servo gripServo = null;

    // true = red ball
    Boolean blue = false;

    public void runOpMode() {

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        knockServo = hardwareMap.servo.get("knockServo");
        color_sensor = hardwareMap.colorSensor.get("color");
        gripServo = hardwareMap.servo.get("gripServo");

        waitForStart();

        gripServo.setPosition(0);
        knockServo.setPosition(0.55);

        sleep(1000);

            // 365ms
            //DriveTime(-0.5, 400);
            //rightMotor.setPower(0);
            //leftMotor.setPower(0);

        sleep(1000);

        color_sensor.enableLed(true);

        while(true){
            if(!blue){
                if(color_sensor.red() > 0){
                    knockServo.setPosition(0.8);
                }
                else{
                    knockServo.setPosition(0.2);
                }
            }
            else {
                if(color_sensor.red() > 0) {
                    knockServo.setPosition(0.2);
                }
                else {
                    knockServo.setPosition(0.8);
                }
            }
        }

        //stop();

    }

    public void DriveTime(double power, long time)
    {
        try {
            leftMotor.setPower(power);
            rightMotor.setPower(-power);
            Thread.sleep(time);
        }
        catch(Exception e){

        }

    }

    public void RedBall(){
        knockServo.setPosition(0.25);
        //stop();
    }

    public void BlueBall(){
        knockServo.setPosition(1);
        //stop();
    }
}

