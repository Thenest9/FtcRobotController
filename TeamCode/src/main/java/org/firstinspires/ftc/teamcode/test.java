package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
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

    CRServo leftIntake;

    CRServo rightIntake;

    //left clockwise
    //right counter

    double motorSpeed = 0.2;

    @Override
    public void init()
    {
        telemetry.addData("Initialize", "called");
        FrontLeft = hardwareMap.get(DcMotor.class,"FrontLeft");// MOTOR 0
        FrontRight = hardwareMap.get(DcMotor.class,"FrontRight");// MOTOR 3
        RearLeft = hardwareMap.get(DcMotor.class,"RearLeft");// MOTOR 1
        RearRight = hardwareMap.get(DcMotor.class,"RearRight");// MOTOR 2

        rightIntake = hardwareMap.get(CRServo.class, "IntakeRight");
        leftIntake = hardwareMap.get(CRServo.class, "IntakeLeft");
    }

    @Override
    public void loop()
    {
        setPowerSpeed();
        ForwardMovement();
        BackwardMovement();
        moveLeft();
        moveRight();
        servoMovement();

    }

    public void servoMovement()
    {
        // To do: Needs more power
        if(gamepad1.triangle)
        {
            // move to 0 degrees.
            leftIntake.setPower(-100);
            rightIntake.setPower(100);
        }
        if(gamepad1.square)
        {
            // move to 0 degrees.
            leftIntake.setPower(100);
            rightIntake.setPower(-100);
        }
        else
        {
            leftIntake.setPower(0.0);
            rightIntake.setPower(0.0);
        }

    }

    public void setPowerSpeed()
    {
        telemetry.addData("setPowerSpeed", "called");
        if(gamepad1.dpadUpWasPressed())
        {
            telemetry.addData("dpad_up", "called");
            //If motor speed is less then 1 then increase by .1
            motorSpeed += motorSpeed < 0.9 ? 0.1 : 0;
        }
        if(gamepad1.dpadDownWasPressed())
        {
            telemetry.addData("dpad_down", "called");
            //If motor speed is greater then -1 then decrease by .1
            motorSpeed += motorSpeed > 0.2 ? -0.1 : 0;
        }

        telemetry.addData("motor_speed", motorSpeed);
    }
    public void setMotorsPower(double fLSpeed,double fRSpeed,double rLSpeed,double rRSpeed)
    {
        FrontLeft.setPower(fLSpeed);
        FrontRight.setPower(fRSpeed);
        RearLeft.setPower(rLSpeed);
        RearRight.setPower(rRSpeed);
    }
    public void ForwardMovement()
    {
    if (gamepad1.left_stick_y < 0 && (gamepad1.left_stick_x>-0.4 && gamepad1.left_stick_x<0.4))// if gamepad1 left joystick is pushed up
    {
        telemetry.addData("Left Joy Stick Y", gamepad1.left_stick_y);

        //Move the robot in the forward direction
        setMotorsPower(-motorSpeed, motorSpeed, -motorSpeed, motorSpeed);
        //                 fL,    FR,             RL           Rr
    }
//        if (gamepad1.left_stick_y > 0.0 && gamepad1.left_stick_x < 0.0)//forward left diagonal
//        {
//            setMotorsPower(0.0, -motorSpeed, motorSpeed, 0.0);
//        }
//
//        if (gamepad1.left_stick_y > 0.0 && gamepad1.left_stick_x > 0.0)//forward right diagonal
//        {
//            setMotorsPower(motorSpeed, 0.0, 0.0, -motorSpeed);
//        }
    else
    {
        FrontLeft.setPower(0.0);
        FrontRight.setPower(0.0);
        RearLeft.setPower(0.0);
        RearRight.setPower(0.0);
    }
}
    public void moveLeft()//Commments are pog
    {
        //will turn left
        //turn left code

        telemetry.addData("joystick X:", gamepad1.left_stick_x);
        if(gamepad1.left_stick_x<0 && (gamepad1.left_stick_y<0.5 && gamepad1.left_stick_y>-0.5))
        {


            setMotorsPower(motorSpeed,motorSpeed,-motorSpeed,-motorSpeed);
        }
        else
        {
            FrontLeft.setPower(0.0);
            FrontRight.setPower(0.0);
            RearLeft.setPower(0.0);
            RearRight.setPower(0.0);

        }//This is a comment
    }
    public void moveRight()
    {

        //will turn right
        if(gamepad1.left_stick_x>0)
        {
            telemetry.addData("joystick X:", gamepad1.left_stick_x);
            setMotorsPower(-motorSpeed,-motorSpeed,motorSpeed,motorSpeed);
//            setMotorsPower(-motorSpeed,-motorSpeed,motorSpeed,-motorSpeed); ROTATE RIGHT????
        }
        else
        {
            FrontLeft.setPower(0.0);
            FrontRight.setPower(0.0);
            RearLeft.setPower(0.0);
            RearRight.setPower(0.0);

        }


    }

    public void BackwardMovement()
    {
        if(gamepad1.left_stick_y > 0)// straight backward
        {
            telemetry.addData("Left Joy Stick -Y", "called");

            //Move the robot in the reverse direction
            setMotorsPower(motorSpeed,-motorSpeed,motorSpeed,-motorSpeed);
        }
//        if (gamepad1.left_stick_y < 0.0 && gamepad1.left_stick_x < 0.0)//Back left diagonal
//        {
//            setMotorsPower(-motorSpeed, 0.0, 0.0, motorSpeed);
//        }
//
//        if (gamepad1.left_stick_y < 0.0 && gamepad1.left_stick_x > 0)//Back right diagonal
//        {
//            setMotorsPower(0.0, motorSpeed, -motorSpeed, 0.0);
        //}// I love typing documentation
        else
        {
            FrontLeft.setPower(0.0);
            FrontRight.setPower(0.0);
            RearLeft.setPower(0.0);
            RearRight.setPower(0.0);
        }
    }


}
