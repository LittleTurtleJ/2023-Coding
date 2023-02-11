// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Solonoid extends SubsystemBase {
  private static Solonoid instance;
  Compress comp = Compress.getInstance();
  DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);
  Compressor compress = Compress.getInstance().getCompress();

  /** Creates a new Solonoid. */
  public Solonoid() {
    solenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void forward() {
    // comp.turnOff();
    solenoid.set(Value.kForward);
    SmartDashboard.putBoolean("forward", solenoid.isFwdSolenoidDisabled());
    // comp.turnOn();
  }

  public void backward() {
    // comp.turnOff();
    solenoid.set(Value.kReverse);
    SmartDashboard.putBoolean("backward", solenoid.isRevSolenoidDisabled());
    // comp.turnOn();
  }

  public static Solonoid getInstance() {
    if (instance == null) instance = new Solonoid();
    return instance;
  }
}
