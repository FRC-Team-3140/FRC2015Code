package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Lift;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements ILifter{
	private SpeedController winchMotor = RobotMap.winchMotor;
	
	public void liftUp() {
		winchMotor.set(0.5); 
	}
	public void liftDown() {
		winchMotor.set(-0.5);
	}
	public void liftStop() {
		winchMotor.set(0);
	}
	
	
	public void moveTo(int position){
	}
	

    public void initDefaultCommand() {
    	setDefaultCommand(new Lift());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

