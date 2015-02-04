package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EMonitor extends Command {
	public EMonitor() {
		requires(Robot.monitor);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		double[] accelerations;
		accelerations = Robot.monitor.getAcceleration();
		SmartDashboard.putNumber("aXaxis", accelerations[0]);
		SmartDashboard.putNumber("aZAxis", accelerations[1]);
		SmartDashboard.putNumber("aYAaxis", accelerations[2]);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
