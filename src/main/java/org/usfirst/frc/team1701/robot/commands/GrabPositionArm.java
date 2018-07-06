/**
 * subsystems/DriveTrain.java
 *
 * @author Noah Husby
 * @since 1/27/18
 * @license BSD-3-Clause
 */

package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class GrabPositionArm extends Command {
    public GrabPositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinished;

    protected void initialize() {}
    protected void execute() {

        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchHighGear();
        isFinished = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getArmAngle()> Robot.position.armGrab + 8) {
            Robot.liftArm.setLiftArm(RobotMap.armSpeed); }
        else if(Robot.liftArm.getArmAngle()< Robot.position.armGrab - 8) {
            Robot.liftArm.setLiftArm(-RobotMap.armSpeed);
        }
        else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.disableWristBrake();
            if(Robot.liftArm.getWristAngle() > Robot.position.wristGrab + 3)
            {
                Robot.liftArm.setWrist(0.50);
            }
            else if(Robot.liftArm.getWristAngle() < Robot.position.wristGrab - 3)
            {
                Robot.liftArm.setWrist(-0.50);
            }
            else
            {
                Robot.liftArm.stopWrist();
                Robot.liftArm.setGrabber(false);
                isFinished = true;
            }
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {
        Robot.liftArm.enableWristBrake();
    }
    protected void interrupted() {}
}