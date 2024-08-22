package org.firstinspires.ftc.teamcode.Teleop;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "ROBOT", group = "Linear Opmode")
@Config
public class ROBOT extends OpMode {

    DcMotor motor_elevator = null;
    double power = 0;
    boolean isLastTriggerLeft = false;

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

        motor_elevator = hardwareMap.get(DcMotor.class, "mE");
        motor_elevator.setDirection(DcMotor.Direction.REVERSE);

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

        double power = gamepad1.right_trigger;
        if (gamepad1.right_trigger>0) {
            power = gamepad1.right_trigger;
            isLastTriggerLeft = false;
            telemetry.addLine("right trigger");
        }
        else if (gamepad1.left_trigger>0) {
            power = -gamepad1.left_trigger;
            isLastTriggerLeft = true;
            telemetry.addLine("left trigger");
        }
        else if (isLastTriggerLeft) {
            power = -1;
            telemetry.addLine("left trigger is left");
        }

        motor_elevator.setPower(power);
        telemetry.addLine("the power is: " + power);

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


        motorLeftFront.setPower( (speed+turn+rotation) * wheelsPower );
        motorRightFront.setPower( (speed-turn-rotation) * wheelsPower );
        motorLeftBack.setPower( (speed+turn-rotation) * wheelsPower );
        motorRightBack.setPower( (speed-turn+rotation) * wheelsPower );




        telemetry.update();

    }
    @Override
    public void stop(){

    }
}