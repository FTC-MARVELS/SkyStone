package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "CheckRedSample (Blocks to Java)", group = "")
public class CheckRedSample extends LinearOpMode {

  private ColorSensor sensorColorRange;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    int colorHSV;
    float hue;
    float sat;
    float val;

    sensorColorRange = hardwareMap.colorSensor.get("sensorColorRange");

    // This op mode demonstrates the color and distance features of the REV sensor.
    telemetry.addData("CheckRed Op Mode", "Press start to continue...");
    telemetry.update();
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Display distance info.
        telemetry.addData("Dist to tgt (cm)", ((DistanceSensor) sensorColorRange).getDistance(DistanceUnit.CM));
        // Display reflected light.
        telemetry.addData("Light detected", ((OpticalDistanceSensor) sensorColorRange).getLightDetected());
        // Convert RGB values to HSV color model.
        // See https://en.wikipedia.org/wiki/HSL_and_HSV for details on HSV color model.
        colorHSV = Color.argb(sensorColorRange.alpha(), sensorColorRange.red(), sensorColorRange.green(), sensorColorRange.blue());
        // Get hue.
        hue = JavaUtil.colorToHue(colorHSV);
        telemetry.addData("Hue", hue);
        // Get saturation.
        sat = JavaUtil.colorToSaturation(colorHSV);
        telemetry.addData("Saturation", sat);
        // Get value.
        val = JavaUtil.colorToValue(colorHSV);
        telemetry.addData("Value", val);
        // Use hue to determine if it's red, green, blue, etc..
        if (hue < 30) {
          telemetry.addData("Color", "Red");
        } else if (hue < 60) {
          telemetry.addData("Color", "Orange");
        } else if (hue < 90) {
          telemetry.addData("Color", "Yellow");
        } else if (hue < 150) {
          telemetry.addData("Color", "Green");
        } else if (hue < 225) {
          telemetry.addData("Color", "Blue");
        } else if (hue < 350) {
          telemetry.addData("Color", "purple");
        } else {
          telemetry.addData("Color", "Red");
        }
        // Check to see if it might be black or white.
        if (sat < 0.2) {
          telemetry.addData("Check Sat", "Is surface white?");
        }
        telemetry.update();
        if (val < 0.16) {
          telemetry.addData("Check Val", "Is surface black?");
        }
      }
    }
  }
}
