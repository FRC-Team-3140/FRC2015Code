package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.OI.LifterMode;
import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.subsystems.WinchLifter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Command {

	private double location;

	public Lift() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.lifter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	public void lift(double move) {
		Robot.lifter.moveLift(move);
	}

	public void moveLift(double rotations) {
		Robot.lifter.moveTo(rotations);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double lifterCurrent = Robot.monitor.getLifterCurrentStatus();
		SmartDashboard.putNumber("lifterCurrent", lifterCurrent);
		if (Robot.oi.lifterMode == LifterMode.MANUAL) {
			lift(Robot.oi.getLiftSpeed());
		} else if (Robot.oi.lifterMode == LifterMode.AUTOMATIC) {
			moveLift(Robot.oi.getLiftSpeed());
			if (Robot.oi.getLiftSpeed() > 0 && location < 5) {
				location++;
			} else if (Robot.oi.getLiftSpeed() < 0 && location > 0) {
				location--;
			}
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
