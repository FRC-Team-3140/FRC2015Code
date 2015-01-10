package org.usfirst.frc0.MyRobot.subsystems;

public class ArcadeDrive extends DriveSystem{
	
	public ArcadeDrive(boolean lowGear, double joystickTolerance,
			double leftTrigger, double rightTrigger, double leftJoystick){
	double multiplier = lowGear ? .5 : 0;
	if (lowGear) {
		if (rightTrigger > joystickTolerance) {
			DriveSystem.setMotorSpeed(multiplier * rightTrigger, multiplier
					* rightTrigger);
		} else if (leftTrigger > joystickTolerance) {
			DriveSystem.setMotorSpeed(multiplier * -(leftTrigger),
					multiplier * -(leftTrigger));
		} else {
			DriveSystem.setMotorSpeed(multiplier * -(leftJoystick),
					multiplier * leftJoystick);
		}
	}
	}
}
