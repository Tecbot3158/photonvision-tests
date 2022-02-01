// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BooleanSupplier;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tecbotcamera extends SubsystemBase {

  PhotonCamera pepethefrog;
  PhotonPipelineResult peperesult;

  /** Creates a new Photonvision. */
  public Tecbotcamera() {


  pepethefrog= new PhotonCamera("Pepe.the.frog");
   
  }

  @Override
  public void periodic() {
//System.out.println("kangaroo");

    double yaw = 0;
    double pitch = 0;
    double area = 0;
    boolean hasTargets = pepethefrog.getLatestResult().hasTargets();

    if(hasTargets == true){
      peperesult = pepethefrog.getLatestResult();
      PhotonTrackedTarget target = peperesult.getBestTarget();
      
      yaw = target.getYaw();
      pitch = target.getPitch();
      area = target.getArea();
  
      
    }
    

    // Shuffleboard.getTab("SmartDashboard").addBoolean(title, valueSupplier)

    SmartDashboard.putBoolean("targets", hasTargets);
    SmartDashboard.putNumber("yaw", yaw);
    SmartDashboard.putNumber("pitch", pitch);
    SmartDashboard.putNumber("area", area);
  }
}
