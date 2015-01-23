package org.usfirst.frc0.MyRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grabber extends CommandBase {

	public Grabber() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(grabber);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (oi.getGrabberOpenButton()) {
			grabber.grabberOpen();
		} else if (oi.getGrabberCloseButton()) {
			grabber.grabberClose();
		} else {
			grabber.grabberStop();
		}
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
