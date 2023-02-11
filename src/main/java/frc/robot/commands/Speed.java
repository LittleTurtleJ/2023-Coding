package frc.robot.commands;
import frc.robot.subsystems.Accelerometer;
import frc.robot.subsystems.DriveTrain;
// Command to go with the accelerometer 

public class Speed{
    Accelerometer accel;
    double xSpeed;
    //double ySpeed;
    public Speed(Accelerometer a){
        accel = a;
    }
    public void setSpeed(){
        xSpeed = accel.getValue();
    }
}
