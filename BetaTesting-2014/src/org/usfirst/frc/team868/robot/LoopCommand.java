package org.usfirst.frc.team868.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LoopCommand extends Command {

	DigitalOutput led1;
	AnalogInput input;
	PWM pwm;
	
    public LoopCommand() {
    		
    	led1 = new DigitalOutput(0);
    	input = new AnalogInput(0);
    	pwm = new PWM(0);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	led1.set(input.getVoltage() > 2);
    	pwm.setRaw((int)input.getVoltage() * 51);
    	System.out.println(input.getVoltage());
    	//System.out.println(pwm.getRaw());
    	Timer.delay(.25);
    	
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
