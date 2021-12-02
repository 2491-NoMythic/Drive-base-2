package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;

public class Elevator extends TimedRobot {
    WPI_TalonSRX motor;
    private static Elevator instance = null; 

    public static Elevator getInstance()
    {
        if(instance == null)
        {
            instance = new Elevator();
        }
      return instance;  
    }

    private Elevator(){
        //use talon srx
        motor = new WPI_TalonSRX(Constants.ParcelIntake.Intake_ID);
    }

    public void RunIntake() // fix 
    {
    
        if(Robot.PS4.getRawButtonPressed(Constants.PS4.ElevatorUpID)){
            //up
            rotateMotor(Constants.Elevator.UpSpeed);
        } 
        else if (Robot.PS4.getRawButton(Constants.PS4.ElevatorDownID))
        {
            //down
            rotateMotor(Constants.Elevator.DownSpeed);
        }
        else
        {
            stopMotor();
        }
    }

    public void rotateMotor(double speed)
    {
        motor.set(speed);
    }

    public void stopMotor() {
        motor.set(0);
      }
}
