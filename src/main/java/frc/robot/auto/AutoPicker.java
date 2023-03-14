package frc.robot.auto;

import java.util.Optional;
import frc.robot.auto.modes.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoPicker {
  enum Mode {
    NOTHING,
    MIDDLE,
    SIDE
  }

  private Mode chached = Mode.NOTHING;

  private final SendableChooser<Mode> modeChooser;

  private Optional autoMode = Optional.empty();

  public AutoPicker() {
    modeChooser = new SendableChooser<>();
    modeChooser.setDefaultOption("Do Nothing", Mode.NOTHING);
    modeChooser.addOption("Middle", Mode.MIDDLE);
    modeChooser.addOption("Side", Mode.SIDE);
    SmartDashboard.putData("Auto Mode", modeChooser);
  }

  public void update() {
    Mode desired = modeChooser.getSelected();

    if (desired == null) desired = Mode.NOTHING;
    if (chached != desired) {
      System.out.println("Updating auto mode to -> " + desired.name());
      autoMode = getAutoParams(desired);
    }

    chached = desired;
  }

  private Optional getAutoParams(Mode mode) {
    switch (mode) {
      case NOTHING:
        return Optional.of(new Nothing());
      case MIDDLE:
        return Optional.of(new Middle());
      case SIDE:
        return Optional.of(new Side());
      default:
        break;
    }
    
    System.out.println("No valid mode found for " + mode);
    return Optional.empty();
  }

  public void reset() {
    autoMode = Optional.empty();
    chached = Mode.NOTHING;
  }

  public void outputToSmartDashboard() {
    SmartDashboard.putString("AutoModeSelected", chached.name());
  }

  public Optional getAutoMode() {
    return autoMode;
  }
}
