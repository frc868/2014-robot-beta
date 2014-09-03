package com.techhounds;

/**
 * @author FRC 868
 */
public class RobotMap {
 
    public static class Controller {
        
        public static final int DRIVER = 1;
        public static final int TWEAKER = 2;
    }
    
    public static class Drive {
        
        public static final int LEFT_MOTORS = 0;
        public static final int RIGHT_MOTORS = 1;
        
        public static final int ENCODER_L_A = 2;
        public static final int ENCODER_L_B = 3;
        public static final int ENCODER_R_A = 0;
        public static final int ENCODER_R_B = 1;
    }
    
    public static class Shooter {
        
        public static final int FRONT_LEFT = 5;
        public static final int FRONT_RIGHT = 2;
        public static final int REAR_LEFT = 3;
        public static final int REAR_RIGHT = 4;
        
        public static final int ENCODER_FRONT_LEFT = 6;
        public static final int ENCODER_FRONT_RIGHT = 8;
        public static final int ENCODER_REAR_LEFT = 5;
        public static final int ENCODER_REAR_RIGHT = 7;
    }
    
    public static class Pneumatics {
        
        public static final int COLLECTOR_1 = 1;
        public static final int COLLECTOR_2 = 2;
        public static final int POPPER = 0;
        public static final int STOPPER = 4;
    }
    
    public static class Compressor {
        
        public static final int COMPRESSOR_SENSOR = 4;
        public static final int COMPRESSOR_RELAY = 0;
    }
    
    public static class Gyro {
        
        public static final int GYRO = 0;
    }
    
    public static class Kicker {
        
        public static final int KICKER = 6;
    }
    
    public static class Camera {
        
        public static final int CAMERA_LEDS = 1;
    }
}
