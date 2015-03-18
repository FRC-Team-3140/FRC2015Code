package org.usfirst.frc0.MyRobot.subsystems;

/**
 *
 */
public interface IElectronics {

	public boolean getMotorCurrentStatus();

	public double[] getAcceleration();

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
}