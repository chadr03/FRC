package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Pause extends Command {
	private final double waitTime;
	
    public Pause(double wait) {
    	waitTime=wait;
    }

    protected void initialize() {
        setTimeout(waitTime);  // set 4 second timeout
    }

    protected void execute() {
    	Robot.driveTrain.drive(0,0); // do nothing turning
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