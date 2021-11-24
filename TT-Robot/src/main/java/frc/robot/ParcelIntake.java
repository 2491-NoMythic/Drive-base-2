package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

public class ParcelIntake extends TimedRobot {
    CANSparkMax motor;
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
    motor = new CANSparkMax(Constants.ParcelIntake_ID, MotorType.kBrushless);
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
