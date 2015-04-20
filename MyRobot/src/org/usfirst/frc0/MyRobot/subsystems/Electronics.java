package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.commands.EMonitor;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Electronics extends Subsystem implements IElectronics {
	int[] driveMotors = new int[] { 0, 13, 14, 15 };
	double tCur = 0.0;
	double xVal;
	double yVal;
	double zVal;
	public Accelerometer accel = new BuiltInAccelerometer(
			Accelerometer.Range.k4G);
	public PowerDistributionPanel pdp = new PowerDistributionPanel();

	public double getMotorCurrentStatus() {
		// TODO Auto-generated method stub
		tCur = 0;
		for (int i = 0; i < driveMotors.length; i++) {
			tCur += pdp.getCurrent(driveMotors[i]);
		}
		return tCur;
		
	}

	public double getLifterCurrentStatus() {
		return pdp.getCurrent(12);
	}

	// @Override
	public double[] getAcceleration() {
		double[] vVals;
		double xVal = accel.getX();
		double yVal = accel.getY();
		double zVal = accel.getZ();
		vVals = new double[] { xVal, yVal, zVal };
		return vVals;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new EMonitor());
	}

}
