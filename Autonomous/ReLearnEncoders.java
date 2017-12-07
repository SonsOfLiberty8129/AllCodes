import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by dafluff on 9/9/2017.
 */
@Autonomous (name = "ReLearnEncoders")

public class ReLearnEncoders extends LinearOpMode  {
// Declare variables
    DcMotor motorLeft = null;
    DcMotor motorRight = null;

    public void runOpMode() throws InterruptedException
    {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        ForwardDistance(0.6, 48);
    }

    public void ForwardDistance(double power, int distance)
    {

      motorLeft.setMode(DcMotor.RunMode.RESET_ENCODERS);
      motorRight.setMode(DcMotor.RunMode.RESET_ENCODERS);

      motorLeft.setTargetPosition(distance);
      motorRight.setTargetPosition(distance);

      motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

      DriveForward(power);

      while(motorLeft.isBusy() && motorRight.isBusy());


      Stop();
      motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void DriveForward(double power)
    {
        motorLeft.setPower(power);
        motorRight.setPower(power);
    }

    public void Stop()
    {
        DriveForward(0);
    }

}
