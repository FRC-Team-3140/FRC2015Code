package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

	private long period;

	public AutoDrive(double duration) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		this.period = (long) (duration * 1000.0);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		turn();
	}

	public void driveForward(double distance) {
		// to do later
	}

	public void driveBackward(double distance) {
		// essentially driveForward but inverted
	}

	public void turn() {
		period = (long) this.period;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			Robot.driveTrain.setPower(0.75, 0.75);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);
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
		Robot.driveTrain.setPower(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
