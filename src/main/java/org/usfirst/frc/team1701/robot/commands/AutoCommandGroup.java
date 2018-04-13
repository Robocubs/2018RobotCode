/**
 * commands/AutoCommandGroup.java
 *
 * @author Noah Husby
 * @since 12/29/17
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.commands.Auto.*;

public class AutoCommandGroup extends CommandGroup {
    //private static final Logger logger = LogManager.getLogger();

    /**
     * distance = wheel_circumference * wheel_rotations
     * wheel_rotations = distance / wheel_circumference
     * <p>
     * wheel_circumference = 4 * pi
     * distance = X - 38 (Robot Length)
     */
    private static char switchPosition;
    private static char scalePosition;

    public AutoCommandGroup(String gameCode, Number action, Number autoLocation) {
        switchPosition = gameCode.charAt(0);
        scalePosition = gameCode.charAt(1);

        switch ((int) action) {
            case 1:
                placeCubeAutonomous((int) Robot.shuffleboard.autonomousLocation.getSelected());
                SmartDashboard.putString("GameCode", gameCode);
                break;

            case 2:
                addSequential(new Drive(11,0.6));
                break;
        }

    }

    private void placeCubeAutonomous(int autoLocation) {
        if (autoLocation == 1) {
            //Left
            switch (scalePosition) {
                case 'L':
                    Robot.driveTrain.setAutoGear(false);
                    Robot.driveTrain.setLowGear();
                    addSequential(new Drive(21,0.82));
                    addSequential(new Turn(135));
                    addSequential(new ScalePosition());
                    addSequential(new ReleaseAndPunch());
                    break;
                case 'R':
                    addSequential(new Drive(10,0.8));
                    break;
            }
        } else if (autoLocation == 2) {
            //Middle
            switch (switchPosition) {
                case 'L':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(1,0.8));
                    addSequential(new Turn(29));
                    addSequential(new Drive(7,.9));
                    addSequential(new ReleaseAndPunch());
                    break;
                case 'R':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(1,0.8));
                    addSequential(new Turn(-27));
                    addSequential(new Drive(7,.9));
                    addSequential(new ReleaseAndPunch());

                    break;
            }
        } else if (autoLocation == 3) {
            //Right
            switch (scalePosition) {
                case 'L':
                    addSequential(new Drive(10,0.8));
                    break;
                case 'R':
                    Robot.driveTrain.setAutoGear(false);
                    Robot.driveTrain.setLowGear();
                    addSequential(new Drive(21,0.82));
                    addSequential(new Turn(-135));
                    addSequential(new ScalePosition());
                    addSequential(new ReleaseAndPunch());
                    break;
            }

        } else if (autoLocation == 4) {
            //Left-Switch
            switch (switchPosition) {
                case 'L':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(Robot.position.wallToStraightSwitch,Robot.position.autonomousSpeed));
                    addSequential(new ReleaseCube());
                    break;
                case 'R':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(Robot.position.wallToStraightSwitch,Robot.position.autonomousSpeed));
                    break;
            }
        } else if (autoLocation == 5) {
            //Right-Switch
            switch (switchPosition) {
                case 'L':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(Robot.position.wallToStraightSwitch,Robot.position.autonomousSpeed));
                    break;
                case 'R':
                    addSequential(new SwitchPosition());
                    addSequential(new Drive(Robot.position.wallToStraightSwitch,Robot.position.autonomousSpeed));
                    addSequential(new ReleaseCube());
                    break;
            }
        } else if (autoLocation == 6) {
            addSequential(new Turn(-90));
        }
    }
}



