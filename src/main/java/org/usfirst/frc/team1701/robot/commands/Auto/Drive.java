package org.usfirst.frc.team1701.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1701.robot.Robot;

public class Drive extends Command {
    boolean isFinished = false;
    double distance = 0;
    double currentSpeed;
    double startAngle;
    boolean setHighGear = false;

    public Drive(double distance,double speed) {
        Robot.driveTrain.driveSpeed = 0;

        requires(Robot.driveTrain);
        this.distance = distance;
        this.currentSpeed = speed;
    }
    public Drive(double distance, double speed, boolean setHighGear) {
        this(distance,speed);
        this.setHighGear = setHighGear;
    }
    protected void initialize() {
        startAngle = Robot.driveTrain.getNavxAngle();
        Robot.driveTrain.resetEncoders();
    }
    protected void execute() {

        if(!setHighGear) {
            Robot.driveTrain.setLowGear();
        } else {
            Robot.driveTrain.setHighGear();
        }

        SmartDashboard.putNumber("Drive Train", Robot.driveTrain.getRightDistance());

        if(Robot.driveTrain.getRightDistance() < distance) {
            Robot.driveTrain.driveSpeed = -currentSpeed;
            Robot.driveTrain.setAngle(startAngle);
            Robot.driveTrain.startPID();
        } else {
            Robot.driveTrain.stopPID();
            Robot.driveTrain.stopMotors();
            isFinished = true;
        }
    }
    protected boolean isFinished() {
        return isFinished;
    }
    protected void end() {
        Robot.driveTrain.stopPID();
    }
    protected void interrupted() {}
}
