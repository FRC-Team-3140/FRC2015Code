package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.OI;
import org.usfirst.frc0.MyRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Grabber extends Command {
	public Grabber() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.grabber);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	public void open() {
		Robot.grabber.grabberOpen();
	}

	public void close() {
		Robot.grabber.grabberClose();
	}

	public void stop() {
		Robot.grabber.grabberStop();
	}

	public void turnOnCompressor() {
		Robot.grabber.startCompressor();
	}

	public void turnOffCompressor() {
		Robot.grabber.stopCompressor();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		OI.GrabberState state = Robot.oi.getGrabberButton();
		SmartDashboard.putString("state", state.toString());
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
