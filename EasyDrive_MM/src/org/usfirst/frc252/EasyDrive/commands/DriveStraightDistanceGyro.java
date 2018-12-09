package org.usfirst.frc252.EasyDrive.commands;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc252.EasyDrive.Robot;
import org.usfirst.frc252.EasyDrive.RobotMap;



public class DriveStraightDistanceGyro extends Command{
	private final PIDController m_pid;

//This command will drive the robot straight forward or backward for a given distance using a pid loop that will
//track the number of inches traveled by using encoder counts on the leftTalon.  It will also use the gyro to equalize the speed of the 
//two sides to the differential drive



/**
*
*/

 public DriveStraightDistanceGyro(double distance, double kP, double kI, double kD) {

      requires(Robot.driveTrain);

 
     m_pid = new PIDController(kP, kI, kD, new PIDSource() {
         PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

         @Override
         public double pidGet() {
           return Robot.driveTrain.getLeftPositionInch();
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
 	   }, d -> Robot.driveTrain.driveStraightGyro(d, RobotMap.kPdriveGyro));

     
     m_pid.setAbsoluteTolerance(0.5);
     m_pid.setToleranceBuffer(10);
     m_pid.setSetpoint(distance);
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
  	SmartDashboard.putNumber("Heading", Robot.driveTrain.getHeading());
  	SmartDashboard.putNumber("Distance Setpoint", m_pid.getSetpoint());
  	SmartDashboard.putNumber("Distance Error", m_pid.getError());
  	SmartDashboard.putBoolean("Distance PID is On Target", m_pid.onTarget());
  	SmartDashboard.putBoolean("Distance PID is Executing", m_pid.isEnabled());
  	
 
 }

 // Make this return true when this Command no longer needs to run execute()
 @Override
 protected boolean isFinished() {
     
	 return m_pid.onTarget();
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
