/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc252.EasyDrive.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


import org.usfirst.frc252.EasyDrive.RobotMap;

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
		addSequential(new Pause(3));
//		addSequential(new FollowPath(
//		        PathUtil.createStraightPath(36.0), x -> {
//		            if (x < 0.5) return 0.25;
//		            else return 0.75;
//		          }));
		addSequential(new FollowPath(
		        new Path(t -> 
		          /* {"start":{"x":0,"y":100},"mid1":{"x":46,"y":101},"mid2":{"x":51,"y":156},"end":{"x":112,"y":155}} */
		          (3 + 324 * t + -330 * Math.pow(t, 2))/ (138 + -246 * t + 291 * Math.pow(t, 2)), 129.0
		        ), x -> {
		          if (x < 0.15) return 0.6;
		          else if (x < 0.75) return 0.8;
		          else return 0.25;
		        }));
		
		
		
	}
}
