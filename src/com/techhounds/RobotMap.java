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
        
        public static final int LEFT_MOTORS = 8;
        public static final int RIGHT_MOTORS = 6;
        
        public static final int ENCODER_L_A = 8;
        public static final int ENCODER_L_B = 9;
        public static final int ENCODER_R_A = 6;
        public static final int ENCODER_R_B = 7;
    }
    
    public static class Compressor {
        
        //public static final int COMPRESSOR_SENSOR = 4;
        //public static final int COMPRESSOR_RELAY = 0;
        public static final int COMPRESSOR_PCM = 0;
    }
    
    public static class Gyro {
        
        public static final int GYRO = 0;
    }
    
    public static class Camera {
        
        public static final int CAMERA_LEDS = 1;
    }
}
