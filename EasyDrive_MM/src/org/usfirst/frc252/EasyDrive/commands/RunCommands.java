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
 * Drive over the line and then shoot the ball. If the hot goal is not detected,
 * it will wait briefly.
 */
public class RunCommands extends CommandGroup {
	public RunCommands() {
		addSequential(new Pause(3));
		addSequential(new DriveStraightDistanceGyro(5000,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new DriveStraightDistanceGyro(-3000,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(90,
									  RobotMap.kPturn,
									  RobotMap.kIturn,
									  RobotMap.kDturn));
		addSequential(new DriveStraightDistanceGyro(3000,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new DriveStraightDistanceGyro(-3000,
													RobotMap.kPdriveDistance,
													RobotMap.kIdriveDistance,
													RobotMap.kDdriveDistance));
		addSequential(new TurnInPlace(-90,
				  					  RobotMap.kPturn,
				  					  RobotMap.kIturn,
				  					  RobotMap.kDturn));

	}
}