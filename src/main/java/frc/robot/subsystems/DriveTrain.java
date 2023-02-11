// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrain extends SubsystemBase {
  
public static final double DEADBAND = 0.15;
public static final double MAX_OUTPUT = 0.8;
public static final double VOLT_COMP = 6.0;
public static final double AMP_LIMIT = 40.0;
public double amount = 0;

  private static DriveTrain driveTrain;
//You might not want to make it static
//I just made it static because the accelerometer was crying
//Bonus points, guess who made this.
  private static WPI_TalonFX leftLeader = new WPI_TalonFX(Constants.OperatorConstants.LEFT_LEADER_PORT);
  private static WPI_TalonFX leftFollow = new WPI_TalonFX(Constants.OperatorConstants.LEFT_FOLLOW_PORT);
  private static WPI_TalonFX rightLeader = new WPI_TalonFX(Constants.OperatorConstants.RIGHT_LEADER_PORT);
  private static WPI_TalonFX rightFollow = new WPI_TalonFX(Constants.OperatorConstants.RIGHT_FOLLOW_PORT);

  private DifferentialDrive chassis = new DifferentialDrive(leftLeader, rightLeader);

  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    //makes Follows follow leader, inverts right side
    rightLeader.setInverted(true);
    // leftLeader.setInverted(true);
    rightFollow.setInverted(true);
    // leftFollow.setInverted(true);
    leftFollow.follow(leftLeader); 
    rightFollow.follow(rightLeader);
    

    chassis.setDeadband(DEADBAND);
    chassis.setMaxOutput(MAX_OUTPUT);

    applyChanges();
    setDriveEncoder(0);
  }

  // public void tankDrive(double leftInput, double rightInput){
  //   leftLeader.set(leftInput);
  //   rightLeader.set(rightInput);


  // }


  public static void stop() {
    rightLeader.set(0);
    leftLeader.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


  public void arcadeDrive(double throttle, double turn) {
    chassis.arcadeDrive(throttle, turn, false);

  }

  private void applyChanges() {
    // Resets motors to factory default
    rightLeader.configFactoryDefault();
    rightFollow.configFactoryDefault();
    leftLeader.configFactoryDefault();
    leftFollow.configFactoryDefault();

    //sets voltage compensation (very important!)
    rightLeader.configVoltageCompSaturation(VOLT_COMP);
    rightFollow.configVoltageCompSaturation(VOLT_COMP);
    leftLeader.configVoltageCompSaturation(VOLT_COMP);
    leftFollow.configVoltageCompSaturation(VOLT_COMP);

    // Enables voltage compensation
    rightLeader.enableVoltageCompensation(true);
    rightFollow.enableVoltageCompensation(true);
    leftLeader.enableVoltageCompensation(true);
    leftFollow.enableVoltageCompensation(true);
  
    //sets input current limit to motors
    rightLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
    rightFollow.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
    leftLeader.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));
    leftFollow.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, AMP_LIMIT, AMP_LIMIT, 0));

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
public void autoDrive(long time) {
  long t = System.currentTimeMillis();
  long end = t + time;

  while(System.currentTimeMillis() < end) {
      SmartDashboard.putNumber("Time", amount++);
      arcadeDrive(0.5, 0);
  }
}

}
