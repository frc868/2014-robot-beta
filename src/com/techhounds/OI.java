
package com.techhounds;

import com.techhounds.commands.DebugDriveWithEncoder;
import com.techhounds.commands.auton.AutonChooser;
import com.techhounds.commands.driving.DisableDriveWithGyro;
import com.techhounds.commands.driving.DriveWithEncoder;
import com.techhounds.commands.driving.DriveWithEncoderAndGyro;
import com.techhounds.commands.driving.DriveWithGyro;
import com.techhounds.commands.driving.RotateToAngle;
import com.techhounds.subsystems.CollectorSubsystem;
import com.techhounds.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private static OI instance;
    private final ControllerMap driverGamepad;
    private final ControllerMap tweakerGamepad;
    
    private SendableChooser autonChoice;
    
    private boolean isInitialized;
    
    private final double GAMEPAD_DEADZONE = 0.05;
    
    // Driver Gamepad
    private final int DRIVER_TOGGLE_POPPER = ControllerMap.BACK;
    private final int DRIVER_COLLECTOR_OUT = ControllerMap.LT;
    private final int DRIVER_COLLECTOR_IN = ControllerMap.LB;
    private final int DRIVER_BALL_OUT = ControllerMap.RT;
    private final int DRIVER_BALL_IN = ControllerMap.RB;
    private final int DRIVER_FIRE = ControllerMap.START;
    private final int DRIVER_BACK_PLUS = ControllerMap.X;
    private final int DRIVER_BACK_MINUS = ControllerMap.A;
    private final int DRIVER_FRONT_PLUS = ControllerMap.Y;
    private final int DRIVER_FRONT_MINUS = ControllerMap.B;
    //private final int DRIVER_SHOOTER_ON = ControllerMap.UP;
    //private final int DRIVER_SHOOTER_OFF = ControllerMap.DOWN;
    
    // Operator / Tweaker Gamepad
    private final int TWEAKER_COLLECT = ControllerMap.LB;
    private final int TWEAKER_HUMAN_COLLECT = ControllerMap.RB;
    private final int TWEAKER_SHOOTER_ON = ControllerMap.LT;
    private final int TWEAKER_FIRE = ControllerMap.RT;
    private final int TWEKAER_ADJUST_RPS = ControllerMap.START; 
    private final int TWEAKER_LOW_POWER = ControllerMap.X;
    private final int TWEAKER_POPPER_IN = ControllerMap.A;
    private final int TWEAKER_POPPER_IN_ALT = ControllerMap.BACK;
    private final int TWEAKER_SHOOTER_OFF = ControllerMap.B;
    private final int TWEAKER_BALL_OUT = ControllerMap.UP;
    private final int TWEAKER_BALL_IN = ControllerMap.DOWN;
    private final int TWEAKER_TRAIN = ControllerMap.Y;
    
    private OI() {
        driverGamepad = new ControllerMap(new Joystick(RobotMap.Controller.DRIVER), ControllerMap.LOGITECH);
        tweakerGamepad = new ControllerMap(new Joystick(RobotMap.Controller.TWEAKER), ControllerMap.LOGITECH);
        
        autonChoice = createChoices("Auton Choices", AutonChooser.AUTON_CHOICES);
    }
    
    public static OI getInstance() {
        if(instance == null)
            instance = new OI();
        return instance;
    }
    
    public void initialize(){
        if (isInitialized)
            return;
        
        initDriver();
        initTweaker();
        initDashboard();
        
        isInitialized = true;
    }
    
    public void initDriver(){
        
        /* Controls
        * Left Joystick --> Forward / Backward (Magnitude)
        * Right Joystick --> Rotation
        * 
        */
        
    }
    
    public void initTweaker(){
        
        /* Controls
        * DPAD-UP --> Shooter Wheels In
        * DPAD-DOWN --> Shooter Wheels Out
        * 
        * Left Joystick --> Forward / Backward (Magnitude)
        * Right Joystick --> Rotation
        */
        
        
    }
    
    
    private Command createAutonSetup() {
        CommandGroup cg = new CommandGroup("Auton Setup");
        
        return cg;
    }
    
    public void initDashboard(){
        SmartDashboard.putData("Auton Setup", createAutonSetup());
       
        if (RobotConstants.Debug.ROTATION_BUTTONS){
            SmartDashboard.putData("Rotate to 90", new RotateToAngle(90));
            SmartDashboard.putData("Rotate to 270", new RotateToAngle(270));
            SmartDashboard.putData("Rotate to 0", new RotateToAngle(0));
        }
        
        if (RobotConstants.Debug.EXTRA_SMARTDASHBOARD_BUTTONS){  
            SmartDashboard.putData("Drive 2 Feet", new DriveWithEncoder(2.0));
            SmartDashboard.putData("Drive 4 Feet", new DriveWithEncoder(4.0));
            SmartDashboard.putData("Drive 10 Feet", new DriveWithEncoderAndGyro(10.0));
            SmartDashboard.putData("Drive Back 10 Feet", new DriveWithEncoderAndGyro(-10.0));
            
            SmartDashboard.putData("Drive Back and Forth", new DebugDriveWithEncoder());

            
            SmartDashboard.putData("Enable Gyro", new DriveWithGyro());
            SmartDashboard.putData("Disable Gyro", new DisableDriveWithGyro());

            SmartDashboard.putData("Drive Subsystem", DriveSubsystem.getInstance());
            
            SmartDashboard.putData("Colletor Subsystem", CollectorSubsystem.getInstance());
        }
    }
    public double getDriverRightXAxis(){
        return analogRange(driverGamepad.getRightStickX());
    }
    
    public double getDriverRightYAxis(){
        return analogRange(driverGamepad.getRightStickY());
    }
    
    public double getDriverLeftXAxis(){
        return analogRange(driverGamepad.getLeftStickX());
    }
    
    public double getDriverLeftYAxis(){
        return analogRange(driverGamepad.getLeftStickY());
    }
    
    public double getTweakerRightXAxis(){
        return analogRange(tweakerGamepad.getRightStickX());
    }
    
    public double getTweakerRightYAxis(){
        return analogRange(tweakerGamepad.getRightStickY());
    }
    
    public double getTweakerLeftXAxis(){
        return analogRange(tweakerGamepad.getLeftStickX());
    }
    
    public double getTweakerLeftYAxis(){
        return analogRange(tweakerGamepad.getLeftStickY());
    }
    
    public double analogRange(double val){
        if (Math.abs(val) < GAMEPAD_DEADZONE){
            if (val > 0)
                val = GAMEPAD_DEADZONE;
            else
                val = -GAMEPAD_DEADZONE;
                
        }else if (Math.abs(val) > 1){
            if (val > 0)
                val = 1;
            else
                val = -1;
        }
        return val;
    }
    
    public int getAutonChoice() {
         return ((Integer) this.autonChoice.getSelected()).intValue();
    }
    
    private SendableChooser createChoices(String label, String [] choices) {
        SendableChooser send = new SendableChooser();
        
        if(choices.length > 0) {
            send.addDefault(choices[0], new Integer(0));
            
            for(int i = 1; i < choices.length; i++) {
                send.addObject(choices[i], new Integer(i));
            }
            
            SmartDashboard.putData(label, send);
        }
        
        return send;
    }
}

