package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase {
    private static Hopper instance;
    private CANSparkMax hopperMotor;

    public Hopper() {
        hopperMotor = new CANSparkMax(8, MotorType.kBrushless);
        hopperMotor.setSmartCurrentLimit(20);
    }

    public void runHopper(double speed) {
        hopperMotor.set(-speed);
    }

    public static Hopper getInstance() {
        if (instance == null) {
            instance = new Hopper();
        }
        return instance;
    }

}
