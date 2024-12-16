// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.utils.OI;
import edu.wpi.first.wpilibj2.command.Command;

public class Drive extends Command {
  private OI oi;
  private Drivetrain drivetrain;
  
  public Drive() {
    oi = OI.getInstance();
    drivetrain = Drivetrain.getInstance();
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(oi.getSpeed()*0.5, oi.getRotation()*0.75);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
