// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {
  private static Intake singleton;
  
  private CANSparkMax intakeMotor;
  private CANSparkMax wristMotor;

  /** Creates a new Intake. */
  public Intake() {
    intakeMotor = new CANSparkMax(Constants.Intake.INTAKE_PORT, MotorType.kBrushless);
    wristMotor = new CANSparkMax(Constants.Intake.SPIN_PORT, MotorType.kBrushless);
    posDeadlock();
    // no();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spin(double speed) {
    intakeMotor.set(speed);
  }

  public void posSpin(double posSpeed){

    wristMotor.set(posSpeed);
  }


public void spinDeadlock(){
  intakeMotor.setIdleMode(IdleMode.kBrake);
}

public void no() {
  intakeMotor.setIdleMode(IdleMode.kCoast);
}

public void posDeadlock(){
  wristMotor.setIdleMode(IdleMode.kBrake);
}

  public static Intake getInstance() {
    if (singleton == null) singleton = new Intake();
    return singleton;
  }


  public RelativeEncoder getIntakeEncoder() {
    return intakeMotor.getEncoder();
  }

  public RelativeEncoder getPosEncoder(){
    return wristMotor.getEncoder();
  }
}
