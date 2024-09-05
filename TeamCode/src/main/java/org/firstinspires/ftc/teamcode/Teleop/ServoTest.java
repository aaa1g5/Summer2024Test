package org.firstinspires.ftc.teamcode.Teleop;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Servo Test", group="TeleOp")
public class ServoTest extends OpMode {

    private Servo testServo;

    @Override
    public void init() {
        testServo = hardwareMap.get(Servo.class, "CRServo0");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            testServo.setPosition(1.0);  // the servo will spin with clock wise
        } else if (gamepad1.b) {
            testServo.setPosition(0.0);  // the servo will spin against clock wise
        } else {
            testServo.setPosition(0.5);  // the servo wil stop spinning
        }
    }
}