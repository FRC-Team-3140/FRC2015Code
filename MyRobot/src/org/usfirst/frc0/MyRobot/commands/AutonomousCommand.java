// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc0.MyRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc0.MyRobot.Robot;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	public enum StartingPlace {
		LEFT_POS, MIDDLE_POS, RIGHT_POS
		
	}
	
	
	public static StartingPlace toStartingPlaceEnum(String value) {
		if (value == "left") {
			return StartingPlace.LEFT_POS;
		} else if(value == "middle") {
			return StartingPlace.MIDDLE_POS;
		} else if(value == "right") {
			return StartingPlace.RIGHT_POS;
		}
		return StartingPlace.MIDDLE_POS;
	}
	
	public final static StartingPlace place = toStartingPlaceEnum(SmartDashboard.getString("position"));
	
	/*
	 * public long mTime = 1000; public long iTime = System.currentTimeMillis();
	 */
	public AutonomousCommand() {
		switch (place) {
		case LEFT_POS: {
			addSequential(new GrabberLift(SmartDashboard.getNumber("lift")));
			addSequential(new GrabberClose());
			addSequential(new DriveForward(SmartDashboard.getNumber("moveLift"), true));
			addSequential(new DriveForward(SmartDashboard.getNumber("drive") + SmartDashboard.getNumber("finish"), false));
			addSequential(new AutoDrive(SmartDashboard.getNumber("rotateLeft")));
			// addSequential(new Turn(-1)); <= -1 MEANS LEFT TO AIM AT LEFT
			// CHUTE
			break;
		}
		case MIDDLE_POS: { // WHAT TO DO HERE???
			addSequential(new GrabberLift(SmartDashboard.getNumber("lift")));
			addSequential(new GrabberClose());
			addSequential(new DriveForward(SmartDashboard.getNumber("moveLift"), true));
			addSequential(new DriveForward(SmartDashboard.getNumber("drive"), false));
			addSequential(new DriveForward(SmartDashboard.getNumber("finish"), true));
			addSequential(new AutoDrive(SmartDashboard.getNumber("rotate")));
			break;
		}
		case RIGHT_POS: {
			addSequential(new GrabberLift(SmartDashboard.getNumber("lift")));
			addSequential(new GrabberClose());
			addSequential(new DriveForward(SmartDashboard.getNumber("moveLift"), true));
			addSequential(new DriveForward(SmartDashboard.getNumber("drive"), false));
			addSequential(new DriveForward(SmartDashboard.getNumber("finish"), true));
			addSequential(new AutoDrive(SmartDashboard.getNumber("rotateRight")));
		// addSequential(new Turn(1)); <= 1 MEANS RIGHT TO AIM AT RIGHT
			// CHUTE
			break;
		}
		default:
			break;

		}
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		/*
		 * requires(Robot.driveTrain); requires(Robot.grabber);
		 * requires(Robot.lifter);
		 */

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*
		 * long cTime = System.currentTimeMillis(); if(cTime-iTime<=1000){
		 * Robot.driveTrain.setLeftPower(.1);
		 * Robot.driveTrain.setRightPower(.1);
		 */
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Scheduler.getInstance().removeAll();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
