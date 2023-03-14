// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto.actions;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class AutoDrive extends CommandBase {
  /** Creates a new SidePosition. */

  private DriveTrain rightLeader;

  public AutoDrive(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain.getInstance());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    SmartDashboard.putBoolean(getName(), isFinished());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double position = DriveTrain.getInstance().getRLeader().getSelectedSensorPosition();

    if(position < 15000){
      // DriveTrain.arcadeDrive(.5, .5);

    }else{
      // DriveTrain.arcadeDrive(0, 0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    
  }
}
