package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Superstructure extends SubsystemBase {
    private static Superstructure instance;
    private final Intake intake;
    private final Flywheel flywheel;
    private final Hopper hopper;
    public enum SuperstructureState {
        INTAKE,
        SHOOT,
        STOW,
        STOP_SHOOT
    }
    private SuperstructureState curState;
    private SuperstructureState nextState;
    private SuperstructureState requestedState;

    public Superstructure() {
        intake = Intake.getInstance();
        flywheel = Flywheel.getInstance();
        hopper = Hopper.getInstance();
        curState = SuperstructureState.STOW;
        nextState = SuperstructureState.STOW;
        requestedState = SuperstructureState.STOW;

        SmartDashboard.putBoolean("Hopper Sensor", false);
    }

    public void requestState(SuperstructureState state) {
        nextState = state;
    }

    public static Superstructure getInstance() {
        if (instance == null) {
            instance = new Superstructure();
        }
        return instance;
    }

    @Override
    public void periodic() {
        SmartDashboard.putString("curState", curState.toString());

        switch (curState) {
            case STOW:
                intake.runIntake(0);
                intake.pushSolenoid(false);
                hopper.runHopper(0);
                break;

            case INTAKE:
                intake.pushSolenoid(true);
                intake.runIntake(0.6);
                hopper.runHopper(0.6);
                flywheel.setMotor(0.5);
                if (SmartDashboard.getBoolean("Hopper Sensor", false)) {
                    nextState = SuperstructureState.STOW;
                }
                break;

            case SHOOT:
                flywheel.setSolenoid(true);
                hopper.runHopper(0.6);
                break;

            case STOP_SHOOT:
                flywheel.setSolenoid(false);
                flywheel.setMotor(0);
                hopper.runHopper(0.0); 
                break;

        }
        
        curState = nextState;
    }
}