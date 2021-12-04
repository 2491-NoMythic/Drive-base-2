package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CarrierIntake extends TimedRobot {
    CANSparkMax rightMotor, leftMotor;
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
  
        rightMotor = new CANSparkMax(Constants.CarrierIntake.RightMotorID, MotorType.kBrushless);
        leftMotor = new CANSparkMax(Constants.CarrierIntake.LeftMotorID, MotorType.kBrushless);
        leftMotor.follow(rightMotor, true);
    }

    public void RunIntake() // fix 
    {
        SmartDashboard.putNumber("Right carrier motor output current", rightMotor.getOutputCurrent());
        SmartDashboard.putNumber("left carrier motor output current", leftMotor.getOutputCurrent());
        
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
        rightMotor.set(speed);
    }


    public void stopMotor() {
        rightMotor.set(0);
      }
}
