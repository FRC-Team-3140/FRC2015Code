package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.subsystems.Electronics;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class ArcadeDrive extends Command {

	private static PIDController leftPID = RobotMap.leftPID;
	private static PIDController rightPID = RobotMap.rightPID;

	public ArcadeDrive() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	public void setSpeeds(double speed, double angle) {
		Robot.driveTrain.setPower(speed + angle, -1 * (speed - angle));
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

	public void PIDDrive() {
		leftPID.setSetpoint(Robot.oi.getLeftDriveAxis());
		rightPID.setSetpoint(Robot.oi.getRightDriveAxis());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.log();
		SmartDashboard.putBoolean("currentStatus",
				Robot.monitor.getMotorCurrentStatus());
		if (Robot.monitor.getMotorCurrentStatus() != true) {
			setSpeeds(Robot.oi.getLeftDriveAxis(), Robot.oi.getRightDriveAxis());
		} else if (Robot.driveTrain.lowGear) {
			setSpeeds(
					Robot.driveTrain.strainLimit * Robot.oi.getLeftDriveAxis(),
					Robot.driveTrain.strainLimit * Robot.oi.getRightDriveAxis());
		} else {
			Robot.driveTrain.shift();
		}
		if (Robot.oi.getShifterButton()) {
			shift();
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
