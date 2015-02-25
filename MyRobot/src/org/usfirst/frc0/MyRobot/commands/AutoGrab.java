package org.usfirst.frc0.MyRobot.commands;

import org.usfirst.frc0.MyRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoGrab extends Command {

    public AutoGrab() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void grab() {
    	Robot.grabber.grabberClose();
    }
    
    public void release() {
    	Robot.grabber.grabberOpen();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
