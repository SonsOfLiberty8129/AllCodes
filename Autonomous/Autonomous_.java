import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by phs-robotics on 12/7/2017.
 */
@Autonomous(name = "MinuteMan")
public class Autonomous_ extends LinearOpMode {

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    Servo knockServo = null;
    ColorSensor color_sensor = null;
    DcMotor gripMotor = null;

    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        gripMotor = hardwareMap.dcMotor.get("gripMotor");

        knockServo = hardwareMap.servo.get("knockServo");

        color_sensor = hardwareMap.colorSensor.get("color");

        waitForStart();

        CubeGrip(0.8, 1000);

        ForwardDistance(-0.5, 5);

        Stop(3000);

        color_sensor.enableLed(true);

        while (color_sensor.red() <20)
        {
            knockServo.setPosition(0.5);
        }
        while(color_sensor.blue() <20)
        {
            knockServo.setPosition(1);
        }

        ForwardDistance(0.5, 30);

        Turn(0.5, 17);

        ForwardDistance(0.5,36);

        Turn(0.5, 17);

        CubeGrip(0.8, 1000);


    }

    public void ForwardDistance(double power, int distance)
    {
        leftMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);

        leftMotor.setTargetPosition(distance);
        rightMotor.setTargetPosition(distance);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DriveForward(power);

        while(leftMotor.isBusy() && rightMotor.isBusy());


        stop();
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void DriveForward(double power)
    {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    public void Stop(double time)
    {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void Turn (double power, int distance)
    {
        leftMotor.setMode(DcMotor.RunMode.RESET_ENCODERS);

        leftMotor.setTargetPosition(distance);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        DriveForward(power);

        while(leftMotor.isBusy() && rightMotor.isBusy());


        stop();
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void CubeGrip (double power, long time) throws InterruptedException
    {
        gripMotor.setPower(power);
        Thread.sleep(time);
    }

}
