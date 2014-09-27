/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techhounds.commands.auton.options;

import com.techhounds.RobotConstants;
import com.techhounds.commands.driving.DisableDriveWithGyro;
import com.techhounds.commands.driving.DriveWithEncoderAndGyro;
import com.techhounds.commands.driving.DriveWithGyro;
import com.techhounds.commands.kicker.SetKickerWheels;
import com.techhounds.commands.pneumatics.CollectorSequence;
import com.techhounds.commands.pneumatics.SetCollector;
import com.techhounds.commands.pneumatics.SetStoppers;
import com.techhounds.commands.shooter.Fire;
import com.techhounds.commands.shooter.FireReady;
import com.techhounds.commands.shooter.LockShooterPower;
import com.techhounds.commands.shooter.StopFire;
import com.techhounds.commands.shooter.WaitForShooter;
import com.techhounds.subsystems.CollectorSubsystem;
import com.techhounds.subsystems.StopperSubsystem;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 *
 * @author Atif_2
 */
public class TwoBallAuton extends CommandGroup {
    
    public TwoBallAuton() {
        
        //double initialAngle = GyroSubsystem.getInstance().getAngle();
        
        addSequential(new DriveWithGyro());
        addParallel(new MoveIntoZone());                    
        addParallel(new FireReady());                  
        
        addSequential(new WaitForChildren());              
        //addSequential(new CheesyVisionDelay(RobotConstants.Auton.CHEEZY_TIMEOUT_TWO_BALL)); // Cheezy Vision
        
        addSequential(new WaitForShooter());
        addParallel(new Fire());                            
        addParallel(new SetKickerWheels(RobotConstants.Kicker.IN_SPEED, 0.25, true)); 
        
        addSequential(new WaitForChildren());
        addSequential(new LockShooterPower((false)));
        
        addParallel(new DriveWithEncoderAndGyro(-RobotConstants.Auton.SECOND_BALL_DISTANCE));        
        addParallel(new SetCollector(CollectorSubsystem.COLLECTING));
        addParallel(new SetStoppers(StopperSubsystem.OUT));
        addParallel(new SetKickerWheels(RobotConstants.Kicker.IN_SPEED));
        
        addSequential(new WaitForChildren());
        addSequential(new WaitCommand(.75));
        
        addParallel(new SetKickerWheels(RobotConstants.Kicker.STOP));
        addParallel(new DriveWithEncoderAndGyro(RobotConstants.Auton.SECOND_BALL_DISTANCE));
        addParallel(new CollectorSequence());
        
        addSequential(new WaitForChildren());
        //addSequential(new CheesyVisionDelay(RobotConstants.Auton.CHEEZY_TIMEOUT_TWO_BALL)); // Cheezy Vision
        
        addSequential(new WaitForShooter());
        addParallel(new Fire());
        addParallel(new SetKickerWheels(RobotConstants.Kicker.IN_SPEED, 0.25, true));
        
        addSequential(new WaitForChildren());
        addSequential(new StopFire());
        addSequential(new DisableDriveWithGyro());
    }
}
