// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.sql.DriverAction;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.OI;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax leftMotorMaster, leftMotorFollower1, leftMotorFollower2;
  private CANSparkMax rightMotorMaster, rightMotorFollower1, rightMotorFollower2;

  private DifferentialDrive drive;
  private static Drivetrain instance;

  public Drivetrain() {
    leftMotorMaster = new CANSparkMax(4, MotorType.kBrushless);
    leftMotorFollower1 = new CANSparkMax(5, MotorType.kBrushless);
    leftMotorFollower2 = new CANSparkMax(6, MotorType.kBrushless);
    rightMotorMaster = new CANSparkMax(1, MotorType.kBrushless);
    rightMotorFollower1 = new CANSparkMax(2, MotorType.kBrushless);
    rightMotorFollower2 = new CANSparkMax(3, MotorType.kBrushless);

    leftMotorFollower1.follow(leftMotorMaster);
    leftMotorFollower2.follow(leftMotorMaster);
    rightMotorFollower1.follow(rightMotorMaster);
    rightMotorFollower2.follow(rightMotorMaster);

    drive = new DifferentialDrive(leftMotorMaster, rightMotorMaster);
  }

  public void arcadeDrive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public static Drivetrain getInstance() {
    if (instance == null) {
      instance = new Drivetrain();
    }
    return instance;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("speed", OI.getInstance().getSpeed());
    SmartDashboard.putNumber("rotation", OI.getInstance().getRotation());
  }
}
