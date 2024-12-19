package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.function.BooleanConsumer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.LimelightHelper;
import frc.robot.utils.RollingAverage;

public class Limelight extends SubsystemBase {
    private static Limelight limelight;
    private String limelightName;
    private RollingAverage TxRollingAverage, TyRollingAverage;
    private PIDController pidController;

    public Limelight() {
        limelightName = "limelight";
        TxRollingAverage = new RollingAverage(5);
        TyRollingAverage = new RollingAverage(5);
        pidController = new PIDController(0.01, 0, 0);
    }

    public double getTx() {
        return LimelightHelper.getTX(limelightName);
    }

    public double getTy() {
        return LimelightHelper.getTY(limelightName);
    }

    public Boolean getTv(){
        return LimelightHelper.getTV(limelightName); 
    }

    public PIDController getPIDController() {
        return pidController;
    }

    public void updateRollingAverage() {
        if (hasTarget()){
            TxRollingAverage.addValue(getTx());
            TyRollingAverage.addValue(getTy());
        }
    }

    public boolean hasTarget(){
        return getTv(); 
    }

    public double getRollingTx() {
        return TxRollingAverage.average();
    }

    public double getRollingTy() {
        return TyRollingAverage.average();
    }

    public static Limelight getInstance() {
        if (limelight == null) {
            limelight = new Limelight();
        }
        return limelight;
    }
    @Override
    public void periodic() {
        updateRollingAverage(); 
        SmartDashboard.putBoolean("HAS TARGET", hasTarget());
        SmartDashboard.putNumber("TX", getRollingTx()); 
    }
}

