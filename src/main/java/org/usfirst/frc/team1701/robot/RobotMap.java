/**
 * RobotMap.java
 *
 * @author Nicholas Hubbard
 * @since 1/3/19
 * @license BSD-3-Clause
 */
package org.usfirst.frc.team1701.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; // Replaced wildcard import.
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class RobotMap {
  /*
   * Create all static variables, most (exception of logger) filled
   * by the init() method below.
   */
  public static WPI_TalonSRX _leftFrontMotor;
  public static WPI_TalonSRX _leftBackMotor;
  public static WPI_TalonSRX _rightFrontMotor;
  public static WPI_TalonSRX _rightBackMotor;
  public static WPI_TalonSRX wrist;
  public static WPI_TalonSRX winch1;
  public static WPI_TalonSRX winch2;
  public static SpeedControllerGroup _leftMotors;
  public static SpeedControllerGroup _rightMotors;
  public static DifferentialDrive driveTrain;
  public static DoubleSolenoid grabber;
  public static DoubleSolenoid puncher;
  public static DoubleSolenoid driveShift;
  public static DoubleSolenoid winchShift;
  public static DoubleSolenoid winchBrake;
  public static DoubleSolenoid wristBrake;
  public static AnalogInput liftArmEncoder;
  public static AnalogInput wristEncoder;
  public static DigitalInput cubeSensor;
  public static DigitalInput armSensor;
  public static AHRS _navx;
  public static int encPidIdx;
  public static double armSpeed = 1.0;

  /**
   * Initialize the public values above.
   */
  public static void init() {
    _leftFrontMotor = new WPI_TalonSRX(3); //0
    _leftBackMotor = new WPI_TalonSRX(1); //1
    _rightFrontMotor = new WPI_TalonSRX(15); //15
    _rightBackMotor = new WPI_TalonSRX(14); //14
    /**
     * Encoder PID index.
     * @value 0 for primary closed-loop, 1 for cascaded closed-loop.
     */
    encPidIdx = 0;
    /**
     * Initialize all analog and digital objects
     */
    liftArmEncoder = new AnalogInput(0);
    wristEncoder = new AnalogInput(1);
    cubeSensor = new DigitalInput(0);
    armSensor = new DigitalInput(1);

    /**
     * Initialize all non-drivetrain motors/objects.
     */
    winch1 = new WPI_TalonSRX(12);
    winch2 = new WPI_TalonSRX(13);
    wrist = new WPI_TalonSRX(2);
    /**
     * Initialize all pneumatic controllers
     */
    driveShift = new DoubleSolenoid(0,7,0);
    winchShift = new DoubleSolenoid(0,6,1);
    grabber = new DoubleSolenoid(0, 5, 2);
    puncher = new DoubleSolenoid(0,4,3);
    winchBrake = new DoubleSolenoid(1,7,0);
    wristBrake = new DoubleSolenoid(1,6,1);
    /**
     * Create 4-wheel drivetrain object using DifferentialDrive and SpeedControllerGroups.
     */
    _leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftBackMotor);
    _rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightBackMotor);
    driveTrain = new DifferentialDrive(_leftMotors, _rightMotors);
    /**
     * Instantiate NavX.
     */
    _navx = new AHRS(SerialPort.Port.kUSB1);
  }

}
