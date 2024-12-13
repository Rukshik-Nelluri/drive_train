// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.util.OI;
import edu.wpi.first.wpilibj2.command.Command;

public class ReverseIntake extends Command {
  private Intake intake;
  private Hopper hopper;
  
  public ReverseIntake() {
    intake = Intake.getInstance();
    hopper = Hopper.getInstance();
    addRequirements(intake, hopper);
  }

  @Override
  public void initialize() {
    intake.pushSolenoid(true);
    intake.runIntake(-0.75);
    hopper.runHopper(-0.5);
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