// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;

import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Timer;


public class Autos extends CommandBase {

  /** Example static factory for an autonomous command. */
  
    private DriveTrain autoDrive;
    
//Steps: Go forward a little, lift arm up, drop object onto thing, move back a lot.
  
  public void Drive(DriveTrain subsystem){
  autoDrive = subsystem;
  //addRequirements declares subsystem dependencies
  addRequirements(subsystem);

  autoDrive.arcadeDrive(0.75, 0.0);//forward
  double time = Timer.getFPGATimestamp();


  while (time < 5) {
    autoDrive.arcadeDrive(0.0, 0.75);//move forward
  }

  while (time < 7) {
    autoDrive.arcadeDrive(0.8,0);//turn
  }
  while (time < 15) {
    autoDrive.arcadeDrive(0, 0.75);
  }

  //Something here to lift arm up
  // autoDrive.arcadeDrive(0, 0);
}

public void execute(){

  double valueY = OI.getInstance().getThrottleAxis();
  double valueX = OI.getInstance().getTurnAxis();

  autoDrive.arcadeDrive(valueX, valueY);
}

public void end(boolean interrupted){}

  public boolean isfinished() 
  {return true; // end statement for movement preparation
  }
}