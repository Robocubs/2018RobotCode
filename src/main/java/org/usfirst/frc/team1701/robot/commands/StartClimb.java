/**
 * commands/StartClimb.java
 *
 * @author Steven Wall
 * @since 1/9/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.RobotMap;

public class StartClimb extends Command {
  private boolean isFinished = false;
  public void winchStart() {
    RobotMap.winch1.set(1);
    RobotMap.winch2.set(1);
  }
  protected void initalize() {}

  protected void execute() {
    winchStart();
  }
  //Similar to the retractarm, we dont have an end for the winch yet
  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {}

  protected void interrupted() {}
}
