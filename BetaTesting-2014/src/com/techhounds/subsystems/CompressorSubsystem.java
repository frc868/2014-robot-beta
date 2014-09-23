/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techhounds.subsystems;

import com.techhounds.RobotMap;
import com.techhounds.commands.pneumatics.RunCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Atif Niyaz
 */
public class CompressorSubsystem extends Subsystem {
    
    private static CompressorSubsystem instance;
    
//    private Relay compressor; 
//    private DigitalInput reader;

	private Compressor c;
    
    private static boolean isShooting;
    private static boolean isDrivingFast;
    
    
    public CompressorSubsystem() {
        super("COMPRESSOR SUBSYSTEM");
    
        c = new Compressor(RobotMap.Compressor.COMPRESSOR_PCM);
        
//        compressor = new Relay(RobotMap.Compressor.COMPRESSOR_RELAY);
//        compressor.setDirection(Relay.Direction.kForward);
//        reader = new DigitalInput(RobotMap.Compressor.COMPRESSOR_SENSOR);
    }
    
    public static CompressorSubsystem getInstance() {
        if(instance == null)
            instance = new CompressorSubsystem();
        return instance;
    }
    
    public void start() {
    	c.start();
//    	compressor.set(Relay.Value.kOn);
    }
    
    public void stop() {
    	c.stop();
//        compressor.set(Relay.Value.kOff);
    }
    
    public boolean isMaxPressure() {
    	return c.getPressureSwitchValue();
//        return reader.get();
    }
    
    public static void setIsDrivingFast(boolean fast) {
        isDrivingFast = fast;
    }
    
    public static boolean getIsDrivingFast() {
        return isDrivingFast;
    }
    
    public static void setIsShooting(boolean shoot) {
        isShooting = shoot;
    }
    
    public static boolean getIsShooting() {
        return isShooting;
    }
    
    public void updateSmartDashboard() {

        // Compressor is on
        SmartDashboard.putBoolean("Compressor On", c.enabled());
        SmartDashboard.putBoolean("Compressor Pressure Switch", isMaxPressure());
        SmartDashboard.putNumber("Compressor Current", c.getCompressorCurrent());
    }
    
    public void initDefaultCommand() {
       setDefaultCommand(new RunCompressor());
    }
}
