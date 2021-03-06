/**
 * SwitchPositionArm.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class SwitchPositionArm extends Command {
    public SwitchPositionArm() {
        requires(Robot.liftArm);
    }

    private boolean isFinished;


    private void grabWrist() {
        if(Robot.liftArm.getWristAngle() > Robot.position.wristSwitch + 15) {
            Robot.liftArm.setWrist(0.50);
        } else if(Robot.liftArm.getWristAngle() < Robot.position.wristSwitch - 15) {
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

        if(Robot.liftArm.getArmAngle()> Robot.position.armSwitch + 40) {
            Robot.liftArm.setLiftArm(RobotMap.armSpeed);
        } else if(Robot.liftArm.getArmAngle()< Robot.position.armSwitch - 40) {
            Robot.liftArm.setLiftArm(-RobotMap.armSpeed);
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
