package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

public class ParcelIntake extends TimedRobot {
    CANSparkMax motor;
    public ParcelIntake(){
    motor = new CANSparkMax(Constants.ParcelIntake_ID, MotorType.kBrushless);
    }

    public void teleopPeriodic()
    {

    }
}
