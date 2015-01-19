package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Lift;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements ILifter{
	private Relay winchMotor = RobotMap.winchMotor;
	
	public void liftUp() {
		winchMotor.setDirection(Direction.kForward);
	}
	public void liftDown() {
		winchMotor.setDirection(Direction.kReverse);
	}
	public void liftStop() {
		winchMotor.set(Value.kOff);
	}
	
	
	public void moveTo(int position){
	}
	

    public void initDefaultCommand() {
    	setDefaultCommand(new Lift());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

