package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.OI;

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

	public void moveLifter() {
		long period = (long) (1000 * this.direction);
		long cTime;
		long iTime = System.currentTimeMillis();
		if (this.direction > 0) {
			if (OI.competitionRobot) {
				this.direction = -Robot.oi.liftSpeed;
			} else {
				this.direction = Robot.oi.liftSpeed;
			}
		} else {
			if (OI.competitionRobot) {
				this.direction = Robot.oi.liftSpeed;
			} else {
				this.direction = -Robot.oi.liftSpeed;
			}

		}
		do {
			Robot.lifter.moveLift(this.direction);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		moveLifter();
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
