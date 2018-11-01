package org.usfirst.frc252.EasyDrive.commands;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc252.EasyDrive.Robot;



public class TrackWithPixy extends Command{
	private final PIDController m_pid;

//RobotBuilder Version: 2.0
//
//This file was generated by RobotBuilder. It contains sections of
//code that are automatically generated and assigned by robotbuilder.
//These sections will be updated in the future when you export to
//Java from RobotBuilder. Do not put any code or make any change in
//the blocks indicating autogenerated code or it will be lost on an
//update. Deleting the comments indicating the section will prevent
//it from being updated in the future.



	/**
	 *
	 * This command turns the robot in place and to center a target using the pixy analog x output
	 * to know how far it is turned.
	 * 
	 * Arguments
	 * 
	 * pixyX - voltage from 0 to 3 that is output from the pixy.  Imperically determine the value when 
	 * the robot is pointed in the desired direction for this example 1.7 is good
	 * 
	 * 
	 */


 public TrackWithPixy(double pixyX, double kP, double kI, double kD) {

      requires(Robot.driveTrain);

 
     m_pid = new PIDController(kP, kI, kD, new PIDSource() {
         PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

         @Override
         public double pidGet() {
           return Robot.driveTrain.getPixyX();
         }

         @Override
         public void setPIDSourceType(PIDSourceType pidSource) {
           m_sourceType = pidSource;
         }

         @Override
         public PIDSourceType getPIDSourceType() {
           return m_sourceType;
         }
       //}, d -> Robot.driverain.drive(0, d));
 	   }, d -> Robot.driveTrain.tank(-d, d));

     
     m_pid.setAbsoluteTolerance(0.05);
     m_pid.setToleranceBuffer(3);
     m_pid.setSetpoint(pixyX);
     m_pid.setOutputRange(-0.5, 0.5);
 
 }

 // Called just before this Command runs the first time
 @Override
 protected void initialize() {
	    Robot.driveTrain.zeroSensors();
	    m_pid.reset();
	    m_pid.enable();
	    System.out.println("PID enabled.\n");
 }

 // Called repeatedly when this Command is scheduled to run
 @Override
 protected void execute() {
  	SmartDashboard.putNumber("Yaw", Robot.driveTrain.gyroInfo()[0]);
  	SmartDashboard.putNumber("Heading", Robot.driveTrain.getHeading());
  	SmartDashboard.putNumber("PixyX", Robot.driveTrain.getPixyX());
  	SmartDashboard.putBoolean("PixyTarget", Robot.driveTrain.getPixyTarget());
  	SmartDashboard.putNumber("Setpoint", m_pid.getSetpoint());
  	SmartDashboard.putNumber("Error", m_pid.getError());
  	SmartDashboard.putBoolean("PID is On Target", m_pid.onTarget());
  	SmartDashboard.putBoolean("PID is Executing", m_pid.isEnabled());
 
 }

 // Make this return true when this Command no longer needs to run execute()
 @Override
 protected boolean isFinished() {
     return false;
	 //return m_pid.onTarget();
 }

 // Called once after isFinished returns true
 @Override
 protected void end() {
	 m_pid.disable();
	 Robot.driveTrain.drive(0,0);

 }

 // Called when another command which requires one or more of the same
 // subsystems is scheduled to run
 @Override
 protected void interrupted() {
	 m_pid.disable();
 }
}