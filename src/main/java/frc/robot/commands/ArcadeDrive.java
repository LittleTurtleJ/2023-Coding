// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


// public class ArcadeDrive extends CommandBase {

//   private WPI_TalonFX leftLeader = new WPI_TalonFX(Constants.OperatorConstants.LEFT_LEADER_PORT);
//   private WPI_TalonFX leftFollow = new WPI_TalonFX(Constants.OperatorConstants.LEFT_FOLLOW_PORT);
//   private WPI_TalonFX rightLeader = new WPI_TalonFX(Constants.OperatorConstants.RIGHT_LEADER_PORT);
//   private WPI_TalonFX rightFollow = new WPI_TalonFX(Constants.OperatorConstants.RIGHT_FOLLOW_PORT);
  
//   //private DifferentialDrive chassis = new DifferentialDrive(leftLeader, rightLeader);

//   /** Creates a new ArcadeDrive. */
//   public ArcadeDrive() {
//     // Use addRequirements() here to declare subsystem dependencies.
//     leftFollow.follow(leftLeader);
//     rightFollow.follow(rightLeader);
//    // chassis.arcadeDrive(0, 0);
//   }



//   public void arcadeDrive(double leftInput, double rightInput){
//     double leftSpeed = leftInput - rightInput;
//     double rightSpeed = leftInput + rightInput;

//     leftLeader.set(leftSpeed);
//     rightLeader.set(rightSpeed);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {//Wow, I am a comment in an unconventional location


//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {


//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return false;
//   }
  
// }