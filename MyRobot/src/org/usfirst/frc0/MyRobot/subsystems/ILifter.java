package org.usfirst.frc0.MyRobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * Mechanism to stack and place totes/can
 */
public interface ILifter {

	public void moveLift(double power);

	public void stop();

	// Move lifter to a certain position between 0-5
	public void moveTo(double position);

}