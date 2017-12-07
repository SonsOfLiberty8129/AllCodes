import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by phs-robotics on 9/29/2017.
 */
@Autonomous(name = "Sensors")
public class Sensors extends LinearOpMode{

    ColorSensor color_Sensor;


    DcMotor motorLeft = null;
    DcMotor motorRight = null;




    public void runOpMode() throws InterruptedException
    {

        color_Sensor = hardwareMap.colorSensor.get("color");
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");


        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        waitForStart();

        color_Sensor.enableLed(true);

        while (color_Sensor.red() <20)
        {
            DriveForwardTime(0.6, 4000);
        }

        while(color_Sensor.blue() <20)
        {

            BackwardsTime(-0.6, 2000);

        }

    }

    public void DriveForward(double power) {
        motorLeft.setPower(power);
        motorRight.setPower(power);
    }

    public void Stop() {

        DriveForward(0);
    }

    public void DriveForwardTime(double power, long time) throws InterruptedException
    {
        DriveForward(power);
        Thread.sleep(time);

    }

    public void BackwardsTime(double power, long time) throws InterruptedException
    {
        DriveForwardTime(-power, time);
    }
}
