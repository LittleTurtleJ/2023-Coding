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
import frc.robot.Constants;

public class Solonoid extends SubsystemBase {
  private static Solonoid instance;
  DoubleSolenoid solenoidL = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Claw.L_FWD_PORT, Constants.Claw.L_BWD_PORT);
  DoubleSolenoid solenoidR = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Claw.R_FWD_PORT, Constants.Claw.R_BWD_PORT);

  /** Creates a new Solonoid. */
  public Solonoid() {
    solenoidL.set(Value.kReverse);
    solenoidR.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void change() {
    solenoidL.set(solenoidL.get() == Value.kForward ? Value.kReverse : Value.kForward);
    solenoidR.set(solenoidL.get() == Value.kForward ? Value.kReverse : Value.kForward);
  }

  public static Solonoid getInstance() {
    if (instance == null) instance = new Solonoid();
    return instance;
  }

  public void backward() {

    solenoidL.set(solenoidL.get() == Value.kForward ? Value.kReverse : Value.kForward);

  }
}
