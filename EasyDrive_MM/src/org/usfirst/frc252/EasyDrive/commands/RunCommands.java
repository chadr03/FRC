/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc252.EasyDrive.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc252.EasyDrive.RobotMap;

/**
 * 
 * This command group performs a series of commands
 * 
 * 
 * 
 */
public class RunCommands extends CommandGroup {
	public RunCommands() {
		addSequential(new Pause(3));
		addSequential(new DriveStraightDistanceGyro(36,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(90,
				  RobotMap.kPturn,
				  RobotMap.kIturn,
				  RobotMap.kDturn));		
		addSequential(new DriveStraightDistanceGyro(12,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(90,
									  RobotMap.kPturn,
									  RobotMap.kIturn,
									  RobotMap.kDturn));
		addSequential(new DriveStraightDistanceGyro(36,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(90,
				  RobotMap.kPturn,
				  RobotMap.kIturn,
				  RobotMap.kDturn));
		addSequential(new DriveStraightDistanceGyro(12,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(90,
				  					  RobotMap.kPturn,
				  					  RobotMap.kIturn,
				  					  RobotMap.kDturn));

	}
}
