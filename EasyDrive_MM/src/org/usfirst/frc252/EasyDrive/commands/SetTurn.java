package org.usfirst.frc252.EasyDrive.commands;

import org.usfirst.frc252.EasyDrive.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetTurn extends Command {

	
	/*
	 * This command is pulls inputs from the smart dashboard and then passes them into arguments
	 * into the TurnInPlace command.
	 * 
	 */
	
	

		   public SetTurn() {
		   }

		   public void initialize() {
		      double angle = SmartDashboard.getNumber("Turn Angle Setpoint", 15.0);
		      double kP = SmartDashboard.getNumber("Turn P", 0);
		      double kI = SmartDashboard.getNumber("Turn I", 0);
		      double kD = SmartDashboard.getNumber("Turn D", 0);	  
		      TurnInPlace turnCmd=new TurnInPlace(angle, kP, kI, kD);
		      turnCmd.start();
		   }

		   public void execute() {
		   }

		   public boolean isFinished() {
		       return true;
		   }
		  
		
}
