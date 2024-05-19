// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ArmConstants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final TankSubsystem m_tank = new TankSubsystem();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final CommandPS5Controller driverXbox = new CommandPS5Controller(1);
  // private Joystick m_lefStick;
  // private Joystick m_rightStick;
  private RobotContainer m_robotContainer;

  public RobotContainer() { /** Robotun kapsayıcısı. Alt sistemleri, OI cihazlarını ve komutları içerir. */

    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    driverXbox.button(4).whileTrue(
        new InstantCommand(() -> {
          SmartDashboard.putBoolean("Arm Yukarı", true);
          SmartDashboard.putNumber("arm hızı", Constants.ArmConstants.m_armMotor1ID);
          m_arm.armUpper();
        }));

    driverXbox.button(4).whileFalse(
        new InstantCommand(() -> {
          m_arm.armstop();
        }));

    driverXbox.button(5).whileTrue(
        new InstantCommand(() -> {
          m_arm.armLower();
        }));
    driverXbox.button(6).whileFalse(
        new InstantCommand(() -> {
          m_arm.armstop();
        }));

    driverXbox.button(7).whileTrue(
        new InstantCommand(() -> {
          m_tank.tankforward();
        }));
     driverXbox.button(7).whileFalse(
        new InstantCommand(() -> {
          m_tank.tankstop();
        }));

      driverXbox.button(8).whileTrue(
        new InstantCommand(() -> {
          m_tank.tankback();
        }));
      driverXbox.button(7).whileFalse(
        new InstantCommand(() -> {
          m_tank.tankstop();
        }));
        
        
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
