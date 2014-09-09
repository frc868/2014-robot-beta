/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techhounds.commands.pneumatics;

import com.techhounds.commands.CommandBase;
import com.techhounds.subsystems.CompressorSubsystem;

/**
 * @author Atif Niyaz
 */
public class RunCompressor extends CommandBase {

	private CompressorSubsystem compressor;

	public RunCompressor() {
		compressor = CompressorSubsystem.getInstance();
		requires(compressor);
		setInterruptible(false);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		if (compressor.isMaxPressure() || CompressorSubsystem.getIsShooting())
			compressor.stop();
		else
			compressor.start();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
