// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc252.EasyDrive;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc252.EasyDrive.commands.*;
import org.usfirst.frc252.EasyDrive.subsystems.*;

import easypath.EasyPath;
import easypath.EasyPathConfig;
import easypath.PathUtil;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        
        driveTrain = new DriveTrain();
//        EasyPathConfig config = new EasyPathConfig(
//                driveTrain, // the subsystem itself
//                driveTrain::tank, // function to set left/right speeds
//                // function to give EasyPath the length driven
//                () -> PathUtil.defaultLengthDrivenEstimator(driveTrain::getLeftPositionInch, driveTrain::getRightPositionInch),
//                driveTrain::getHeading, // function to give EasyPath the heading of your robot
//                driveTrain::zeroSensors, // function to reset your encoders to 0
//                0.07 // kP value for P loop
//            );
        EasyPathConfig config = new EasyPathConfig(
                driveTrain, // the subsystem itself
                driveTrain::tankEasyDrive, // function to set left/right speeds
                // function to give EasyPath the length driven
                //driveTrain::getRightPositionInch,
                () -> PathUtil.defaultLengthDrivenEstimator(driveTrain::getLeftPositionInch, driveTrain::getRightPositionInch),
                driveTrain::getAngle, // function to give EasyPath the heading of your robot
                driveTrain::zeroSensors, // function to reset your encoders to 0
                0.09 // kP value for P loop
            );
        
        
        
        
        
            // OPTIONAL
            // If your robot is turning or driving the wrong directions, try one or both of these:
            config.setSwapDrivingDirection(false); //false 
            config.setSwapTurningDirection(false);  //false
            
            
            // Now, give EasyPath your configuration and you are all set
            EasyPath.configure(config);
    
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        

        chooser.addDefault("Autonomous Command", new AutonomousCommand());

    
        SmartDashboard.putData("Auto mode", chooser);
        SmartDashboard.putNumber("Turn Angle Setpoint", 15.0);
        SmartDashboard.putNumber("PixyCenter", 1.7);
        SmartDashboard.putNumber("Turn P", 0.019);
        SmartDashboard.putNumber("Turn I", 0);
        SmartDashboard.putNumber("Turn D", 0.035);
        SmartDashboard.putNumber("Time", 3.0);
	    SmartDashboard.putNumber("Power", 0.5);
	    SmartDashboard.putNumber("kP", 0.1);
	    
	    SmartDashboard.putNumber("Distance Setpoint", 5000);
	    SmartDashboard.putNumber("Distance P", 3.0e-4);
	    SmartDashboard.putNumber("Distance I", 0);
	    SmartDashboard.putNumber("Distance D", 0.001);
	    
	  	SmartDashboard.putNumber("Heading", 0);
	  	SmartDashboard.putNumber("Angle", Robot.driveTrain.getAngle());
	  	SmartDashboard.putNumber("Distance Setpoint", 0);
	  	SmartDashboard.putNumber("Distance Error", 0);
	  	SmartDashboard.putBoolean("Distance PID is On Target", false);
	  	SmartDashboard.putBoolean("Distance PID is Executing", false);
	  	SmartDashboard.putNumber("Encoder Value", 0);
	  	
	  	SmartDashboard.putNumber("Left Encoder Distance, in", Robot.driveTrain.getLeftPositionInch());
	  	SmartDashboard.putNumber("Right Encoder Distance, in", Robot.driveTrain.getRightPositionInch());
	    
	  	SmartDashboard.putNumber("Left Encoder Clicks", Robot.driveTrain.getLeftPosition());
	  	SmartDashboard.putNumber("Right Encoder Clicks", Robot.driveTrain.getRightPosition());
	    SmartDashboard.putNumber("Angle", Robot.driveTrain.getAngle());  	  
       
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();

        
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
	  	SmartDashboard.putNumber("Left Encoder Distance, in", Robot.driveTrain.getLeftPositionInch());
	  	SmartDashboard.putNumber("Right Encoder Distance, in", Robot.driveTrain.getRightPositionInch());
	  	SmartDashboard.putNumber("Left Encoder Clicks", Robot.driveTrain.getLeftPosition());
	  	SmartDashboard.putNumber("Right Encoder Clicks", Robot.driveTrain.getRightPosition());
	    SmartDashboard.putNumber("Angle", Robot.driveTrain.getAngle()); 
    }

}
