package org.usfirst.frc0.MyRobot.subsystems;

/**
 *
 */
public interface IGrabber {

	public void grabberOpen();

	public void grabberClose();

	public void grabberStop();

	public void startCompressor();

	public void stopCompressor();
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
}