package org.firstinspires.ftc.teamcode.autonomous;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectorySequence;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RoadRunner Example")
public class vvv extends BaseAutonomous {

    @Override
    public void runOpMode() throws InterruptedException {
        // יצירת מיקום התחלתי
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));

        // הגדרת מיקום התחלתי עבור הרובוט
        drive.setPoseEstimate(startPose);

        // יצירת מסלול (Trajectory) שזז קדימה 60 ס"מ
        Trajectory traj1 = drive.trajectoryBuilder(startPose)
                .forward(60)
                .build();

        // יצירת מסלול שני שמבצע סיבוב של 90 מעלות
        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                .turn(Math.toRadians(90))
                .build();

        waitForStart();

        if (isStopRequested()) return;

        // נסיעה במסלול הראשון
        drive.followTrajectory(traj1);

        // נסיעה במסלול השני
        drive.followTrajectory(traj2);
                }
}