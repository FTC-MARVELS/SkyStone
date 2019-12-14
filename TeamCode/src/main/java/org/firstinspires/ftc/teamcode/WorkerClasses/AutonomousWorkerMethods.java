/* AutonomousWorkerMethods class is a collection of methods called by 
 *  the autonomous OpModes.
 */

package org.firstinspires.ftc.teamcode.WorkerClasses;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class AutonomousWorkerMethods extends LinearOpMode {
    
    /*
     * Portions of this code have been copied from the now obsolite OpMode  
     * 'Autonomous_Blue', which was originally written by Hamza (in Blocks).
     */

    private Servo PullServoAsServo;
    private Servo PullServo2AsServo;
    private DcMotor FrontDriveMotorAsDcMotor;
    private DcMotor RightDriveMotorAsDcMotor;
    private DcMotor LeftDriveMotorAsDcMotor;
    private DcMotor BackDriveMotorAsDcMotor;

    public void deliverSS() {
        // From the quary, identify a Skystone from ordinary orange stones, and  
        //  deliver it to the building zone.  Repeat for a second Skystone.
        
    }

    public void dragBlue() {
        // Drag blue foundation to blue building site.

        // spin cw for 1.75 sec, then stop
        RightDriveMotorAsDcMotor.setPower(0.5);
        FrontDriveMotorAsDcMotor.setPower(0.5);
        sleep(1750);
        RightDriveMotorAsDcMotor.setPower(0);
        FrontDriveMotorAsDcMotor.setPower(0);
        sleep(100);
        
        // do something with claws ???
        PullServoAsServo.setPosition(0.55);
        PullServo2AsServo.setPosition(0.4);
        sleep(1000);
        
        // spin ccw for 2.8 sec, then stop
        RightDriveMotorAsDcMotor.setPower(-0.5);
        FrontDriveMotorAsDcMotor.setPower(-0.5);
        sleep(2800);
        RightDriveMotorAsDcMotor.setPower(0);
        FrontDriveMotorAsDcMotor.setPower(0);
        sleep(100);
        
        // restore claws ???
        PullServoAsServo.setPosition(0.2);
        PullServo2AsServo.setPosition(0.9);
        sleep(1000);
        
        // 
        LeftDriveMotorAsDcMotor.setPower(-0.5);
        BackDriveMotorAsDcMotor.setPower(-0.5);
        sleep(2200);
        LeftDriveMotorAsDcMotor.setPower(0);
        BackDriveMotorAsDcMotor.setPower(0);
        sleep(200);
        
        // 
        RightDriveMotorAsDcMotor.setPower(0.5);
        FrontDriveMotorAsDcMotor.setPower(0.5);
        sleep(750);
        RightDriveMotorAsDcMotor.setPower(0);
        FrontDriveMotorAsDcMotor.setPower(0);
        sleep(200);
        
        // drive medium forward for 2.25 sec, then stop
        LeftDriveMotorAsDcMotor.setPower(0.5);
        BackDriveMotorAsDcMotor.setPower(0.5);
        sleep(2250);
        LeftDriveMotorAsDcMotor.setPower(0);
        BackDriveMotorAsDcMotor.setPower(0);
        
        // grab foundation with claws
        PullServoAsServo.setPosition(0.9);
        PullServo2AsServo.setPosition(0.1);
        sleep(1500);
        
        // drive slow reverse for 4.5 sec, then stop
        LeftDriveMotorAsDcMotor.setPower(-0.35);
        BackDriveMotorAsDcMotor.setPower(-0.35);
        sleep(4500);
        LeftDriveMotorAsDcMotor.setPower(0);
        BackDriveMotorAsDcMotor.setPower(0);
    }

    public void dragRed() {
        // Drag red foundation to red building site.
        
    }

    public void parkAgainstWall() {
        // Park under skybridge, against wall.
        
    }
    
    public void parkAwayFromWall() {
        // Park under skybridge, away from wall (next to Skybridge-neutral).
        
    }
}
