package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;
import org.usfirst.frc252.EasyDrive.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetPixyTrack extends Command {

	
	/*
	 * This command is pulls inputs from the smart dashboard and then passes them into arguments
	 * into the TurnInPlace command.
	 * 
	 */
	
	

		   public SetPixyTrack() {
		   }

		   public void initialize() {
		     
		      double pixyX = SmartDashboard.getNumber("PixyCenter", 1.7);
		      double kP = SmartDashboard.getNumber("Turn P", RobotMap.kPpixy);
		      double kI = SmartDashboard.getNumber("Turn I", RobotMap.kIpixy);
		      double kD = SmartDashboard.getNumber("Turn D", RobotMap.kDpixy);	  
		      //if(Robot.driveTrain.getPixyTarget()) {
		    	  TrackWithPixy turnCmd=new TrackWithPixy(pixyX, kP, kI, kD);
		    	  turnCmd.start();
		      //}
		   }

		   public void execute() {
		   }

		   public boolean isFinished() {
		       return true;
		   }
		  
		
}
