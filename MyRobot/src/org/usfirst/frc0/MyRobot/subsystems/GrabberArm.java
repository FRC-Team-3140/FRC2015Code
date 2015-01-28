
package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Grabber;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberArm extends Subsystem implements IGrabber {
	private DoubleSolenoid grabberSolenoid = RobotMap.grabberSolenoid;
	private Compressor compressor = RobotMap.compressor;

	public void grabberOpen() {
		grabberSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void grabberClose() {
		grabberSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public void grabberStop() {
		grabberSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	public void startCompressor() {
		compressor.start();
		compressor.setClosedLoopControl(true);
	}

	public void stopCompressor() {
		compressor.setClosedLoopControl(false);
		compressor.stop();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new Grabber());
	}
}