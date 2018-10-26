package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightGyro extends Command {
	private final double waitTime;
	private final double power;
	private final double kP;
	
	
    public DriveStraightGyro(double wait, double power, double kP) {
    	waitTime=wait;
    	this.power=power;
    	this.kP=kP;
    	
    }

    protected void initialize() {
        setTimeout(waitTime);  // set 4 second timeout
        Robot.driveTrain.zeroGyro();
    }

    protected void execute() {
    	Robot.driveTrain.driveStraightGyro(this.power, this.kP);
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