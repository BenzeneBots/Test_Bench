// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static com.revrobotics.CANSparkBase.ControlType.kPosition;
import static com.revrobotics.CANSparkLowLevel.MotorType.kBrushless;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
 //public boolean getLimitSwitchState(){
   // return limitSwitch.get();
  //}

  private final Joystick j = new Joystick(0);
  private final JoystickButton b = new JoystickButton(j, 1);
  private final JoystickButton c = new JoystickButton(j, 2);
  private final JoystickButton d = new JoystickButton(j, 3);
//  private final TalonFX leader = new TalonFX(46);
//  private final TalonFX follower = new TalonFX(47);

  private final TalonFX shoot4 = new TalonFX(57);
  private final TalonFX shoot1 = new TalonFX(56);
  private final TalonFX shoot2 = new TalonFX(55);
  private final TalonFX shoot3 = new TalonFX(58);
  private final CANSparkMax intakeTurnerLead = new CANSparkMax(49, kBrushless);
  private final CANSparkMax intakeTurnerFollow = new CANSparkMax(51, kBrushless);
  private final TalonFX shoot = new TalonFX(60);
  private final TalonFX intakeTurner = new TalonFX(60);


  @Override
  public void robotInit() {
    intakeTurnerFollow.follow(intakeTurnerLead, true);
  }
  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("d1", d1.get());
    SmartDashboard.putBoolean("d2", d2.get());
    SmartDashboard.putBoolean("d3", d3.get());
    SmartDashboard.putBoolean("d4", d4.get());
    if(b.getAsBoolean()) {
      intakeTurnerLead.set(0.5);
    } else if(c.getAsBoolean()) {
      intakeTurnerLead.set(-0.5);
    } else {
      intakeTurnerLead.stopMotor();
      intakeTurnerFollow.stopMotor();
    }
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    /*if(on.getAsBoolean()) {
      motor.set(1);
    } else {
      motor.stopMotor();
    }*/
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
