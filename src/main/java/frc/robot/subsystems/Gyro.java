// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gyro extends SubsystemBase {
  private static Gyro singleton;
  private AHRS gyro = new AHRS(Port.kMXP);

  /** Creates a new Gyro. */
  public Gyro() {
    gyro.calibrate();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void printAll() {
    SmartDashboard.putNumber("Yaw", gyro.getYaw());
    SmartDashboard.putNumber("Pitch", gyro.getPitch());
    SmartDashboard.putNumber("Roll", gyro.getRoll());
  }

  public double getYaw() {
    return gyro.getYaw();
  }

  public double getPitch() {
    return gyro.getPitch();
  }

  public AHRS getGyro() {
    return gyro;
  }

  public static Gyro getInstance() {
    if (singleton == null) singleton = new Gyro();
    return singleton;
  }
}
