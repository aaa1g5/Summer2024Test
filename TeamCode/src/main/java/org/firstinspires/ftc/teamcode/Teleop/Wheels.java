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

    DcMotor motorLeftFront = null;
    DcMotor motorLeftBack = null;
    DcMotor motorRightFront = null;
    DcMotor motorRightBack = null;

    double lY = 0;
    double rY = 0;
    double lX = 0;
    double rX = 0;
    public static double wheelsPower = 0.25;


    @Override
    public void init(){
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
        telemetry.addLine("WE ARE VENOM!");
        telemetry.update();

    }

    @Override
    public void loop(){
        telemetry.addLine("WE ARE VENOM!!");
        telemetry.update();

        if (gamepad1.square){
            telemetry.addLine("pressed square");
            wheelsPower = 0.5;
        }
        if (gamepad1.circle){
            telemetry.addLine("pressed square");
            wheelsPower = 0.25;
        }

        motorLeftFront.setPower(wheelsPower);
        motorRightFront.setPower(wheelsPower);
        motorLeftBack.setPower(wheelsPower);
        motorRightBack.setPower(wheelsPower);
        wheelsPower = 0;

        telemetry.update();

    }

    @Override
    public void stop(){

    }
}
