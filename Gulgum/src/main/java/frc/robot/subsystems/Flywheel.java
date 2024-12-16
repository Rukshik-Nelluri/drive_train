package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
    private CANSparkMax topFlywheelMotor, bottomFlywheelMotor;
    private Solenoid shooterLock;
    private static Flywheel flywheel;

    public Flywheel() {
        // topFlywheelMotor = new CANSparkMax(11, MotorType.kBrushless);
        bottomFlywheelMotor = new CANSparkMax(12, MotorType.kBrushless);
        bottomFlywheelMotor.restoreFactoryDefaults();
        
        shooterLock = new Solenoid(21, PneumaticsModuleType.REVPH, 6);
        // topFlywheelMotor.setIdleMode(IdleMode.kCoast);
        bottomFlywheelMotor.setIdleMode(IdleMode.kCoast);

        // topFlywheelMotor.setSmartCurrentLimit(40);
        bottomFlywheelMotor.setSmartCurrentLimit(40);
        // topFlywheelMotor.setInverted(true); 
        // bottomFlywheelMotor.follow(topFlywheelMotor);

        SmartDashboard.putNumber("flywheel motor speed", 0.0);
        SmartDashboard.putBoolean("flywheel solenoid", false);
    }

    public static Flywheel getInstance() {
        if (flywheel == null) {
            flywheel = new Flywheel();
        }
        return flywheel;
    }

    public void setMotor(double speed) {
        // topFlywheelMotor.set(speed);
        bottomFlywheelMotor.set(speed); 
    }

    public void setSolenoid(boolean bool) {
        shooterLock.set(bool);
    }

    @Override
    public void periodic() {
        // setMotor(SmartDashboard.getNumber("flywheel motor speed", 0.0));
        // setSolenoid(SmartDashboard.getBoolean("flywheel solenoid", false));
    }
}
