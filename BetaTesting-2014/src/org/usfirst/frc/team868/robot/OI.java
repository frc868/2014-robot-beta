package org.usfirst.frc.team868.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	private Joystick driver;
	private Joystick tweaker;
	
	private boolean isInit;
	
	public OI() {
		driver = new Joystick(1);
		tweaker = new Joystick(2);
	}
	
	public void initialize() {
		
		if(!isInit)
			return;
		
		initDriver();
		initTweaker();
		initSmartDashboard();
	}
	
	public void initDriver() {
		
	}
	
	public void initTweaker() {
		
	}
	
	public void initSmartDashboard() {
		
	}

}
