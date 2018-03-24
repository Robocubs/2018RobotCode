package org.usfirst.frc.team1701.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Position extends Subsystem {

    /*
     * Wrist values for positions
     */
    public double wristStow = -44;
    public double wristGrab = 1980;
    public double wristScale = 1958;
    public double wristClimb = 2007;
    public double wristSwitch = 1723;
    public double wristSwitchShoot = 1911;
    public double startPosition = 1868;

    /*
     * Arm value for positions
     */
    public double armGrab = 48;
    public double armScale = 1994;
    public double armClimb = 1645;
    public double armSwitch = 1185;
    public double armSwitchShoot = 224;

    /*
     * Values for autonomous
     */

    public double autonomousSpeed = 0.90;
    public double wallToStraightSwitch = 7;

    public boolean isReleasePressed = false;



    @Override
    protected void initDefaultCommand() {

    }
}
