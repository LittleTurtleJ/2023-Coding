package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class Auto {
    SequentialCommandGroup auto = new SequentialCommandGroup(new Drive(DriveTrain.getInstance()), new Drive(DriveTrain.getInstance()));
    
}
