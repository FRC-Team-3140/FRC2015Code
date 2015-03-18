package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberLift extends Command {

	double direction;
	long currentTime;
	long initialTime;
	long period;

	public GrabberLift(double direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		this.direction = direction;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		this.period = (long) (this.direction * 1000);
		this.initialTime = System.currentTimeMillis();
		if (this.direction > 0) {
			if (OI.competitionRobot) {
				this.direction = -Robot.oi.liftSpeed;
			} else {
				this.direction = Robot.oi.liftSpeed;
			}
		} else if (this.direction != 0){
			if (OI.competitionRobot) {
				this.direction = Robot.oi.liftSpeed;
			} else {
				this.direction = -Robot.oi.liftSpeed;
			}
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.lifter.moveLift(this.direction);
		this.currentTime = System.currentTimeMillis();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (this.currentTime - this.initialTime > period);
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
