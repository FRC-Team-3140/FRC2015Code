package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberLift extends Command {

	double direction;
	double speed;
	long currentTime;
	long initialTime;
	long period;

	public GrabberLift(double direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		this.direction = direction;
	}

	private void lifty(long duration) {
		this.initialTime = System.currentTimeMillis();
		do {
		Robot.lifter.moveLift(this.speed);
		this.currentTime = System.currentTimeMillis();
		} while(this.currentTime - this.initialTime <= duration);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
		if (this.direction > 0) {
			if (OI.competitionRobot) {
				this.speed= -Robot.oi.liftSpeed;
			} else {
				this.speed= Robot.oi.liftSpeed;
			}
		} else  {
			if (OI.competitionRobot) {
				this.speed = Robot.oi.liftSpeed;
			} else {
				this.speed = -Robot.oi.liftSpeed;
			}
		}
		this.period = (long) (this.direction * 1000);
		lifty(this.period);
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
