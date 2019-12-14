/* DrgRed_PrkAgnstWall is a top level OpMode.
 * Drag red foundation to red building site, 
 *  then park under skybridge agaisnt wall.
 */

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "DrgRed_PrkAgnstWall", group = "")

public class DrgRed_PrkAgnstWall__au extends LinearOpMode {

  private Servo PullServoAsServo;
  private Servo PullServo2AsServo;
  private DcMotor FrontDriveMotorAsDcMotor;
  private DcMotor RightDriveMotorAsDcMotor;
  private DcMotor LeftDriveMotorAsDcMotor;
  private DcMotor BackDriveMotorAsDcMotor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    PullServoAsServo = hardwareMap.servo.get("PullServoAsServo");
    PullServo2AsServo = hardwareMap.servo.get("PullServo2AsServo");
    FrontDriveMotorAsDcMotor = hardwareMap.dcMotor.get("FrontDriveMotorAsDcMotor");
    RightDriveMotorAsDcMotor = hardwareMap.dcMotor.get("RightDriveMotorAsDcMotor");
    LeftDriveMotorAsDcMotor = hardwareMap.dcMotor.get("LeftDriveMotorAsDcMotor");
    BackDriveMotorAsDcMotor = hardwareMap.dcMotor.get("BackDriveMotorAsDcMotor");

    // call required methods in the correct order
    dragRed();            // drag red foundation to building site
    parkAgainstWall();    // park under skybridge, agaisnt wall
  }
}
