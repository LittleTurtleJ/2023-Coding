// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Compress extends SubsystemBase {
  private static Compress singleton;

  private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

  /** Creates a new Compressor. */
  public Compress() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void change(boolean enable) {
    if (enable) {
      compressor.enableDigital();
      SmartDashboard.putBoolean("CompOn", true);
    } else {
      compressor.disable();
      SmartDashboard.putBoolean("CompOn", false);
    }
  }

  public Compressor getCompress() {
    return compressor;
  }

  public boolean getCompOn() {
    return compressor.isEnabled();
  }

  public static Compress getInstance() {
    if (singleton == null) singleton = new Compress();
    return singleton;
  }
}
