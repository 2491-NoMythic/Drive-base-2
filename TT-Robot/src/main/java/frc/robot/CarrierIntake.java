package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

public class CarrierIntake extends TimedRobot {
    CANSparkMax motor;
    private static CarrierIntake instance = null; 

    public static CarrierIntake getInstance()
    {
        if(instance == null)
        {
            instance = new CarrierIntake();
        }
      return instance;  
    }

    private CarrierIntake(){
  
        motor = new CANSparkMax(Constants.CarrierIntake.CarrierIntake_ID, MotorType.kBrushed);
    }

    public void RunIntake() // fix 
    {
    
        if(Robot.PS4.getRawButtonPressed(Constants.PS4.CarrierIntakeID)){
            rotateMotor(Constants.CarrierIntake.CarrierIntakeSpeed);
        } 
        else if (Robot.PS4.getRawButton(Constants.PS4.CarrierIntakeID))
        {
            rotateMotor(Constants.CarrierIntake.CarrierOutttakeSpeed);
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