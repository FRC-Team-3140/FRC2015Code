package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.Lift;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchLifter extends Subsystem implements ILifter{
	
    private SpeedController winchMotor = RobotMap.winchMotor;
    private DigitalInput limitSwitch = new DigitalInput(1);
    private Counter counter = new Counter(limitSwitch);
    private double location = 0.0;

    public boolean isSwitchSet() {
	return counter.get() > 0;
    }

    public void initializeCounter() {
	counter.reset();
    }

    public void moveLift(double power) {
	winchMotor.set(power); 
    }

    public void stop() {
	winchMotor.set(0);
    }
	
	
    public void moveTo(double position){
	// the position is the distance from the bottom
	// given out of the total range
	
	
    }
	

    public void initDefaultCommand() {
    	setDefaultCommand(new Lift());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

