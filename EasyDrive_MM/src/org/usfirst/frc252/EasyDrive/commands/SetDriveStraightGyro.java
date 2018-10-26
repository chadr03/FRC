package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetDriveStraightGyro extends Command {

	
	
	
	

		   public SetDriveStraightGyro() {
		   }

		   public void initialize() {
		      double time = SmartDashboard.getNumber("Time", 2.0);
		      double power = SmartDashboard.getNumber("Power", 0.3);
		      double kP = SmartDashboard.getNumber("kP", 0.5);
		      	  
		      DriveStraightGyro driveStrCmd=new DriveStraightGyro(time,power,kP);
		      driveStrCmd.start();
		   }

		   public void execute() {
		   }

		   public boolean isFinished() {
		       return true;
		   }
		  
		
}
