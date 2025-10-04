package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "test")
public class test extends OpMode
{

    DcMotor A;
    DcMotor B;
    DcMotor C;
    DcMotor D;
    @Override
    public void init()
    {

//        telemetry.update();
    }

    @Override
    public void loop()
    {
        telemetry.addData("Hugo", "is a PROBLEM CHILD");
    }
}
