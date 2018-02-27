/*
 * WallToMiddle.java
 *
 * @author Noah Husby
 * @since 2/22/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands.Auto;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;
public class WallToMiddle extends Command {
    private boolean isFinished = false;
    public WallToMiddle() {
        requires(Robot.driveTrain);
    }
    protected void initialize() {
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {
        isFinished = false;
        if(Robot.driveTrain.getRightDistance() < Robot.position.wallToCube) {
            Robot.driveTrain.teleopControl(-1,0);
        } else  {
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {}
    protected void interrupted() {}
}
