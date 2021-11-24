package frc.robot;

import javax.lang.model.util.ElementScanner6;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ParcelIntake extends TimedRobot {
    CANSparkMax motor;

    public ParcelIntake(){
        //use talon srx
    motor = new CANSparkMax(Constants.ParcelIntake_ID, MotorType.kBrushless);
    }

    public void ParcelIntakeRun()
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
