package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.OI;
import org.usfirst.frc0.MyRobot.Robot;
import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

	private static SpeedController leftDriveMotor = RobotMap.leftDriveMotor;
	private static SpeedController rightDriveMotor = RobotMap.rightDriveMotor;
	private static DoubleSolenoid shifterSolenoid = RobotMap.shifterSolenoid;
	public final Encoder leftEncoder = RobotMap.leftEncoder;
	public final Encoder rightEncoder = RobotMap.rightEncoder;
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

	public void upshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void downshift() {
		shifterSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	/**
	 * The log method puts current draw from the motors to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("currentStatus",
				Robot.monitor.getMotorCurrentStatus());
	}

	public void reset() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}

	@Override
	protected void initDefaultCommand() {
		// leftEncoder.setDistancePerPulse(0.067631);
		// rightEncoder.setDistancePerPulse(0.067631);
		// leftEncoder.setDistancePerPulse(1.0);
		// rightEncoder.setDistancePerPulse(1.0);
		leftEncoder.reset();
		rightEncoder.reset();

		if (OI.mode == OI.JoystickMode.XBOX_MODE) {
			setDefaultCommand(new ArcadeDrive());
		} else {
			setDefaultCommand(new TankDrive());
		}

	}

}
