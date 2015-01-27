package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Grabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberArm extends Subsystem implements IGrabber {
	private DoubleSolenoid grabberSolenoid = RobotMap.grabberSolenoid;

	public void grabberOpen() {
		grabberSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void grabberClose() {
		grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void grabberStop() {
		grabberSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}