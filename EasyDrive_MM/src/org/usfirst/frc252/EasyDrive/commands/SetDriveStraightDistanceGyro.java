package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetDriveStraightDistanceGyro extends Command {

	
	
	
	

		   public SetDriveStraightDistanceGyro() {
		   }

		   public void initialize() {
		      double distance = SmartDashboard.getNumber("Distance Setpoint", 4096*3);
		      double kP = SmartDashboard.getNumber("Distance P", 0);
		      double kI = SmartDashboard.getNumber("Distance I", 0);
		      double kD = SmartDashboard.getNumber("Distance D", 0);	  
		      DriveStraightDistanceGyro driveCmd=new DriveStraightDistanceGyro(distance, kP, kI, kD);
		      driveCmd.start();
		   }

		   public void execute() {
		   }

		   public boolean isFinished() {
		       return true;
		   }
		  
		
}
