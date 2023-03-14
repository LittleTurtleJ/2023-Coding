// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto.modes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.auto.actions.AutoDrive;
import frc.robot.auto.actions.NEO;
import frc.robot.auto.actions.SpinNEO;
import frc.robot.auto.actions.ArmPos;

public class Middle extends CommandBase {
  /** Creates a new Middle. */
  public Middle() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SequentialCommandGroup yes = new SequentialCommandGroup(
      new ParallelCommandGroup(
        new AutoDrive(1),
        new NEO()
      ), new ArmPos(),
      new SpinNEO(),
      new ParallelCommandGroup(
        new AutoDrive(1),
        new NEO()
      )
    );
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
