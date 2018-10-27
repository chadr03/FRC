package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command is simply a pause that will cause the drivetrain to do nothing for a given time
 * 
 * Arguments
 * wait - length of pause in seconds
 * 
 * @author Chad
 *
 */


public class Pause extends Command {
	private final double waitTime;
	
    public Pause(double wait) {
    	waitTime=wait;
    }

    protected void initialize() {
        setTimeout(waitTime);  
    }

    protected void execute() {
    	Robot.driveTrain.drive(0,0); // do nothing 
    }

    protected boolean isFinished() {
        // waits for timed out
        return isTimedOut();
    }

    protected void end() {
    	Robot.driveTrain.drive(0,0);  // stop
    }

    protected void interrupted() {
    	end();
    }
}