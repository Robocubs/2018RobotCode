/**
 * OI.java
 *
 * Created by Noah Husby on 1/6/2018.
 *
 * Copyright (c) 2018 Team 1701 (Robocubs)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * Neither the name of the project's author nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.usfirst.frc.team1701.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.usfirst.frc.team1701.robot.commands.*;

public class OI {

    public static Joystick drive_FB;
    public static Joystick drive_T;
    public static Joystick operation;
    public static JoystickButton gearMode;
    public static JoystickButton resetGyro;
    public static JoystickButton preciseMode;
    public static JoystickButton turboMode;
    public static JoystickButton extendArm;
    public static JoystickButton retractArm;
    public static JoystickButton climber;
    private static final Logger logger = LogManager.getLogger();

    public OI() {

        logger.info("Assigning joystick values...");
        //Assign joysticks addresses (from DriverStation)
        operation = new Joystick(0);
        drive_FB = new Joystick(1);
        drive_T = new Joystick(2);

        gearMode = new JoystickButton(operation, 1);
        resetGyro = new JoystickButton(operation, 2);
        preciseMode = new JoystickButton(operation, 3);
        turboMode = new JoystickButton(operation, 4);
        extendArm = new JoystickButton(operation,5); //Placeholder Value... To Be Changed
        extendArm.whenPressed(new ExtendLiftArm());
        extendArm.whenReleased(new StopLiftArm());
        retractArm = new JoystickButton(operation,6); //Placeholder Value... To Be Changed
        retractArm.whenPressed(new RetractLiftArm());
        retractArm.whenReleased(new StopLiftArm());
        climber = new JoystickButton(operation, 7);
        climber.whenPressed(new StartClimb());
        climber.whenReleased(new EndClimb());


    }

    public Joystick getDrive_FB() {
        return drive_FB;
    }

    public Joystick getDrive_T() {
        return drive_T;
    }

    public Joystick getOperation() {
        return operation;
    }
}