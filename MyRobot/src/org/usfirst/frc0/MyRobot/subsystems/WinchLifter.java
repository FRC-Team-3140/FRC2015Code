package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.*;

import org.usfirst.frc0.MyRobot.commands.Lift;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements ILifter {

	private SpeedController winchMotor = RobotMap.winchMotor;

	private DigitalInput topLimitSwitch = RobotMap.topLimitSwitch;
	private DigitalInput bottomLimitSwitch = RobotMap.bottomLimitSwitch;

	private long period = 700; // in ms

	public void moveLift(double power) {
		if (Robot.oi.limitmode == true) {
			if (power > 0) {
				if (topLimitSwitch.get()) {
					winchMotor.set(power);
				}
			} else if (power != 0) {
				if (bottomLimitSwitch.get()) {
					winchMotor.set(power);

				}
			}
		} else {
			winchMotor.set(power);
		}

	}

	public void stop() {
		winchMotor.set(0);
	}

	public void moveTo(double rotations) {
		// the position is the distance from the bottom
		// given out of the total range
		long period = this.period * (long) rotations;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			this.moveLift(Robot.oi.liftSpeed);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);
	}

	public void grabberMoveUp(double rotations) {
		long period = this.period * (long) rotations;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			this.moveLift(Robot.oi.liftSpeed);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);

	}

	public void grabberMoveDown(double rotations) {
		long period = this.period * (long) rotations;
		long cTime;
		long iTime = System.currentTimeMillis();
		do {
			this.moveLift(-1.0);
			cTime = System.currentTimeMillis();
		} while (cTime - iTime <= period);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new Lift());
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
