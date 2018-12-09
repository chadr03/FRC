/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc252.EasyDrive.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc252.EasyDrive.Robot;
import org.usfirst.frc252.EasyDrive.RobotMap;


import easypath.EasyPath;
import easypath.EasyPathConfig;
import easypath.FollowPath;
import easypath.Path;
import easypath.PathUtil;

/**
 * 
 * This command group performs a series of commands
 * 
 * 
 * 
 */
public class Follow extends CommandGroup {
	public Follow() {
//		addSequential(new ZeroSensors());
//		addSequential(new Pause(1));
//straight forward
//		addSequential(new FollowPath(
//		        PathUtil.createStraightPath(36.0),0.9));
//		addSequential(new Pause(1));
//		addSequential(new ZeroSensors());
//		addSequential(new FollowPath(
//		        PathUtil.createStraightPath(36.0), -0.9));		

		
//right turn
//		addSequential(new FollowPath(
//				new Path(t -> 
//				/* {"start":{"x":0,"y":165},"mid1":{"x":23,"y":167},"mid2":{"x":16,"y":154},"end":{"x":17,"y":127}} */
//				(3 * Math.pow(t, 2) + -90 * t + 6) / (114 * Math.pow(t, 2) + -180 * t + 69),
//				50.857), x -> {
//				if (x < 0.15) return 0.35;
//		          else if (x < 0.75) return 0.6;
//		          else return 0.35;
//		        }));

//left turn		
//		addSequential(new FollowPath(
//				new Path(t -> 
//				/* {"start":{"x":19,"y":228},"mid1":{"x":50,"y":228},"mid2":{"x":52,"y":174},"end":{"x":54,"y":262}} */
//				(588 * Math.pow(t, 2) + -324 * t + 0) / (87 * Math.pow(t, 2) + -174 * t + 93),
//				86.552), x -> {
//				if (x < 0.15) return 0.9;
//		          else if (x < 0.75) return 0.9;
//		          else return 0.9;
//		        }));

//Sturn		
		addSequential(new FollowPath(
				new Path(t -> 
				/* {"start":{"x":19,"y":228},"mid1":{"x":74,"y":230},"mid2":{"x":27,"y":268},"end":{"x":95,"y":268}} */
				(-222 * Math.pow(t, 2) + 216 * t + 6) / (651 * Math.pow(t, 2) + -612 * t + 165),
				93.564), x -> {
				if (x < 0.15) return 0.35;
		          else if (x < 0.75) return 0.6;
		          else return 0.35;
		        }));
		addSequential(new Pause(1));
		addSequential(new ZeroSensors());
		addSequential(new TurnInPlace(180,
				  RobotMap.kPturn,
				  RobotMap.kIturn,
				  RobotMap.kDturn));
		addSequential(new Pause(1));
		addSequential(new ZeroSensors());
		addSequential(new FollowPath(
				new Path(t -> 
				/* {"start":{"x":19,"y":228},"mid1":{"x":74,"y":230},"mid2":{"x":27,"y":268},"end":{"x":95,"y":268}} */
				(-222 * Math.pow(t, 2) + 216 * t + 6) / (651 * Math.pow(t, 2) + -612 * t + 165),
				93.564), x -> {
				if (x < 0.15) return 0.35;
		          else if (x < 0.75) return 0.6;
		          else return 0.35;
		        }));
//		addSequential(new FollowPath(
//				new Path(t -> 
//				/* {"start":{"x":95,"y":268},"mid1":{"x":27,"y":268},"mid2":{"x":74,"y":230},"end":{"x":19,"y":228}} */
//				(222 * Math.pow(t, 2) + -228 * t + 0) / (-651 * Math.pow(t, 2) + 690 * t + -204),
//				93.564), x -> {
//				if (x < 0.15) return -0.35;
//		          else if (x < 0.75) return -0.6;
//		          else return -0.35;
//		        }));
		
		

//S turn left		
//		addSequential(new FollowPath(
//				new Path(t -> 
//				/* {"start":{"x":19,"y":228},"mid1":{"x":63,"y":230},"mid2":{"x":-1,"y":201},"end":{"x":96,"y":203}} */
//				(186 * Math.pow(t, 2) + -186 * t + 6) / (807 * Math.pow(t, 2) + -648 * t + 132),
//				89.823), x -> {
//			if (x < 0.15) return 0.35;
//	          else if (x < 0.75) return 0.6;
//	          else return 0.35;
//				}));	
	}
}
