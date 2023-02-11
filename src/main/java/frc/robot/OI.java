package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class OI {

   private static final int DRIVE_THROTTLE_AXIS = 1;
   private static final int DRIVE_TURN_AXIS = 0;
   private static final double POWER = 5;

   private CommandXboxController controller;

   private static OI oi;
   
//    public double getLeftIn(){
//         return controller.getRawAxis(1);
//    }
//    public double getRightin(){
//         return controller.getRawAxis(3);
//    }
   public CommandXboxController getController() {
        return controller;
   }

public double getThrottleAxis() {
     return -Math.pow(controller.getRawAxis(DRIVE_THROTTLE_AXIS), POWER);   
}   
public double getTurnAxis() {
     return Math.pow(controller.getRawAxis(DRIVE_TURN_AXIS), POWER);

}

   private OI() { //Runs on class init
     controller = new CommandXboxController(Constants.CONTROLLER_PORT);
   }

   public static OI getInstance(){
    if(oi == null){
        oi = new OI();
    }
    return oi;
   }

}
