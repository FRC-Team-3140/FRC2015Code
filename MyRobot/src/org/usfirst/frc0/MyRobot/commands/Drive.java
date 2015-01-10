// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.MyRobot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc0.MyRobot.subsystems.DriveSystem;
import org.usfirst.frc0.MyRobot.Robot;

/**
 *
 */
public class Drive extends Command {


    
	private DriveSystem chassis;
    private Joystick xbox;
    private double leftJoystick;
    private double rightJoystick;
    private double rightTrigger;
    private double leftTrigger;
    private double joystickTolerance;
    private boolean lowGear;
    private boolean reverse;
    private String mode;

    public Drive(DriveSystem drivetrain, Joystick joystick,
    		String driveType, boolean reverseMotors) {
        // Use Reverse if going forwards is turning
        // change to non linear!~!@~!@~!@~!@~!@
    	
    	/* How to make a squared input drive 
    	 * rightJoystick = xbox.getRawAxis(5);
         * rightJoystick = Math.pow(rightJoystick,2) * Math.signum(rightJoystick); */
    	
    	joystickTolerance = 0.03;
        xbox = joystick;
        chassis = drivetrain;
        mode = driveType;
        reverse = reverseMotors;
        
}
        

    
    // gets the new joystick and trigger values
    public void update(){
    	leftJoystick = Math.pow(xbox.getRawAxis(1),3);
        rightJoystick = Math.pow(xbox.getRawAxis(5),3);
        leftTrigger = xbox.getRawAxis(2);
        leftTrigger = Math.pow(leftTrigger,2) * Math.signum(leftTrigger);
        rightTrigger = xbox.getRawAxis(3);
        rightTrigger = Math.pow(rightTrigger,2) * Math.signum(rightTrigger);
        lowGear = xbox.getRawButton(4);
        SmartDashboard.putNumber("leftAxis",leftJoystick);
    	SmartDashboard.putNumber("rightAxis", rightJoystick);
    	SmartDashboard.putNumber("leftTrigger",leftTrigger);
    	SmartDashboard.putNumber("rightTrigger",rightTrigger);
    	SmartDashboard.putBoolean("lowGear", lowGear);
    }
    
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
        chassis.setMotorSpeed(leftSpeed, rightSpeed);
    }
    
    public void setSpeeds(double lSpeed,double rSpeed){
        leftSpeed = lSpeed;
        rightSpeed = rSpeed;
        chassis.setMotorSpeed(lSpeed,rSpeed);

    }
    
    public void setLeftSpeed(double speed){
        leftSpeed = speed;
    }
    
    public void setRightSpeed(double speed){
        rightSpeed = speed;
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        chassis.setMotorSpeed(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
