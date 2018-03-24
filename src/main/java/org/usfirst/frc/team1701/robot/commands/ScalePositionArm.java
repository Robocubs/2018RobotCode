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

public class ScalePositionArm extends Command {
    public ScalePositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinished;



    private void stowWrist() {

        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50) {
            Robot.liftArm.setWrist(0.50);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50) {
            Robot.liftArm.setWrist(-0.50);
        } else {
            Robot.liftArm.stopWrist();
        }
    }
    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristScale + 15) {
            Robot.liftArm.setWrist(0.50);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristScale - 15) {
            Robot.liftArm.setWrist(-0.50);
        } else {
            Robot.liftArm.stopWrist();
            isFinished = true;
        }
    }
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchHighGear();
        isFinished = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getArmAngle()> Robot.position.armScale + 100) {
            Robot.liftArm.setLiftArm(RobotMap.armSpeed);
            stowWrist();
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armScale - 100) {
            Robot.liftArm.setLiftArm(-RobotMap.armSpeed);
            stowWrist();
        } else {
            Robot.liftArm.stopLiftArm();
            grabWrist();
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