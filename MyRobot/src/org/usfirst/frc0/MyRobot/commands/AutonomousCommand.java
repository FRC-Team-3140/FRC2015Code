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
import org.usfirst.frc0.MyRobot.commands.AutoDrive.DriveDirection;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

	public enum StartingPlace {
		LEFT_POS, MIDDLE_POS, RIGHT_POS, TOTE_POS

	};

	private double drive;
	private double moveLift;
	private double nascar;

	private DriveDirection turnDirection;

	public static StartingPlace place;

	/*
	 * public long mTime = 1000; public long iTime = System.currentTimeMillis();
	 */
	public AutonomousCommand() {

		place = StartingPlace.MIDDLE_POS;
		moveLift = .5;
		drive = 6;
		nascar = 1.7;

		switch (place) {
		case LEFT_POS:{
			drive = drive + 0.75;
			turnDirection = DriveDirection.LEFT_TURN;
			break;
		}
		case MIDDLE_POS:
		case RIGHT_POS: 
			turnDirection = DriveDirection.RIGHT_TURN;
			break;
		default:
			break;

		}

		addSequential(new GrabberClose());
		if (place != StartingPlace.TOTE_POS) {
			addSequential(new AutoDrive(moveLift, true, DriveDirection.BACKWARD));
			addSequential(new AutoDrive(drive, DriveDirection.BACKWARD));
			addSequential(new AutoDrive(nascar, turnDirection));
		} else {
			for (int x = 0; x < 2; x++) {
				addSequential(new AutoDrive(0.1));
				addSequential(new GrabberClose());
				addSequential(new AutoDrive(0.15, true,
						DriveDirection.LEFT_TURN));
				addSequential(new AutoDrive(0.6, DriveDirection.LEFT_TURN));
				addSequential(new AutoDrive(1.75));
				addSequential(new AutoDrive(1.5, DriveDirection.RIGHT_TURN));
				addSequential(new AutoDrive(1.35));
				addSequential(new AutoDrive(0.65, true,
						DriveDirection.LEFT_TURN));
				addSequential(new AutoDrive(0.9, true));
				addSequential(new AutoDrive(1.35));
				addSequential(new GrabberOpen());
				addSequential(new AutoDrive(0.35, DriveDirection.BACKWARD));
				addSequential(new GrabberLift(-0.75));
				addSequential(new AutoDrive(1.25));
				addSequential(new GrabberClose());
			}
			addSequential(new AutoDrive(1.35, DriveDirection.RIGHT_TURN));
			addSequential(new AutoDrive(4));
		}

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
