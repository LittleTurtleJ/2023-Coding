package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class OI {
  private static OI oi;

  private CommandXboxController controller = new CommandXboxController(Constants.Controller.CONTROLLER_PORT);

  private OI() {}

  public double getThrottleAxis() {
    return -Math.pow(controller.getRawAxis(Constants.Controller.DRIVE_AXIS), Constants.Controller.POWER);
  }

  public double getTurnAxis() {
    return -Math.pow(controller.getRawAxis(Constants.Controller.TURN_AXIS), Constants.Controller.POWER);
  }

  public CommandXboxController getController() {
    return controller;
  }

  public static OI getInstance() {
    if (oi == null) {
      oi = new OI();
    }
    return oi;
  }
}