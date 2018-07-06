/**
 * Shuffleboard.java
 *
 * @author Noah Husby
 * @since 3/8/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;

public class Shuffleboard {

    public static SendableChooser<Number> autonomousLocation;
    public static SendableChooser<Number> action;

    /**
     * Creates our shuffleboard objects
     */
    public static void init() {
        /*
         * Initialize Autonomous Location Chooser;
         * Allows operator/technician to select robot start position before match
         */
        autonomousLocation = new SendableChooser<>();
        autonomousLocation.addObject("Left",1);
        autonomousLocation.addObject("Left-Switch",4);
        autonomousLocation.addDefault("Middle",2);
        autonomousLocation.addObject("Right-Switch",5);
        autonomousLocation.addObject("Right",3);
        SmartDashboard.putData("Autonomous Location", autonomousLocation);
        /*
         * Initialize Autonomous Chooser
         * Allows operator/technician to select type of autonomous to be run
         */
        action = new SendableChooser<>();
        action.addDefault("Defualt Autonomous", 1);
        action.addObject("Forward Autonomous", 2);
        SmartDashboard.putData("Autonomous Chooser",action);

        /*
         * Shuffleboard elements to be updated during teleop period
         */
        SmartDashboard.putBoolean("Reversed", false);
        SmartDashboard.putString("Current Gear","");
        SmartDashboard.putNumber("Arm",0);
        SmartDashboard.putBoolean("Arm Trigger", false);
        SmartDashboard.putNumber("Drive Train", 0);
        SmartDashboard.putString("GameCode", "");
        SmartDashboard.putNumber("NewEnc",0);

    }

    /**
     * Method called during teleop to update shuffleboard elements live
     */
    public static void updateDashboard() {
        SmartDashboard.putBoolean("Reversed", Robot.driveTrain.getReverse());
        SmartDashboard.putNumber("Arm",Robot.liftArm.getArmAngle());
        SmartDashboard.putNumber("Wrist", Robot.liftArm.getWristAngle());
        SmartDashboard.putBoolean("Arm Trigger", RobotMap.armSensor.get());
        SmartDashboard.putNumber("Drive Train", Robot.driveTrain.getRightDistance());
        SmartDashboard.putNumber("NewEnc",RobotMap.wristEncoder.getValue());

    }





}
