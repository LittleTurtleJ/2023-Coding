// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 
public class Arm extends SubsystemBase {
  private static Arm arm;

  private CANSparkMax motor;

  public Arm() {
    motor = new CANSparkMax(Constants.Arm.ARM_PORT, MotorType.kBrushless);
    
    // applyChanges();
    changes();
  }
  
  @Override
  public void periodic() {}

  public void moveArm(double speed) {
    motor.set(speed);
  }

  public RelativeEncoder getEncoder() {
    return motor.getEncoder();
  }

  private void applyChanges() {
    motor.enableSoftLimit(SoftLimitDirection.kForward, true);
    motor.enableSoftLimit(SoftLimitDirection.kReverse, true);

    motor.setSoftLimit(SoftLimitDirection.kForward, Constants.Arm.UPPER_LIMIT);
    motor.setSoftLimit(SoftLimitDirection.kReverse, Constants.Arm.LOWER_LIMIT);
  }

  private void changes() {
    motor.enableSoftLimit(SoftLimitDirection.kForward, false);
    motor.enableSoftLimit(SoftLimitDirection.kReverse, false);
  }

  public static Arm getInstance(){
    if(arm == null) arm = new Arm();
    return arm;
  }
}
