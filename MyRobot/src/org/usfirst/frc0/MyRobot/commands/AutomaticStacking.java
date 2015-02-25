package org.usfirst.frc0.MyRobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc0.MyRobot.*;

/**
 *
 */
public class AutomaticStacking extends CommandGroup {

    public AutomaticStacking() {
    	addSequential(new GrabberOpen());
    	addSequential(new GrabberLift(-1));
    	addSequential(new GrabberClose());
    	addSequential(new GrabberLift(1));
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void stack() {
    	
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
