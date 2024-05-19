// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private WPI_VictorSPX m_armMotor1 = new WPI_VictorSPX(ArmConstants.m_armMotor1ID);
    private WPI_VictorSPX m_armMotor2 = new WPI_VictorSPX(ArmConstants.m_armMotor2ID);
    private WPI_VictorSPX m_armMotor3 = new WPI_VictorSPX(ArmConstants.m_armMotor3ID);
    private WPI_VictorSPX m_armMotor4 = new WPI_VictorSPX(ArmConstants.m_armMotor4ID);

    public void armUpper() {
        m_armMotor1.setVoltage(ArmConstants.armspeed);
        return;
    }
    
     public void armLower() {
        m_armMotor1.setVoltage(-ArmConstants.armspeed);
        return;
    }
      public void armstop() {
        m_armMotor1.stopMotor();
        return;
    }
    
}
