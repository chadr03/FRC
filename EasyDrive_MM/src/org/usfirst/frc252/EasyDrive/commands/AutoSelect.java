/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc252.EasyDrive.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc252.EasyDrive.Robot;
import org.usfirst.frc252.EasyDrive.RobotMap;

/**
 * 
 * This command group performs a series of commands
 * 
 * 
 * 
 */
public class AutoSelect extends CommandGroup {
	private String gameData="RRR";
	
	
	public AutoSelect() {
		gameData = Robot.driveTrain.getGameData();
		SmartDashboard.putString("GameData",gameData);
		addSequential(new ZeroSensors());
		if(gameData.length() > 0)
        {
			if(gameData.charAt(0) == 'L')
			{
				addSequential(new TurnInPlace(45,
						  RobotMap.kPturn,
						  RobotMap.kIturn,
						  RobotMap.kDturn));
			} else {
				addSequential(new TurnInPlace(-45,
						  RobotMap.kPturn,
						  RobotMap.kIturn,
						  RobotMap.kDturn));
			}
        }
		


	}
}
