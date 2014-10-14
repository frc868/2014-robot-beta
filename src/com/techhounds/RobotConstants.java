/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.techhounds;

/**
 * @author Atif Niyaz
 */
public class RobotConstants {
    
    public static class Debug {
        
        // Subsystem Debug Info
        public static final boolean DRIVE_DEBUG_INFO = true;
        public static final boolean SHOOTER_DEBUG_INFO = true;
        
        // Command Buttons
        public static final boolean ROTATION_BUTTONS = false;
        public static final boolean EXTRA_SMARTDASHBOARD_BUTTONS = true;
    }
    
    public static class Driving {
        
        public static final double TWEAKER_MAG_MULT_50 = 0.9;
        public static final double TWEAKER_ROT_MULT_50 = 0.9;
        
        public static final double TWEAKER_MAG_MULT_100 = 0.9;
        public static final double TWEAKER_ROT_MULT_100 = 0.9;
    }
    
    public static class Auton {
        
        public static final double DISTANCE = 10.5;
        public static final double SECOND_BALL_DISTANCE = 12.25;
        public static final double SPEED = -1.0;
        
        public static final double CHEEZY_TIMEOUT_ONE_BALL = 6.5;
        public static final double CHEEZY_TIMEOUT_TWO_BALL = 2.0;
        public static final double WAIT_AFTER_FIRE = 1.5;
    }
}
