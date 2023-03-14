// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto.actions;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class Test extends CommandBase {
  /** Creates a new Test. */
  private PIDController pidcontroller;
  public Test() {
    pidcontroller = new PIDController(Constants.PID.DRIVE_KP, Constants.PID.DRIVE_KI, Constants.PID.DRIVE_KD);
    pidcontroller.setSetpoint(75000);
    pidcontroller.setTolerance(500);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double pidValue = pidcontroller.calculate(DriveTrain.getInstance().getRLeader().getSelectedSensorPosition());
    DriveTrain.getInstance().arcadeDrive(pidValue, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // DriveTrain.getInstance().arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidcontroller.atSetpoint();
  }
}
