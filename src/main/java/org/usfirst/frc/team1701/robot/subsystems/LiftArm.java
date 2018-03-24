/**
 * subsystems/LiftArm.java
 *
 * @author Noah Husby & Steven Wall
 * @since 1/16/18
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1701.robot.Robot;
import org.usfirst.frc.team1701.robot.RobotMap;
public class LiftArm extends Subsystem {
  /*
   * Hardware references.
   */
  private final AnalogInput liftArmEncoder = RobotMap.liftArmEncoder;
  private final WPI_TalonSRX wrist = RobotMap.wrist;
  private final WPI_TalonSRX winch1 = RobotMap.winch1;
  private final WPI_TalonSRX winch2 = RobotMap.winch2;
  private final WPI_TalonSRX wristEncoder = wrist;
  private final DoubleSolenoid grabber = RobotMap.grabber;
  private final DoubleSolenoid winchBrake = RobotMap.winchBrake;
  private final DoubleSolenoid winchShift = RobotMap.winchShift;
  private final DoubleSolenoid puncher = RobotMap.puncher;
  private final DoubleSolenoid wristBrake = RobotMap.wristBrake;
  /*
   * Value references.
   */
  private final int encPidIdx = RobotMap.encPidIdx;
  /**
   * Sets the winches to brake mode
   */
  public void enableWinchBrake() {
    winchBrake.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Disables winch brake
   */
  public void disableWinchBrake() {
    winchBrake.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Enables wrist brake
   */
  public void enableWristBrake()
  {
      wristBrake.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Disables wrist brake
   */
  public void disableWristBrake()
  {
      wristBrake.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Sets winch gear to low
   */
  public void winchLowGear()
  {
    winchShift.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Sets winch gear to high
   */
  public void winchHighGear()
  {
    winchShift.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Return arm angle.
   * @return arm angle as double
   */
  public double getArmAngle() {
    return liftArmEncoder.getValue();
  }
  /**
   * Return wrist angle.
   * @return wrist angle as double.
   */
  public double getWristAngle() {
    //return wristEncoder.getSelectedSensorPosition(encPidIdx);
    return RobotMap.wristEncoder.getValue();
  }
  /**
   * Set the clamp position.
   * @param State true for enabled, false for disabled.
   */
  public void setGrabber(boolean State) {
    if(State) {
      grabber.set(DoubleSolenoid.Value.kReverse);
    } else {
     grabber.set(DoubleSolenoid.Value.kForward);
    }
  }

  /**
   * Sets speed of the arm, as well as disabling the brake
   * @param input -1 to 1 as speed for the arm
   */
  public void setLiftArm(double input) {
    disableWinchBrake();
    winch1.set(checkArmZone(input));
    winch2.set(checkArmZone(input));

  }
  /**
   * Disables wrist motors, enables winch brake
   */
  public void stopLiftArm()
  {
    winch1.stopMotor();
    winch2.stopMotor();
    Timer.delay(0.05);
    enableWinchBrake();
  }
  /**
   * Pushes puncher out to push cube
   */
  public void extendPuncher() {
    puncher.set(DoubleSolenoid.Value.kForward);
  }
  /**
   * Pulls puncher into normal state
   */
  public void retractPuncher()
  {
    puncher.set(DoubleSolenoid.Value.kReverse);
  }
  /**
   * Stops the wrist motor, automatically enables wrist brake
   */
  public void stopWrist()
  {
    wrist.stopMotor();
  }
  /**
   * Sets speed of wrist motor, automatically disables brake
   * @param speed to set wrist motor
   */
  public void setWrist(double speed) {
    wrist.set(speed);
  }
  /**
   * Gets the current state of switches on grabber
   * @return Boolean of CubeSensor
   */
  public boolean getCubeSensor()
  {
    return RobotMap.cubeSensor.get();
  }
  public double checkArmZone(double speed) {
    if(RobotMap.armSensor.get() && speed > 0) {
      return 0;
    }
    return speed;
  }
  public void initDefaultCommand() {}
}
