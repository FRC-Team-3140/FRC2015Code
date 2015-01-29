package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	public void open() {
		grabber.grabberOpen();
	}

	public void close() {
		grabber.grabberClose();
	}

	public void stop() {
		grabber.grabberStop();
	}

	public void turnOnCompressor() {
		grabber.startCompressor();
	}

	public void turnOffCompressor() {
		grabber.stopCompressor();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		OI.GrabberState state = oi.getGrabberButton();
		SmartDashboard.putString("state", state.getName());
		switch (state) {
		case OPEN: {
			open();
			break;
		}
		case CLOSE: {
			close();
			break;
		}
		case ON: {
			turnOnCompressor();
			break;
		}
		case OFF: {
			turnOffCompressor();
			break;
		}
		case STOP: {
			stop();
			break;
		}
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
