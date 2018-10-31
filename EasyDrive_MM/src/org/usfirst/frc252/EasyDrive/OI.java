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

import org.usfirst.frc252.EasyDrive.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc252.EasyDrive.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton x_button;
    public JoystickButton btn2;
    public JoystickButton btn3;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        x_button = new JoystickButton(joystick, 1);
        x_button.whenPressed(new ZeroSensors());
        btn2 = new JoystickButton(joystick, 2);
        btn2.whileHeld(new SetDriveStraightGyro());
        btn3 = new JoystickButton(joystick, 3);
        btn3.whileHeld(new SetPixyTrack());

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("NormalDrive", new NormalDrive());
        SmartDashboard.putData("ZeroSensors", new ZeroSensors());
        SmartDashboard.putData("Turn In Place", new SetTurn());
        SmartDashboard.putData("Drive Straight", new SetDriveStraightGyro());
        SmartDashboard.putData("Drive Str. Distance", new SetDriveStraightDistanceGyro());
        SmartDashboard.putData("Do Things", new RunCommands());
        SmartDashboard.putData("AutoCheck", new AutoSelect());
        SmartDashboard.putData("Pixy", new SetPixyTrack());
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

