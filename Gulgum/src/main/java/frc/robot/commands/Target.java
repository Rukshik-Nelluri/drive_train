package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class Target extends Command {
    private Drivetrain drivetrain;
    private Limelight limelight;
    private PIDController pidController;
    private double error, ff, llTurn, threshold;

    public Target() {
        limelight = Limelight.getInstance();
        drivetrain = Drivetrain.getInstance();
        pidController = limelight.getPIDController();
        threshold = 1;
        error = 0;
        ff = 0.1;
        llTurn = 0;

        addRequirements(drivetrain, limelight);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
        if (limelight.hasTarget()) {
            error = limelight.getRollingTx();
            if (Math.abs(error) < threshold) {
                llTurn = 0;
            } else if (error < threshold) {
                llTurn = pidController.calculate(error) + ff;
            } else if (error > threshold) {
                llTurn = pidController.calculate(error) - ff;
            }
        } else {
            llTurn = 0;
        }

        
        
        SmartDashboard.putNumber("llTurn", -llTurn); 
    

        drivetrain.arcadeDrive(0, llTurn);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        error = limelight.getRollingTx();
        if(Math.abs(error)<threshold){
            return true; 
        }
        return false; 
    }
}
