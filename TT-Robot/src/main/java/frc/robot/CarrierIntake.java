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
  
        motor = new CANSparkMax(Constants.CarrierIntake.MotorID, MotorType.kBrushed);
    }

    public void RunIntake() // fix 
    {
    
        if(Robot.PS4.getRawButtonPressed(Constants.PS4.CarrierIntakeID)){
            //up
            rotateMotor(Constants.CarrierIntake.IntakeSpeed);
        } 
        else if (Robot.PS4.getRawButtonPressed(Constants.PS4.CarrierOuttakeID))
        {
            //down
            rotateMotor(Constants.CarrierIntake.OuttakeSpeed);
        }
        else if (Robot.PS4.getRawButtonReleased(Constants.PS4.CarrierIntakeID) || (Robot.PS4.getRawButtonReleased(Constants.PS4.CarrierOuttakeID)))
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
