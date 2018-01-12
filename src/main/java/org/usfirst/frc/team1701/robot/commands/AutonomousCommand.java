/**
 * commands/AutonomousCommand.java
 *
 * Created by Nicholas Hubbard on 1/10/2018.
 *
 * Copyright (c) 2017 Team 1701 (Robocubs)
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
package org.usfirst.frc.team1701.robot.commands;
import org.usfirst.frc.team1701.robot.Robot;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AutonomousCommand extends Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String gameCode = DriverStation.getInstance().getGameSpecificMessage();
    private static final String switchPosition = gameCode.substring(0, 1);
    private static final Double defaultPosition = 2.0;
    private static final double robotPosition = SmartDashboard.getNumber("Position", defaultPosition);
    public AutonomousCommand() {
        requires(Robot.driveTrain);
    }
    /**
     * Initialize the autonomous command.
     */
    protected void initialize() {}
    /**
     * Execute the autonomous.
     */
    protected void execute() {
        logger.warn("Autonomous command started! May the force be with you.");
        // This is how we figure out what to do. It's a bit rough at best.
        if(switchPosition == "L") {
        	if(robotPosition == 1) {
	            // Take control of left side of switch.
        	}
        } else if(switchPosition == "R") {
        	if(robotPosition == 3) {
        		// Take control of right side of switch.
        	}
        } else {
            // Attempt to cross autonomous line.
        }
    }
    /**
     * Don't stop the party!
     * @return boolean
     */
    protected boolean isFinished() {
        return false;
    }
    /**
     * End the command.
     */
    protected void end() {
        logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
        logger.warn("Just kidding; returning control to user.");
    }
    /**
     * End the command, the hard way.
     */
    protected void interrupted() {
        logger.info("Halt! We are the Knights Who Say Ni! Bring us some shrubbery to continue.");
        logger.warn("Just kidding; returning control to user.");
    }
}