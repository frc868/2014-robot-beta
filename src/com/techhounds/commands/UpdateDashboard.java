/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techhounds.commands;

import com.techhounds.subsystems.DriveSubsystem;
import com.techhounds.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Atif Niyaz
 */
public class UpdateDashboard extends CommandBase {
    
    private Timer timer;
    
    public UpdateDashboard() {
        super("UpdateDashboard");
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(timer.get() >= .3) {
           
            // Update Smart Dashboard for each Subsystem
            DriveSubsystem.getInstance().updateSmartDashboard();
            GyroSubsystem.getInstance().updateSmartDashboard();
            
            // Reset timer
            timer.reset();
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
