package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ValuesTesting")
public class ValuesTesting extends OpMode
{

    public void init()
    {

    }
    @Override
    public void loop()
    {
        telemetry.addData("Right trigger:", gamepad1.right_trigger);
        telemetry.addData("Left Joystick:", gamepad1.left_stick_x+" , "+ gamepad1.left_stick_y);
        telemetry.addData("Right Joystick:", gamepad1.right_stick_x+" , "+ gamepad1.right_stick_x);
    }
}
