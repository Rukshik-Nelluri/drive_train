package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private static Intake instance;
    private CANSparkMax intakeMotor;
    private Solenoid intakeSolenoid;

    public Intake() {
        intakeMotor = new CANSparkMax(7, MotorType.kBrushed);
        intakeSolenoid = new Solenoid(21, PneumaticsModuleType.REVPH, 7);
        intakeMotor.setSmartCurrentLimit(20);
    }

    public void pushSolenoid(boolean bool) {
        intakeSolenoid.set(bool);
    }

    public void runIntake(double speed) {
        intakeMotor.set(speed);
    }

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }
}
