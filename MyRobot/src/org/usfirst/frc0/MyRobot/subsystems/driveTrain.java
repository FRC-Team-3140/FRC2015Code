package org.usfirst.frc0.MyRobot.subsystems;

import org.usfirst.frc0.MyRobot.RobotMap;
import org.usfirst.frc0.MyRobot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
    
    private Talon leftDriveMotor = RobotMap.leftDriveMotor;
    private Talon rightDriveMotor = RobotMap.rightDriveMotor;

    public void setLeftPower(double power) {
        leftDriveMotor.set(power);
    }

    public void setRightPower(double power) {
        rightDriveMotor.set(power);
    }

    public void setPower(double leftPower, rightPower) {
        leftDriveMotor.set(leftPower);
        rightDriveMotor.set(rightPower);
    }

}