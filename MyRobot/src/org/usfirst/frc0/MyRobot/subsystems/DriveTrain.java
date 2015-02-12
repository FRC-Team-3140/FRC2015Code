package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.OI;
import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

	private static SpeedController leftDriveMotor = RobotMap.leftDriveMotor;
	private static SpeedController rightDriveMotor = RobotMap.rightDriveMotor;
	private static DoubleSolenoid shifterSolenoid = RobotMap.shifterSolenoid;
	private Encoder left_encoder, right_encoder;
	public boolean lowGear = false;
	public double strainLimit = 0.5;

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
		if (lowGear = true) {
			upshift();
		} else {
			downshift();
		}
	}

	private void upshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
		shifterSolenoid.set(DoubleSolenoid.Value.kOff);
		lowGear = false;
	}

	private void downshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
		shifterSolenoid.set(DoubleSolenoid.Value.kOff);
		lowGear = true;
	}
	
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", left_encoder.getDistance());
		SmartDashboard.putNumber("Right Distance", right_encoder.getDistance());
		SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
		SmartDashboard.putNumber("Right Speed", right_encoder.getRate());
	}
	
	public void reset() {
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}


	@Override
	protected void initDefaultCommand() {

		left_encoder = new Encoder(2, 3);
		right_encoder = new Encoder(0, 1);
		left_encoder.setDistancePerPulse(0.042);
		right_encoder.setDistancePerPulse(0.042);

		if (OI.mode == OI.JoystickMode.XBOX_MODE) {
			setDefaultCommand(new ArcadeDrive());
		} else {
			setDefaultCommand(new TankDrive());
		}

	}

}
