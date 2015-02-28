package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;

import org.usfirst.frc0.MyRobot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDrive extends Command {

	public enum DriveDirection {
		FORWARD, BACKWARD, LEFT_TURN, RIGHT_TURN
	}

	private static PIDController leftPID = RobotMap.leftPID;
	private static PIDController rightPID = RobotMap.rightPID;

	private double distance;
	private boolean lifting;
	private DriveDirection direction;

	public AutoDrive(double distance, boolean lifting, DriveDirection direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		requires(Robot.driveTrain);
		this.distance = distance;
		this.direction = direction;
		this.lifting = lifting;
	}

	public AutoDrive(double distance, boolean lifting) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		requires(Robot.driveTrain);
		this.distance = distance;
		this.lifting = lifting;
		this.direction = DriveDirection.FORWARD;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		/*
		 * leftPID.reset(); rightPID.reset();
		 * leftPID.setOutputRange(-Robot.oi.throttle, 0);
		 * rightPID.setOutputRange(0, Robot.oi.throttle);
		 * leftPID.setAbsoluteTolerance(0.5);
		 * rightPID.setAbsoluteTolerance(0.5); leftPID.enable();
		 * rightPID.enable();
		 */
		if (this.lifting) {
			this.liftDrive(distance * 1000);
		} else {
			this.drive(distance * 1000);
		}

	}

	public void liftDrive(double period) {
		period = (long) period;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			if (this.direction == DriveDirection.FORWARD) {
				Robot.driveTrain
						.setPower(-Robot.oi.throttle, Robot.oi.throttle);
			} else if (this.direction == DriveDirection.BACKWARD) {
				Robot.driveTrain
						.setPower(Robot.oi.throttle, -Robot.oi.throttle);
			} else if (this.direction == DriveDirection.LEFT_TURN) {
				Robot.driveTrain.setPower(Robot.oi.throttle, Robot.oi.throttle);

			} else if (this.direction == DriveDirection.RIGHT_TURN) {
				Robot.driveTrain.setPower(-Robot.oi.throttle,
						-Robot.oi.throttle);
			}
			Robot.lifter.moveLift(-Robot.oi.liftSpeed);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);
		Robot.lifter.stop();
	}

	public void drive(double period) {
		period = (long) period;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			if (this.direction == DriveDirection.FORWARD) {
				Robot.driveTrain.setPower(-.75 * Robot.oi.throttle,
						.75 * Robot.oi.throttle);
			} else if (this.direction == DriveDirection.BACKWARD) {
				Robot.driveTrain.setPower(.75 * Robot.oi.throttle, -.75
						* Robot.oi.throttle);
			} else if (this.direction == DriveDirection.LEFT_TURN) {
				Robot.driveTrain.setPower(.5 * Robot.oi.throttle,
						.5 * Robot.oi.throttle);

			} else if (this.direction == DriveDirection.RIGHT_TURN) {
				Robot.driveTrain.setPower(-.5 * Robot.oi.throttle, -.5
						* Robot.oi.throttle);
			}
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
		leftPID.disable();
		rightPID.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
