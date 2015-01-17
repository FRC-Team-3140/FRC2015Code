package org.usfirst.frc0.MyRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lift extends CommandBase {

    public Lift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(lifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (oi.getLiftStopButton()) {
    		lifter.liftStop();
    	} else if (oi.getLiftUpButton()) {
    		lifter.liftUp();
    	} else if (oi.getLiftDownButton()) {
    		lifter.liftDown();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
