import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by vets-robotics on 12/15/2017.
 */
@Autonomous(name = "AnotherAutonomous")
public class Mr_West1 extends LinearOpMode {

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
    Servo knockServo = null;
    ColorSensor colorSensor = null;
    DcMotor gripper = null;
    DcMotor lifter = null;

    int sleepTimer = 1000;

    // true = red ball
    // YOU RED TEAM SET TRUE
    // YOU BLUE TEAM SET FALSE
    Boolean searchForBlue = false;

    public void runOpMode() {

        leftMotor = hardwareMap.dcMotor.get("leftDrive");
        rightMotor = hardwareMap.dcMotor.get("rightDrive");
        knockServo = hardwareMap.servo.get("knockServo");
        colorSensor = hardwareMap.colorSensor.get("color");
        gripper = hardwareMap.dcMotor.get("cubeGrip");
        lifter = hardwareMap.dcMotor.get("armMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        //gripServo.setPosition(0);
        moveServo(knockServo, 0.55, 500);

        Gripper(1, 2000);

        Lifter(-1, 700);

        DriveTime(-0.25, 850);

        sleep(1000);

        if (searchForBlue) {
            if (colorSensor.red() > 0) {
                moveServo(knockServo, 0, 500);
            } else {
                moveServo(knockServo, 1, 500);
            }
        } else {
            if (colorSensor.red() > 0) {
                moveServo(knockServo, 1, 500);
            } else {
                moveServo(knockServo, 0, 500);
            }
        }

        DriveTime(0.5, 1943);

        turnLeft(1, 1725);

        DriveTime(0.5, 1600);

        turnLeft(1, 500 );

        DriveTime(0.5, 750);

        Lifter(1, 200);

        Gripper(-1, 1200);

        DriveTime(1, 500);

        DriveTime(-1, 200);

    }

    public void DriveTime(double power, long time)
    {
        try {
            leftMotor.setPower(power);
            rightMotor.setPower(-power);
            Thread.sleep(time);
            leftMotor.setPower(0);
            rightMotor.setPower(0);
            sleep(sleepTimer);
        }
        catch(Exception e){

        }

    }

    public void moveServo(Servo servo, double pos, int time){
        knockServo.setPosition(pos);
        sleep(time);
    }

    public void turnLeft(double power, long time)
    {
        try {
            leftMotor.setPower(-power);
            rightMotor.setPower(-power);
            Thread.sleep(time);
            leftMotor.setPower(0);
            rightMotor.setPower(0);
            sleep(sleepTimer);
        }
        catch(Exception e){

        }

    }

    public void Gripper(double power, long time){

        try {
            gripper.setPower(power);
            Thread.sleep(time);
            gripper.setPower(0);
            sleep(sleepTimer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void Lifter(double power, long time) {
        try {
            lifter.setPower(power);
            Thread.sleep(time);
            lifter.setPower(0);
            sleep(sleepTimer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
