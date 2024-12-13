// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Flywheel;
import frc.robot.util.OI;
import edu.wpi.first.wpilibj2.command.Command;

public class StartFlywheel extends Command {
  private Flywheel flywheel;
  
  public StartFlywheel() {
    flywheel = Flywheel.getInstance();
    addRequirements(flywheel);
  }

  @Override
  public void initialize() {
    flywheel.setMotor(0.6);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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