package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.hardware.Gamepad;

public class BetterGamepad {
    private final Gamepad gamepad;

    private int dpad_up, dpad_down, dpad_left, dpad_right;
    private int tri, cir, x, squ;
    private int left_bumper, right_bumper;
    private int share, touchpad;
    private int left_stick_button;

    public double left_stick_x, right_stick_x, left_stick_y, right_stick_y;
    public double left_trigger, right_trigger;

    public BetterGamepad(Gamepad g) {
        gamepad = g;
    }

    public void update() {
        if (gamepad.triangle) { ++tri; } else { tri = 0; }
        if (gamepad.circle) { ++cir; } else { cir = 0; }
        if (gamepad.x) { ++x; } else { x = 0; }
        if (gamepad.square) { ++squ; } else { squ = 0; }
        if (gamepad.dpad_up) { ++dpad_up; } else { dpad_up = 0; }
        if (gamepad.dpad_down) { ++dpad_down; } else { dpad_down = 0; }
        if (gamepad.dpad_left) { ++dpad_left; } else { dpad_left = 0; }
        if (gamepad.dpad_right) { ++dpad_right; } else { dpad_right = 0; }
        if (gamepad.left_bumper) { ++left_bumper; } else { left_bumper = 0; }
        if (gamepad.right_bumper) { ++right_bumper; } else { right_bumper = 0; }
        if (gamepad.share) { ++share; } else { share = 0; }
        if (gamepad.touchpad) { ++touchpad; } else { touchpad = 0; }
        if (gamepad.left_stick_button) {++left_stick_button; } else {left_stick_button =0; }

        left_stick_x = gamepad.left_stick_x;
        left_stick_y = gamepad.left_stick_y;
        right_stick_x = gamepad.right_stick_x;
        right_stick_y = gamepad.right_stick_y;
        left_trigger = gamepad.left_trigger;
        right_trigger = gamepad.right_trigger;
    }

    public boolean dpadUp() { return 0 < dpad_up; }
    public boolean dpadDown() { return 0 < dpad_down; }
    public boolean dpadLeft() { return 0 < dpad_left; }
    public boolean dpadRight() { return 0 < dpad_right; }
    public boolean Tri() { return 0 < tri; }
    public boolean Cir() { return 0 < cir; }
    public boolean X() { return 0 < x; }
    public boolean Squ() { return 0 < squ; }
    public boolean leftBumper() { return 0 < left_bumper; }
    public boolean rightBumper() { return 0 < right_bumper; }

    public boolean shareOnce() { return 1 == share; }
    public boolean touchpadOnce() { return 1 == touchpad; }
    public boolean dpadUpOnce() { return 1 == dpad_up; }
    public boolean dpadDownOnce() { return 1 == dpad_down; }
    public boolean dpadLeftOnce() { return 1 == dpad_left; }
    public boolean dpadRightOnce() { return 1 == dpad_right; }
    public boolean TriOnce() { return 1 == tri; }
    public boolean CirOnce() { return 1 == cir; }
    public boolean XOnce() { return 1 == x; }
    public boolean SquOnce() { return 1 == squ; }
    public boolean leftBumperOnce() { return 1 == left_bumper; }
    public boolean rightBumperOnce() { return 1 == right_bumper; }

    public boolean leftStickButton() { return 1 == left_stick_button; }

}