package org.usfirst.frc0.MyRobot.subsystems;

public class TankDrive extends DriveSystem{
	
	public TankDrive(double leftJoystick, double rightJoystick){
		leftSpeed = leftJoystick;
		rightSpeed = rightJoystick;
	}

}
