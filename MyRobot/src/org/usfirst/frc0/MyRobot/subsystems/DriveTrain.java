package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
    
    private static SpeedController leftDriveMotor = RobotMap.leftDriveMotor;
    private static SpeedController rightDriveMotor = RobotMap.rightDriveMotor;

    public static void setLeftPower(double power) {
        leftDriveMotor.set(power);
    }

    public static void setRightPower(double power) {
        rightDriveMotor.set(power);
    }

    public static void setPower(double leftPower, double rightPower) {
        setLeftPower(leftPower);
        setRightPower(rightPower);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}