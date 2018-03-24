package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class ClimbPositionArm extends Command {
    public ClimbPositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinished;
    protected void initialize() {}
    protected void execute() {

        Robot.liftArm.disableWristBrake();
        Robot.liftArm.winchHighGear();
        isFinished = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getArmAngle()> Robot.position.armClimb + 100) {
            Robot.liftArm.setLiftArm(RobotMap.armSpeed); }
        else if(Robot.liftArm.getArmAngle()< Robot.position.armClimb - 100) {
            Robot.liftArm.setLiftArm(-RobotMap.armSpeed);
        } else {
            Robot.liftArm.stopLiftArm();
            Robot.liftArm.disableWristBrake();
            if(Robot.liftArm.getWristAngle() > Robot.position.wristClimb + 15) {
                Robot.liftArm.setWrist(0.50);
            }
            else if(Robot.liftArm.getWristAngle() < Robot.position.wristClimb - 15) {
                Robot.liftArm.setWrist(-0.50);
            }
            else {
                isFinished = true;
                Robot.liftArm.stopWrist();
            }
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {
    }
    protected void interrupted() {}
}
