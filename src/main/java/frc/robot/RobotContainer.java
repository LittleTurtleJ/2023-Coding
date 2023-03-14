// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//If you are reading this congratulations on finding the secret easter egg
package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.auto.actions.Test;
import frc.robot.commands.*;
import frc.robot.subsystems.Arduino;
import frc.robot.subsystems.Arm;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final DriveTrain autoSDriveTrain = DriveTrain.getInstance();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  // private final CommandXboxController m_driverController =
      // new CommandXboxController(OperatorConstants.CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new Drive(m_exampleSubsystem));
    //     JoystickButton

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    OI.getInstance().getController().a().whileTrue(new MoveArm(Arm.getInstance(), .2));
    OI.getInstance().getController().b().whileTrue(new MoveArm(Arm.getInstance(), -.2));
    OI.getInstance().getController().leftBumper().whileTrue(new MoveArm(Arm.getInstance(), 0));

    OI.getInstance().getController().povRight().whileTrue();


    // OI.getInstance().getController().rightBumper().whileTrue(new Test());

    // OI.getInstance().getController().x().whileTrue(new UseGyro());
    // OI.getInstance().getController().y().whileTrue(new Test());

    //  OI.getInstance().getController().a().whileTrue(new Balance());
    //  OI.getInstance().getController().b().whileTrue(new LowScore());
    //  OI.getInstance().getController().x().whileTrue(new MidScore());
    //  OI.getInstance().getController().y().whileTrue(new HumanPlayer());

    // OI.getInstance().getController().x().whileTrue(new AutoDrive());

    OI.getInstance().getController().leftBumper().whileTrue(new IntakeSpin(Constants.Intake.INTAKE_SPEED));
    OI.getInstance().getController().rightBumper().whileTrue(new IntakeSpin(-Constants.Intake.INTAKE_SPEED));
    // OI.getInstance().getController().a().whileTrue(new Fancy());

    OI.getInstance().getController().x().whileTrue(new IntakePos(Constants.Intake.POS_INTAKE_SPEED));
    OI.getInstance().getController().y().whileTrue(new IntakePos(-Constants.Intake.POS_INTAKE_SPEED));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return AutoDrive.();
  // }
}