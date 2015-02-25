// RobotBuilder Version: 1.5
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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {

	private static DigitalInput topLimitSwitch = RobotMap.topLimitSwitch;
	private static DigitalInput bottomLimitSwitch = RobotMap.bottomLimitSwitch;

	public enum GrabberState {
		OPEN("open"), CLOSE("close"), OFF("off"), ON("on"), STOP("stop");
		String name;

		private GrabberState(String s) {
			this.name = s;
		}

		@Override
		public String toString() {
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

	public enum JoystickMode {
		XBOX_MODE, DUAL_MODE, TRUAL_MODE
	}

	public enum lifterMode {
		MANUAL_MODE, AUTOMATIC_MODE
	}
	
	public final static JoystickMode mode = JoystickMode.XBOX_MODE;
	public static lifterMode liftmode = lifterMode.MANUAL_MODE;
	public static boolean limitmode = false;
	private final static int leftJoystick = 0;
	private final static int rightJoystick = 1;
	private final static int xboxJoystick = 0;
	private final static int attackJoystick = 0;
	private Joystick joystick[];
	private Button switchButton;
	private Button shifterButton;
	private Button liftUpButton;
	private Button liftDownButton;
	private Button grabberCloseButton;
	private Button grabberOpenButton;
	private Button compressorOnButton;
	private Button compressorOffButton;

	public double throttle = 0.65;
	public double liftSpeed = 0.8;

	// private double piecewiseThreshA = 0.02;
	// private double piecewiseMultA = 0.35;
	// private double piecewiseThreshB = 0.75;
	// private double piecewiseMultB = 0.55;

	private static final double xboxDeadzone = 0.03;
	private static final double joystickDeadzone = 0.02;

	public OI() {

		// One joystick for xbox controller, two for otherwise.
		switch (mode) {
		case TRUAL_MODE: {
			this.joystick = new Joystick[3];
			// to-do, never.
			break;
		}
		case DUAL_MODE: {
			this.joystick = new Joystick[2];
			this.joystick[leftJoystick] = new Joystick(0);
			this.joystick[rightJoystick] = new Joystick(1);
			this.shifterButton = new JoystickButton(joystick[0], 3);
			this.liftUpButton = new JoystickButton(joystick[0], 1);
			this.liftDownButton = new JoystickButton(joystick[0], 2);
			this.grabberOpenButton = new JoystickButton(joystick[1], 1);
			this.grabberCloseButton = new JoystickButton(joystick[1], 2);
			this.compressorOnButton = new JoystickButton(joystick[1], 3);
			this.compressorOnButton = new JoystickButton(joystick[1], 4);
			break;
		}
		case XBOX_MODE: {
			this.joystick = new Joystick[1];
			this.joystick[xboxJoystick] = new Joystick(0);
			this.switchButton = new JoystickButton(joystick[0], 1);
			this.shifterButton = new JoystickButton(joystick[0], 2);
			this.liftUpButton = new JoystickButton(joystick[0], 4);
			this.liftDownButton = new JoystickButton(joystick[0], 3);
			this.grabberOpenButton = new JoystickButton(joystick[0], 5);
			this.grabberCloseButton = new JoystickButton(joystick[0], 6);
			this.compressorOnButton = new JoystickButton(joystick[0], 8);
			this.compressorOffButton = new JoystickButton(joystick[0], 7);
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
		// return throttle * rawJoystickValue; // Original
		// if (Math.abs(rawJoystickValue) < piecewiseThreshA) { // Piecewise
		// return piecewiseMultA * rawJoystickValue; // Piecewise
		// } else if (Math.abs(rawJoystickValue) > piecewiseThreshB) { //
		// Piecewise
		// return piecewiseMultB * rawJoystickValue; // Piecewise
		// } // Piecewise
		// return Math.signum(rawJoystickValue) *
		// Math.abs(Math.pow(rawJoystickValue,2)) * throttle; // Quadratic
		return Math.signum(rawJoystickValue)
				* Math.abs(Math.pow(rawJoystickValue, 3)) * throttle; // Cubic
	}

	// returns the value of the y axis on the right joystick and sets the
	// low gear status to change if they are pressing the button

	private double getRawRightDriveAxis() {
		switch (mode) {
		case TRUAL_MODE: {
			// to do, never
			return 0;
		}
		case DUAL_MODE: {
			return joystickDeadzone(
					Math.pow(joystick[rightJoystick].getRawAxis(1), 3),
					joystickDeadzone);
		}
		case XBOX_MODE: {
			return joystickDeadzone(joystick[xboxJoystick].getRawAxis(0),
					xboxDeadzone);
		}

		}
		return Double.NaN;
	}

	public double getRightDriveAxis() {
		return -1 * joystickAdjustment(getRawRightDriveAxis());
	}

	private double getRawLeftDriveAxis() {
		switch (mode) {
		case TRUAL_MODE: {
			// to do, never
			return 0;
		}
		case DUAL_MODE: {
			return joystickDeadzone(joystick[leftJoystick].getRawAxis(1),
					joystickDeadzone);
		}
		case XBOX_MODE: {
			return joystickDeadzone(
					Math.pow(joystick[xboxJoystick].getRawAxis(1), 3),
					xboxDeadzone);
		}
		}
		return Double.NaN;
	}

	public double getLeftDriveAxis() {
		return joystickAdjustment(getRawLeftDriveAxis());
	}

	// this does not use joystick tolerance since the speed control
	// on the joysticks are precise
	public double getLiftSpeed() {
		switch (mode) {
		case TRUAL_MODE: {
			// to do, never
			return 0.0;
		}
		case DUAL_MODE: {
			if (joystick[0].getRawAxis(3) != 0) {
				liftSpeed = joystick[0].getRawAxis(3);
				if (liftUpButton.get()) {
					return 0.0;
				} else if (liftUpButton.get()) {
					return liftSpeed;
				} else if (liftDownButton.get()) {
					return 0.0;
				} else if (liftDownButton.get()) {
					return 0.0 * liftSpeed;
				} else {
					return 0.0;
				}
			}
		}
		case XBOX_MODE: {
			liftSpeed = Math.abs(liftSpeed + 0.05 * joystick[0].getRawAxis(3));
			if (liftUpButton.get()) {
				return liftSpeed;
			} else if (liftDownButton.get()) {
				return -1.0 * liftSpeed;
			} else {
				return 0.0;
			}
		}
		}
		return 0.0;
	}

	public GrabberState getGrabberButton() {
		if (grabberOpenButton.get()) {
			return GrabberState.OPEN;
		} else if (grabberCloseButton.get()) {
			return GrabberState.CLOSE;
		} else if (compressorOnButton.get()) {
			return GrabberState.ON;
		} else if (compressorOffButton.get()) {
			return GrabberState.OFF;
		} else {
			return GrabberState.STOP;
		}
	}

	public boolean switchLifterMode() {
		if (switchButton.get() && liftmode == lifterMode.MANUAL_MODE) {
			liftmode = lifterMode.AUTOMATIC_MODE;
		} else if (switchButton.get() && liftmode == lifterMode.AUTOMATIC_MODE) {
			liftmode = lifterMode.MANUAL_MODE;
		}
		return false;
	}

	public boolean getShifterButton() {
		return shifterButton.get();
	}
}
