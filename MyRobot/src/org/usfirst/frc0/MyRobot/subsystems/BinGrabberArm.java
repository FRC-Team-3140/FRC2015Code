package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BinGrabberArm extends Subsystem {

	public static SpeedController binWinchMotor = RobotMap.binWinchMotor;
	public static SpeedController binSwingMotor = RobotMap.binSwingMotor;
	
	public static DigitalInput deploySwitch = RobotMap.deploySwitch;
	public static DigitalInput leftLimitSwitch = RobotMap.swingLeftSwitch;
	public static DigitalInput rightLimitSwitch = RobotMap.swingRightSwitch;
	public static DigitalInput detectCanButton = RobotMap.detectCanButton;
	
	public static DoubleSolenoid binArmSolenoid = RobotMap.binArmSolenoid;
	
	public void deployGrabber(double binliftspeed) {
		if (deploySwitch.get() == false) {
			binWinchMotor.set(binliftspeed);
		}else{
			binWinchMotor.set(0);
		}
	}
	
	public void swingLeft(double binswingspeed) {
		if (leftLimitSwitch.get() == false) {
			binSwingMotor.set(binswingspeed);
		}else{
			binSwingMotor.set(0);
			
		}
	}
	
	public void swingRight(double binswingspeed) {
		if (rightLimitSwitch.get() == false) {
			binSwingMotor.set(binswingspeed);
		}else{
			binSwingMotor.set(0);
		}
	}
	
	public void extendArm() {
		binArmSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractArm() {
		binArmSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopArm() {
		binArmSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
