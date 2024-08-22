package org.firstinspires.ftc.teamcode.Teleop;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Expention Elevator", group = "Linear Opmode")
@Config
public class ExpantionElavator extends OpMode {

    DcMotor motor_elevator = null;
    double power = 0;
    boolean isLastTriggerLeft = false;

    @Override
    public void init(){

        motor_elevator = hardwareMap.get(DcMotor.class, "mE");
        motor_elevator.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void init_loop(){

    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){

//        power = gamepad1.right_trigger;
//        if (gamepad1.right_trigger>0) {
//            power = gamepad1.right_trigger;
//            isLastTriggerLeft = false;
//            telemetry.addLine("right trigger");
//        }
//        else if (gamepad1.left_trigger>0) {
//            power = -gamepad1.left_trigger;
//            isLastTriggerLeft = true;
//            telemetry.addLine("left trigger");
//        }
//        else if (isLastTriggerLeft) {
//            power = -1;
//            telemetry.addLine("left trigger is left");
//        }
//
//        motor_elevator.setPower(power);
//        telemetry.addLine("the power is: " + power);
//
//
//        telemetry.update();

    }
    @Override
    public void stop(){

    }
    public void expention()
    {
        power = gamepad1.right_trigger;
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


        telemetry.update();
    }
}