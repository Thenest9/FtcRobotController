package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "test")
public class test extends OpMode
{

    DcMotor FrontLeft;
    DcMotor FrontRight;
    DcMotor RearLeft;
    DcMotor RearRight;
    @Override
    public void init()
    {
        telemetry.addData("Initialize", "called");
        FrontLeft = hardwareMap.get(DcMotor.class,"FrontLeft");// MOTOR 0
        FrontRight = hardwareMap.get(DcMotor.class,"FrontRight");// MOTOR 1
        RearLeft = hardwareMap.get(DcMotor.class,"RearLeft");// MOTOR 2
        RearRight = hardwareMap.get(DcMotor.class,"RearRight");// MOTOR 3
    }

    @Override
    public void loop()
    {

        ForwardMovement();
    }
    public void turnLeft()
    {
        
    }
    public void ForwardMovement()
    {
        telemetry.addData("Loop", "called");

        if(gamepad2.left_stick_y > 0)// if gamepad2 left joystick is pushed up
        {
            telemetry.addData("Left Joy Stick Y", "called");

            //Move the robot in the forward direction
            FrontLeft.setPower(0.2);
            FrontRight.setPower(-0.2);
            RearLeft.setPower(0.2);
            RearRight.setPower(-0.2);

        }
        if(gamepad2.left_stick_y < 0)// if gamepad2 left joystick is pushed down
        {
            telemetry.addData("Left Joy Stick -Y", "called");

            //Move the robot in the reverse direction
            FrontLeft.setPower(-0.2);
            FrontRight.setPower(0.2);
            RearLeft.setPower(-0.2);
            RearRight.setPower(0.2);
        }
        else
        {
            FrontLeft.setPower(0.0);
            FrontRight.setPower(0.0);
            RearLeft.setPower(0.0);
            RearRight.setPower(0.0);
        }
    }


}
