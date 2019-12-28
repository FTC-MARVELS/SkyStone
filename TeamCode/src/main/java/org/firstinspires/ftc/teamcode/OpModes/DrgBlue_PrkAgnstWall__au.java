/* DrgBlue_PrkAgnstWall is a top level OpMode.
 * Drag blue foundation to blue building site, 
 *  then park under skybridge agaisnt wall.
 */

package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.WorkerClasses.AutonomousWorkerMethods;

@Autonomous(name = "DrgBlue_PrkAgnstWall", group = "")

public class DrgBlue_PrkAgnstWall__au extends LinearOpMode {
  
  // Declare OpMode members
    // private ElapsedTime runtime = new ElapsedTime();
    // private DcMotor leftDrive = null;
    // private DcMotor rightDrive = null;
    // DrgBlue_PrkAgnstWall__au dragblue = new DragBlue (name);
    // private DrgBlue_PrkAgnstWall__au PrkAgnstWall prkagnstwall;

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
    
    // declare worker class(es)
    AutonomousWorkerMethods workers = new AutonomousWorkerMethods();

    // call required methods in the correct order
    workers.dragBlue();           // drag blue foundation to building site
    workers.parkAgainstWall();    // park under skybridge, agaisnt wall
  }
}
