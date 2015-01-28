package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;

import org.usfirst.frc0.MyRobot.commands.*;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	private static SpeedController leftDriveMotor = RobotMap.leftDriveMotor;
	private static SpeedController rightDriveMotor = RobotMap.rightDriveMotor;
	private static DoubleSolenoid shifterSolenoid = RobotMap.shifterSolenoid;
	private boolean lowGear = false;

	public void setLeftPower(double power) {
		leftDriveMotor.set(power);
	}

	public void setRightPower(double power) {
		rightDriveMotor.set(power);
	}

	public void setPower(double leftPower, double rightPower) {
		setLeftPower(leftPower);
		setRightPower(rightPower);
	}

	public void shift() {
		if(lowGear) {
			upshift();
		} else {
			downshift();
		}
	}
	
	private void upshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
		shifterSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	private void downshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
		shifterSolenoid.set(DoubleSolenoid.Value.kOff);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());

	}

}
