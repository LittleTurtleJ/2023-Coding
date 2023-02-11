// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
 
public class Arm extends SubsystemBase {
  private static final int ARM_MOTOR_PORT = 0;
  private static Arm arm;


  /** Creates a new Arm. */
  public Arm() {
    
  }
  
  private  WPI_TalonFX armMotor= new WPI_TalonFX(ARM_MOTOR_PORT);

  public void moveArm(double speed) {
    armMotor.set(speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public static Arm getInstance(){
    if(arm == null){
      arm = new Arm();
    }
    return arm;
  }
}
