// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.subsystems.Electronics;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	public void setSpeeds(double lSpeed, double rSpeed) {
		Robot.driveTrain.setPower(lSpeed, rSpeed);
	}

	public void setLeftSpeed(double speed) {
		Robot.driveTrain.setLeftPower(speed);
	}

	public void setRightSpeed(double speed) {
		Robot.driveTrain.setRightPower(speed);
	}

	public void shift() {
		Robot.driveTrain.shift();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putBoolean("currentStatus",
				Robot.monitor.getMotorCurrentStatus());
		// if (Robot.monitor.getMotorVoltageStatus() != true) {
		setSpeeds(Robot.oi.getLeftDriveAxis(), Robot.oi.getRightDriveAxis());
		/*
		 * } else if (Robot.driveTrain.lowGear) { setSpeeds(
		 * Robot.driveTrain.strainLimit (Robot.oi.getLeftDriveAxis()),
		 * Robot.driveTrain.strainLimit * Robot.oi.getRightDriveAxis()); } else
		 * { Robot.driveTrain.shift(); } if (Robot.oi.getShifterButton()) {
		 * shift(); }
		 */
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
