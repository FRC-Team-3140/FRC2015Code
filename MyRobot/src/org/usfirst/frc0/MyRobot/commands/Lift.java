package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.subsystems.WinchLifter;

/**
 *
 */
public class Lift extends CommandBase {

	public Lift() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(lifter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	public void lift(double move) {
		lifter.moveLift(move);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		lift(getSpeed());
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

	private double getSpeed() {
		// this does not use joystick tolerance since the speed control
		// on the joysticks are precise
		//double speed = (oi.getLiftDownButton()?-1:0) + (oi.getLiftUpButton()?1:0);
		double speed = 0;
		if (oi.getLiftUpButton() && !oi.getLiftDownButton()) {
			speed = 1;
		}
		else if(oi.getLiftDownButton()) {
			speed = -1;
		}
		
		return oi.getLiftThrottle() * speed;
			
	}
}
