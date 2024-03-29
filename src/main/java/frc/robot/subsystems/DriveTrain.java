// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrain extends SubsystemBase {
  public double amount = 0;

  private static DriveTrain driveTrain;

  private static WPI_TalonFX leftLeader = new WPI_TalonFX(Constants.DriveTrain.LEFT_LEADER_PORT);
  private WPI_TalonFX leftFollow = new WPI_TalonFX(Constants.DriveTrain.LEFT_FOLLOW_PORT);
  private static WPI_TalonFX rightLeader = new WPI_TalonFX(Constants.DriveTrain.RIGHT_LEADER_PORT);
  private WPI_TalonFX rightFollow = new WPI_TalonFX(Constants.DriveTrain.RIGHT_FOLLOW_PORT);

  private static DifferentialDrive chassis = new DifferentialDrive(leftLeader, rightLeader);

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    //makes Follows follow leader, inverts right side
    rightLeader.setInverted(true);
    rightFollow.setInverted(true);
    leftFollow.follow(leftLeader); 
    rightFollow.follow(rightLeader);
    
    chassis.setDeadband(Constants.DriveTrain.DEADBAND);
    chassis.setMaxOutput(Constants.DriveTrain.MAX_OUTPUT);

    applyChanges();
    setDriveEncoder(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static void arcadeDrive(double throttle, double turn) {
    chassis.arcadeDrive(throttle, turn, false);

  }

  public static void setMaxLimit(double maxSpeed){
      
    chassis.setMaxOutput(maxSpeed);
  }

  private void applyChanges() {
    // Resets motors to factory default
    rightLeader.configFactoryDefault();
    rightFollow.configFactoryDefault();
    leftLeader.configFactoryDefault();
    leftFollow.configFactoryDefault();

    //sets voltage compensation (very important!)
    rightLeader.configVoltageCompSaturation(Constants.DriveTrain.VOLT_COMP);
    rightFollow.configVoltageCompSaturation(Constants.DriveTrain.VOLT_COMP);
    leftLeader.configVoltageCompSaturation(Constants.DriveTrain.VOLT_COMP);
    leftFollow.configVoltageCompSaturation(Constants.DriveTrain.VOLT_COMP);

    // Enables voltage compensation
    rightLeader.enableVoltageCompensation(true);
    rightFollow.enableVoltageCompensation(true);
    leftLeader.enableVoltageCompensation(true);
    leftFollow.enableVoltageCompensation(true);
  
    //sets input current limit to motors
    rightLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, Constants.DriveTrain.AMP_LIMIT, Constants.DriveTrain.AMP_LIMIT, 0));
    rightFollow.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, Constants.DriveTrain.AMP_LIMIT, Constants.DriveTrain.AMP_LIMIT, 0));
    leftLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, Constants.DriveTrain.AMP_LIMIT, Constants.DriveTrain.AMP_LIMIT, 0));
    leftFollow.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, Constants.DriveTrain.AMP_LIMIT, Constants.DriveTrain.AMP_LIMIT, 0));

    rightLeader.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    leftLeader.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
  }

  public static DriveTrain getInstance() {
    if (driveTrain == null) driveTrain = new DriveTrain();
    return driveTrain;
  }

  public WPI_TalonFX getLLeader() {
    return leftLeader;
  }

  public WPI_TalonFX getRLeader() {
    return rightLeader;
  }

  public WPI_TalonFX getLFollow() {
    return leftFollow;
  }

  public WPI_TalonFX getRFollow() {
    return rightFollow;
  }

  public void setDriveEncoder(int value) {
    leftLeader.setSelectedSensorPosition(value);
    rightLeader.setSelectedSensorPosition(value);
  }
}
