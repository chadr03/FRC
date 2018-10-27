package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;

//This command uses a gyro to drive straight for a specified time
//
//Arguments
//waitTime - The length of time in seconds that this command will drive straight
//power - The motor input power [-1 to 1]
//kP - is a proportional constant used to tune the gyro.  If this value is too high or too low
//     the gyro can over or undercorrect causing weaving or overshoot.



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
        setTimeout(waitTime); 
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