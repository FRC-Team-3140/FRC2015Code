// RobotBui*lder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc0.MyRobot;

import java.io.IOException;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public enum GrabberState {
		OPEN("open"), CLOSE("close"), OFF("off"), ON("on"), STOP("stop");
		String name;

		private GrabberState(String s) {
			this.name = s;
		}

		public String getName() {
			return "GrabberState." + this.name;
		}
	}

	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUT
	// Once you have a button, it's trivial to bind it to rrtrjn
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private enum JoystickMode {
		XBOX_MODE, DUAL_MODE, TRUAL_MODE
	}

	private static JoystickMode mode = JoystickMode.DUAL_MODE;
	private final static int leftJoystick = 0;
	private final static int rightJoystick = 1;
	private final static int xboxJoystick = 0;
	private Joystick joystick[];
	private Button liftUpButton;
	private Button liftDownButton;
	private Button grabberCloseButton;
	private Button grabberOpenButton;

	private boolean lowGear = false;
	private boolean tankDrive = false;
	private double liftSpeed = 1;

	private static final int joystickPin = 0;
	private static final int tankJoystickPin = 1;

	
	private static final double xboxDeadzone = 0.03;
	private static final double joystickDeadzone = 0.02;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI() {

		joystick = new Joystick[2];
		joystick[0] = new Joystick(joystickPin);
		joystick[1] = new Joystick(tankJoystickPin);
		SmartDashboard.putBoolean("joysticks", true);
		if (joystick[1].getAxisCount() != 0) {
			tankDrive = true;
		}


		// One joystick for xbox controller, two for otherwise.
		switch (mode) {
		case TRUAL_MODE: {
			joystick = new Joystick[3];
			// to-do, never.
			break;
		}
		case DUAL_MODE: {
			joystick = new Joystick[2];
			joystick[leftJoystick] = new Joystick(0);
			joystick[rightJoystick] = new Joystick(1);
			liftUpButton = new JoystickButton(joystick[0], 1);
			liftDownButton = new JoystickButton(joystick[0], 2);
			grabberOpenButton = new JoystickButton(joystick[1], 1);
			grabberCloseButton = new JoystickButton(joystick[1], 2);
			break;
		}
		case XBOX_MODE: {
			joystick = new Joystick[1];
			joystick[xboxJoystick] = new Joystick(0);
			liftUpButton = new JoystickButton(joystick[0], 1);
			liftDownButton = new JoystickButton(joystick[0], 2);
			grabberOpenButton = new JoystickButton(joystick[0], 3);
			grabberCloseButton = new JoystickButton(joystick[0], 4);
			break;
		}
		}

	}

	private double joystickDeadzone(double rawJoystickValue,
			double joystickDeadzone) {
		if (Math.abs(rawJoystickValue) > joystickDeadzone) {
			return rawJoystickValue;
		}

		return 0.0;
	}
	
	private double joystickAdjustment(double rawJoystickValue) {
		
		return throttle * rawJoystickValue;
	}

	// returns the value of the y axis on the right joystick and sets the
	// low gear status to change if they are pressing the button
	
	private double getRawRightDriveAxis() {
if (tankDrive) {
			SmartDashboard.putNumber("right joystick degree",
					joystick[1].getRawAxis(1));
			return joystick[1].getRawAxis(1);

		}
		SmartDashboard.putNumber("right", joystick[0].getRawAxis(5));
		return joystick[0].getRawAxis(5);
	}

	public double getRightDriveAxis() {
		if (tankDrive) {
			return joystickTolerance(getRawRightDriveAxis(), joystickDeadzone);
		}
		return .5 * Math.pow(
				joystickTolerance(getRawRightDriveAxis(), xboxDeadzone), 3);
	switch (mode) {
		case TRUAL_MODE: {
			//to do, never
			return 0;
		}
		case DUAL_MODE: {
			return joystickDeadzone(joystick[rightJoystick].getRawAxis(1), joystickDeadzone);
		}
		case XBOX_MODE: {
			return joystickDeadzone(joystick[xboxJoystick].getRawAxis(5), xboxDeadzone);
		}
		}
		return Double.NaN;
	}

	public double getRightDriveAxis() {
		return joystickAdjustment(getRawRightDriveAxis());
	}

	// returns the y axis on the left joystick
	private double getRawLeftDriveAxis() {
		if (tankDrive) {
			return joystick[0].getRawAxis(1);
		}
		SmartDashboard.putNumber("left", joystick[0].getRawAxis(1));
		return joystick[0].getRawAxis(1);
	}

	public double getLeftDriveAxis() {
		if (tankDrive) {
			return joystickTolerance(getRawLeftDriveAxis(), joystickDeadzone);
		}
		return .5 * Math.pow(
				joystickTolerance(getRawLeftDriveAxis(), xboxDeadzone), 3);
	switch (mode) {
		case TRUAL_MODE: {
			//to do, never
			return 0;
		}
		case DUAL_MODE: {
			return joystickDeadzone(joystick[leftJoystick].getRawAxis(1), joystickDeadzone);
		}
		case XBOX_MODE: {
			return joystickDeadzone(joystick[xboxJoystick].getRawAxis(2), xboxDeadzone);
		}
		}
		return Double.NaN;
	}

	

	public boolean isInLowGear() {
		return lowGear;
	}

// this does not use joystick tolerance since the speed control
	// on the joysticks are precise
	public double getLiftSpeed() {
		if (tankDrive) {
			if (joystick[0].getRawAxis(3) != 0) {
				liftSpeed = joystick[0].getRawAxis(3);
				if (liftUpButton.get()) {
					return liftSpeed;
				} else if (liftDownButton.get()) {
					return -1.0 * liftSpeed;
				} else {
					return 0.0;
				}
			}
		} else {
			liftSpeed = Math.abs(liftSpeed + 0.05 * joystick[0].getRawAxis(6));
			if (joystick[0].getRawButton(3)) {
				return liftSpeed;
			} else if (joystick[0].getRawButton(4)) {
				return -1.0 * liftSpeed;
			} else {
				return 0.0;
			}
		}
		return 0;
	}

	public void stopRumbling() {
		joystick[0].setRumble(Joystick.RumbleType.kLeftRumble,0);
		joystick[0].setRumble(Joystick.RumbleType.kRightRumble,0);

	
	public GrabberState getGrabberButton() {
		if (joystick[0].getRawButton(5)) {
			joystick[0].setRumble(Joystick.RumbleType.kLeftRumble,1);
			return GrabberState.OPEN;
		} else if (joystick[0].getRawButton(6)) {
			joystick[0].setRumble(Joystick.RumbleType.kRightRumble,1);
			return GrabberState.CLOSE;
		} else if (joystick[0].getRawButton(7)) {
			return GrabberState.OFF;
		} else if (joystick[0].getRawButton(8)) {
			return GrabberState.ON;
		} else {
			return GrabberState.STOP;
		}
	}
	

	public boolean getShifterButton() {
		return joystick[0].getRawButton(1);
	}
}

}

