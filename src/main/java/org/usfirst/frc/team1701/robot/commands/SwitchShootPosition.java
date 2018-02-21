package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class SwitchShootPosition extends Command {

    public SwitchShootPosition() {
        requires(Robot.liftArm);
    }

    private boolean isFinshed;

    private void stowWrist() {

        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getWristAngle() > Robot.position.wristStow + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristStow - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
            Robot.liftArm.enableWristBrake();
        }
    }
    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristSwitchShoot + 50)
        {
            Robot.liftArm.setWrist(0.50);
        }
        else if(Robot.liftArm.getWristAngle() < Robot.position.wristSwitchShoot - 50)
        {
            Robot.liftArm.setWrist(-0.50);
        }
        else
        {
            Robot.liftArm.stopWrist();
            Robot.liftArm.enableWristBrake();
            isFinshed = true;
        }
    }
    protected void initialize() {}
    protected void execute() {
        Robot.liftArm.winchHighGear();
        isFinshed = false;
        Robot.liftArm.setGrabber(true);

        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitchShoot + 40) {
            Robot.liftArm.setLiftArm(0.35);
            stowWrist();
        }
        else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitchShoot - 40) {
            Robot.liftArm.setLiftArm(-0.35);
            stowWrist();
        }
        else {
            Robot.liftArm.stopLiftArm();
            grabWrist();
        }
    }
    protected boolean isFinished() {
        return isFinshed;
    }
    protected void end() {}
    protected void interrupted() {}
}
