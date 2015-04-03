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
	private double leftSpeed;
	private double rightSpeed;
	private double liftSpeed;
	private boolean lifting;
	private DriveDirection direction;
	private double throttle = Robot.oi.throttle * .75;

	public AutoDrive(double distance, boolean lifting, DriveDirection direction) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
		requires(Robot.driveTrain);
		this.distance = distance;
		this.direction = direction;
		this.lifting = lifting;
	}

	public AutoDrive(double distance, DriveDirection direction) {
		requires(Robot.driveTrain);
		this.distance = distance;
		this.direction = direction;
		this.lifting = false;
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

	public AutoDrive(double distance) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
		this.distance = distance;
		this.lifting = false;
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
		this.distance = 0.65 * this.distance;
		if (this.direction == DriveDirection.FORWARD) {
			this.leftSpeed = -throttle;
			this.rightSpeed = throttle;
		} else if (this.direction == DriveDirection.BACKWARD) {
			this.leftSpeed = throttle;
			this.rightSpeed = -throttle;
		} else if (this.direction == DriveDirection.LEFT_TURN) {
			this.leftSpeed = throttle;
			this.rightSpeed = throttle;
		} else if (this.direction == DriveDirection.RIGHT_TURN) {
			this.leftSpeed = -throttle;
			this.rightSpeed = -throttle;
		}
		
		this.liftSpeed = (this.lifting) ? 1 : 0;
		this.liftSpeed = (Robot.oi.competitionRobot)
				? -Robot.oi.liftSpeed * this.liftSpeed
				:  Robot.oi.liftSpeed * this.liftSpeed;

		this.drive(distance * 1000);

	}

	public void drive(double period) {
		period = (long) Math.abs(period);
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			Robot.lifter.moveLift(this.liftSpeed);
			Robot.driveTrain.setPower(this.leftSpeed, this.rightSpeed);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);
		Robot.lifter.stop();
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
