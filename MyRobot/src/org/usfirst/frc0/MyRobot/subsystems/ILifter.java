package org.usfirst.frc0.MyRobot.subsystems;
/*
 * Mechanism to stack and place totes/can
 */
public interface ILifter {
	
	public void liftUp();
	public void liftDown();
	public void liftStop();
	//Move lifter to a certain position between 0-5
	public void moveTo(int position);
		
}