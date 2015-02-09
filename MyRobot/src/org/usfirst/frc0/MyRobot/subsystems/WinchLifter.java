package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Lift;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements ILifter {

    private SpeedController winchMotor = RobotMap.winchMotor;

    public void moveLift(double power) {
	winchMotor.set(power);
    }

    public void stop() {
	winchMotor.set(0);
    }

    public void moveTo(double height) {
	//the position is the distance from the current location
	//given in stack levels
	local secondsElapsed
	while(height) {
	    winchMotor.set(Math.signum(rotations));
	}
    }

    public void initDefaultCommand() {
	setDefaultCommand(new Lift());
	//Set the default command for a subsystem here.
	//setDefaultCommand(new MySpecialCommand());
    }
}
