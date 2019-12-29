package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Fndtn_In_AwayFrm_Wall", group = "")
public class Fndtn_In_AwayFrm_Wall__au extends LinearOpMode {

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

    // Put initialization blocks here.
    PullServoAsServo.setPosition(0.2);
    PullServo2AsServo.setPosition(0.9);
    FrontDriveMotorAsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    RightDriveMotorAsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    LeftDriveMotorAsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    BackDriveMotorAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    RightDriveMotorAsDcMotor.setPower(0.5);
    FrontDriveMotorAsDcMotor.setPower(0.5);
    sleep(1500);
    RightDriveMotorAsDcMotor.setPower(0);
    FrontDriveMotorAsDcMotor.setPower(0);
    sleep(100);
    PullServoAsServo.setPosition(0.9);
    PullServo2AsServo.setPosition(0.1);
    sleep(1000);
    RightDriveMotorAsDcMotor.setPower(-0.5);
    FrontDriveMotorAsDcMotor.setPower(-0.5);
    sleep(2550);
    RightDriveMotorAsDcMotor.setPower(0);
    FrontDriveMotorAsDcMotor.setPower(0);
    sleep(100);
    PullServoAsServo.setPosition(0.2);
    PullServo2AsServo.setPosition(0.9);
    sleep(1000);
    LeftDriveMotorAsDcMotor.setPower(-0.5);
    BackDriveMotorAsDcMotor.setPower(-0.5);
    sleep(2000);
    LeftDriveMotorAsDcMotor.setPower(0);
    BackDriveMotorAsDcMotor.setPower(0);
    sleep(200);
    RightDriveMotorAsDcMotor.setPower(0.5);
    FrontDriveMotorAsDcMotor.setPower(0.5);
    sleep(750);
    RightDriveMotorAsDcMotor.setPower(0);
    FrontDriveMotorAsDcMotor.setPower(0);
    sleep(200);
    LeftDriveMotorAsDcMotor.setPower(0.5);
    BackDriveMotorAsDcMotor.setPower(0.5);
    sleep(2250);
    LeftDriveMotorAsDcMotor.setPower(0);
    BackDriveMotorAsDcMotor.setPower(0);
  }
}
