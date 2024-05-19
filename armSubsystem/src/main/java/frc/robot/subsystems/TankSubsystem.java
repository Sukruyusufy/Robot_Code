// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.TankCostans;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/** Add your docs here. */
public class TankSubsystem extends SubsystemBase {

    private WPI_VictorSPX sagVictor = new WPI_VictorSPX(10);
    private WPI_VictorSPX solVictor = new WPI_VictorSPX(13);
    private WPI_TalonSRX sagTalon = new WPI_TalonSRX(11);
    private WPI_TalonSRX solTalon = new WPI_TalonSRX(12);

    // MotorControllerGroup sag = new MotorControllerGroup(solTalon, solVictor);
    // MotorControllerGroup sol = new MotorControllerGroup(sagTalon, sagVictor);

    public void tankforward() {
        sagVictor.setVoltage(TankCostans.tankspeed);
        sagTalon.setVoltage(TankCostans.tankspeed);
        solVictor.setVoltage(TankCostans.tankspeed);
        solTalon.setVoltage(TankCostans.tankspeed);
        return;
    }

    public void tankback() {
        sagVictor.setVoltage(-TankCostans.tankspeed);
        sagTalon.setVoltage(-TankCostans.tankspeed);
        solVictor.setVoltage(-TankCostans.tankspeed);
        solTalon.setVoltage(-TankCostans.tankspeed);
        return;
    }

    public void tankstop() {
        sagVictor.stopMotor();
        solVictor.stopMotor();
        sagTalon.stopMotor();
        sagVictor.stopMotor();
        return;
    }
    

}
