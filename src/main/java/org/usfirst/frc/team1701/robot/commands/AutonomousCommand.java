/**
 * commands/AutonomousClamp.java
 *
 * @author Nicholos Hubbard
 * @since 12/29/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.usfirst.frc.team1701.robot.Robot;
public class AutonomousCommand extends Command {
  //private static final Logger logger = LogManager.getLogger();

    /**
     * distance = wheel_circumference * wheel_rotations
     * wheel_rotations = distance / wheel_circumference
     *
     * wheel_circumference = 4 * pi
     * distance = X - 38 (Robot Length)
     */

 private static String gameCode;
  private static Double defaultPosition = 2.0;

  private static final double robotPosition = SmartDashboard.getNumber("Position", defaultPosition);
  private static  char switchPosition;
  private static boolean targets = Robot.vision.getTarget();
  private static double allienceToLineDistance = 10.35;

  /*
   Booleans to check current states of autonomous
   */

  private static boolean forwardState;
  private static boolean turnState;
  private static boolean dropState;


  public AutonomousCommand() {
    requires(Robot.driveTrain);
  }

    /**
     * Resets the states, so that autonomous knows where its at.
     */
    private void initilaizeStates() {
        forwardState = false;
        turnState = false;
        dropState = false;
    }
  /** Initialize the autonomous command. */
  protected void initialize() {
     gameCode = DriverStation.getInstance().getGameSpecificMessage();
     if (gameCode == null) {
       gameCode = "LRL";
     }
     switchPosition  = gameCode.charAt(0);
     initilaizeStates();
  }
  /** Execute the autonomous. */
  protected void execute() {
    //logger.warn("Autonomous command started! May the force be with you.");
    // This is how we figure out what to do. It's a bit rough at best.

    switch(switchPosition) {
      case 'L':
        if (robotPosition == 1 && targets) {

        }
      case 'R':
        if (robotPosition == 3 && targets) {
          // Take control of right side of switch.

            /*
             * Checks if any autonomous has started yet
             */
            if(!forwardState && !turnState && !dropState)
            {
                forwardState = true;
            }

            if(Robot.driveTrain.getEncoderDistance() < allienceToLineDistance && forwardState)
            {
                Robot.driveTrain.setLowGear();
                Robot.driveTrain.leftDriveControl(0.75);
                Robot.driveTrain.rightDriveControl(0.75);
            }
            else if(forwardState)
            {
                Robot.driveTrain.stopMotors();
                forwardState = false;
            }
        }
      default:
        // Attempt to cross autonomous line.
    }

  }

  /**
   * Don't stop the party!
   *
   * @return boolean
   */
  protected boolean isFinished() {
    return false;
  }
  /** End the command. */
  protected void end() {
    //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
    //logger.warn("Just kidding; returning control to user.");
  }
  /** End the command, the hard way. */
  protected void interrupted() {
    //logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
    //logger.warn("Just kidding; returning control to user.");
  }
}
