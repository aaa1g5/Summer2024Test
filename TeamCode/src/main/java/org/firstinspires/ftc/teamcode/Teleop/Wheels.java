package org.firstinspires.ftc.teamcode.Teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "robot: aviel", group = "Hydra")
@Config
public class Wheels extends OpMode
{
    BetterGamepad betterGamepad = null;

    DcMotor motorLeftFront = null;
    DcMotor motorLeftBack = null;
    DcMotor motorRightFront = null;
    DcMotor motorRightBack = null;

    double speed = 0;
    double turn = 0;
    double rotation = 0;
    public static double wheelsPower = 1;


    @Override
    public void init(){
        betterGamepad = new BetterGamepad(gamepad1);

        motorLeftFront = hardwareMap.get(DcMotor.class, "mFL");
        motorLeftBack = hardwareMap.get(DcMotor.class, "mBL");
        motorRightFront = hardwareMap.get(DcMotor.class, "mFR");
        motorRightBack = hardwareMap.get(DcMotor.class, "mBR");

        motorLeftFront.setDirection(DcMotor.Direction.FORWARD);  //  FL  FR
        motorLeftBack.setDirection(DcMotor.Direction.FORWARD);   //
        motorRightFront.setDirection(DcMotor.Direction.REVERSE); //  BL  BR
        motorRightBack.setDirection(DcMotor.Direction.FORWARD);  //

    }

    @Override
    public void init_loop(){

    }

    @Override
    public void start(){
        telemetry.addLine("blip, blop. initiated");
        telemetry.update();
    }

    @Override
    public void loop(){
        speed = -gamepad1.left_stick_y;
        turn = -gamepad1.right_stick_x;
        rotation = gamepad1.left_stick_x;

        if (gamepad1.left_stick_button)
        {
            if (wheelsPower == 1)
                wheelsPower = 0.5;
            else
                wheelsPower = 1;
            telemetry.addLine("pressedBbum");
        }

        if (betterGamepad.CirOnce())
        {
            telemetry.addLine("pressedBcir");
        }

        motorLeftFront.setPower( (speed+turn+rotation) * wheelsPower );
        motorRightFront.setPower( (speed-turn-rotation) * wheelsPower );
        motorLeftBack.setPower( (speed+turn-rotation) * wheelsPower );
        motorRightBack.setPower( (speed-turn+rotation) * wheelsPower );

        telemetry.update();
        betterGamepad.update();
        telemetry.clear();
    }

    @Override
    public void stop(){

    }
}
