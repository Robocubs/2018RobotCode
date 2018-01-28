/**
 * commands/EndClamp.java
 *
 * @author Noah Husby
 * @since 1/2/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1701.robot.Robot;

public class EndClimb extends Command {
  private boolean isFinished = true;

  public EndClimb() {

  }
  //it needs to use a winch to work. Therefore it requires winch ^^
  protected void initalize() {}

  protected void execute() {

  }
  //The whole purpose of this class is right above. It ends the winch from moving

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {}

  protected void interrupted() {}
}
