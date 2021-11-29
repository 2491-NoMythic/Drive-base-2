package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;

public class ParcelIntake extends TimedRobot {
    WPI_TalonSRX motor;
    private static ParcelIntake instance = null; 

    public static ParcelIntake getInstance()
    {
        if(instance == null)
        {
            instance = new ParcelIntake();
        }
      return instance;  
    }

    private ParcelIntake(){
        //use talon srx
        motor = new WPI_TalonSRX(Constants.ParcelIntake_ID);
    }

    public void RunIntake() // fix 
    {
    
        if(Robot.PS4.getRawButtonPressed(Constants.PS4.parcelIntakeID)){
            rotateMotor(Constants.ParcelIntakeSpeed);
        } 
        else if (Robot.PS4.getRawButton(Constants.PS4.ParcelOuttakeID))
        {
            rotateMotor(Constants.ParcelOuttakeSpeed);
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
