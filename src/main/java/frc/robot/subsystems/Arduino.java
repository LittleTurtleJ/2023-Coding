// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// https://www.youtube.com/watch?v=RMHCSwLIyqg

public class Arduino extends SubsystemBase {
  private static Arduino singleton;

  private static I2C wire = new I2C(Port.kOnboard, 4);
  private static int MAX = 32;
  /** Creates a new Arduino. */
  public Arduino() {}

  @Override
  public void periodic() {
    SmartDashboard.putNumber("test", wire.getPort());
    // This method will be called once per scheduler run
  }

  public void test(String text) {
    char[] chars = text.toCharArray();

    byte[] data = new byte[chars.length];
    for (int i = 0; i < chars.length; i++) {
      data[i] = (byte)chars[i];
    }

    wire.transaction(data, data.length, null, 0);
  }

  public static Arduino getInstance() {
    if (singleton == null) singleton = new Arduino();
    return singleton;
  }
}
