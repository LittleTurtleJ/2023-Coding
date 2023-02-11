// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutoDrive extends CommandBase {



  public AutoDrive(){
    addRequirements(DriveTrain.getInstance());
  }
  /** Creates a new AutoDrive. */
  // private Timer timer = new Timer();

  // private double xSpeed;
  // private double ySpeed;
  // private double timeDuration;
  // public AutoDrive(double x, Double y, Double time) {
  //   timer.start();

  //   xSpeed = x;
  //   ySpeed = y;
  //   timeDuration = time;
    // Use addRequirements() here to declare subsystem dependencies.
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    SmartDashboard.putBoolean("Finished", false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveTrain.getInstance().autoDrive(2000L);

    // DriveTrain.getInstance().arcadeDrive(xSpeed, ySpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
SmartDashboard.putBoolean("Finished", true);  
}
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      // if (timer.get() >= timeDuration) {
      //   return true;
      // } else {
      //   return false;
      // }
      return false;

  }
}