// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;



public class Accelerometer extends SubsystemBase {
  /** Creates a new Accelerometer. */
  double prevXAccel = 0;
  //double prevYAccel = 0;

  BuiltInAccelerometer accelerometer;
  double xAccel = accelerometer.getX();
  //double yAccel = accelerometer.getY();

  public Accelerometer() {
    accelerometer = new BuiltInAccelerometer();
  }



  //@Override
  public void periodic() {
    // This method will be called once per scheduler run
    double xJerk = (xAccel - prevXAccel) * 0.02;
    //double yJerk = (yAccel - prevYAccel) * 0.02; //Multiply by 0.02 because repeats every 20 ms
    
    //makes it so that if you're going too fast, the robot stops moving(?)
    if (xJerk >= 10)  {
      DriveTrain.stop();
    }

    /*
    if (yJerk >= 10) {
      DriveTrain.stop();
    }
    */

    prevXAccel = xAccel;
    //prevYAccel = yAccel;
    //it's about drive, it is about power, we stay hungry, we devour

  }
  public double getValue(){
    return prevXAccel;
  }



}
