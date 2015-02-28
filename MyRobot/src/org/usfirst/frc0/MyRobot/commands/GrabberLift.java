package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberLift extends Command {

	double direction;

	public GrabberLift(double direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		this.direction = direction;
	}

	public void moveLifter(double direction) {
		if (direction > 0) {
			Robot.lifter.grabberMoveDown(direction);
		} else if (direction < 0) {
			Robot.lifter.grabberMoveUp(direction);
		}

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		moveLifter(direction);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lifter.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
