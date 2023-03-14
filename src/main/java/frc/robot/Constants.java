// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class Controller {
    public static final int CONTROLLER_PORT = 0;
    public static final int DRIVE_AXIS = 1;
    public static final int TURN_AXIS = 4;
    public static final double POWER = 5;
  }

  public static class DriveTrain {
    public static final int RIGHT_LEADER_PORT = 10;
    public static final int RIGHT_FOLLOW_PORT = 11;
    public static final int LEFT_LEADER_PORT = 12;
    public static final int LEFT_FOLLOW_PORT = 13;
    public static final double DEADBAND = 0.1; // .15
    public static final double MAX_OUTPUT = 1; // .8
    public static final double VOLT_COMP = 5.0; // 6
    public static final double AMP_LIMIT = 30.0; // 40
  }

  public static class Arm {
    public static final int ARM_PORT = 3;
    public static final int UPPER_LIMIT = 10000;
    public static final int LOWER_LIMIT = 0;
  }

  public static class Claw {
    public static final int L_FWD_PORT = 1;
    public static final int L_BWD_PORT = 0;
    public static final int R_FWD_PORT = 3;
    public static final int R_BWD_PORT = 2;
  }

  public static class PID {
    public static final double DRIVE_KP = .02;
    public static final double DRIVE_KI = .1;
    public static final double DRIVE_KD = .05;
  }

  public static class Intake {
    public static final int SPIN_PORT = 8;
    public static final int INTAKE_PORT = 4;
    public static final double INTAKE_SPEED = .7;
    public static final double UPPER_ROT = 10000;
    public static final double LOWER_ROT = 0;


    public static final int POS_SPIN_PORT = 2;
    public static final int POS_INTAKE_PORT = 4;
    public static final double POS_INTAKE_SPEED = .3;

  }

  public static class Temp {
    public static final boolean COMPRESS = false;
  }
}
