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

  Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

  /** Creates a new Compressor. */
  public Compress() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void turnOn() {
    compressor.enableDigital();
    SmartDashboard.putBoolean("Running", compressor.isEnabled());
    SmartDashboard.putBoolean("On", true);
  }

  public void turnOff() {
    compressor.disable();
    SmartDashboard.putBoolean("Running", compressor.isEnabled());
    SmartDashboard.putBoolean("On", false);
  }

  public Compressor getCompress() {
    return compressor;
  }

  public static Compress getInstance() {
    if (singleton == null) singleton = new Compress();
    return singleton;
  }
}
