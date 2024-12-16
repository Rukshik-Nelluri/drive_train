// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.utils.OI;

import java.sql.Driver;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  private OI oi;
  private Drivetrain drivetrain;
  private Intake intake;
  private Hopper hopper;
  private Flywheel flywheel;

  public RobotContainer() {
    oi = OI.getInstance();
    drivetrain = Drivetrain.getInstance();
    drivetrain.setDefaultCommand(new Drive());
    intake = Intake.getInstance();
    hopper = Hopper.getInstance();
    flywheel = Flywheel.getInstance();
  }

  public Command getAutonomousCommand() {
    return new InstantCommand();
  }
}
