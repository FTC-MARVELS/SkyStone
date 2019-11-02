var Drive1, Drive2, Drive3, Drive4, XrailUp, XrailForward, XrailDown, XrailBackWard, rotate, grip;

/**
 * This function is executed when this Op Mode is selected from the Driver Station.
 */
function runOpMode() {
  linearOpMode.waitForStart();
  if (linearOpMode.opModeIsActive()) {
    while (linearOpMode.opModeIsActive()) {
      Drive1 = gamepad1.getLeftStickX();
      BackDriveMotorAsDcMotor.setPower(Drive1);
      Drive2 = gamepad1.getRightStickX();
      FrontDriveMotorAsDcMotor.setPower(-Drive2);
      Drive3 = gamepad1.getLeftStickY();
      LeftDriveMotorAsDcMotor.setPower(Drive3);
      Drive4 = gamepad1.getRightStickY();
      RightDriveMotorAsDcMotor.setPower(-Drive4);
      XrailUp = gamepad2.getLeftStickY();
      XrailUp1AsDcMotor.setPower(XrailUp);
      XrailUp2AsDcMotor.setPower(XrailUp);
      XrailForward = 0.5 * gamepad2.getLeftStickX();
      XrailSideAsDcMotor.setPower(XrailForward);
      rotate = 0.02 + 0.98 * gamepad2.getRightStickX();
      GripperPivotAsServo.setPosition(rotate);
      if (gamepad2.getX()) {
        BrakeServo1AsServo.setPosition(0.5);
        BrakeServoAsServo.setPosition(0.5);
      } else {
        BrakeServo1AsServo.setPosition(0.2);
        BrakeServoAsServo.setPosition(0.8);
      }
      if (gamepad2.getLeftBumper()) {
        GripperAsServo.setPosition(0);
      } else if (false) {
      } else {
        GripperAsServo.setPosition(0.35);
      }
      telemetry.update();
    }
  }
}
