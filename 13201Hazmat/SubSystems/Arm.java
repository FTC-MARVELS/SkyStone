package org.firstinspires.ftc.teamcode.SubSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Definition of Robot Arm.
 * Arm has :
 *      1 motor to lift Intake to set levels
 *      Levels are :
 *          6 blockLevels for brick placement
 *          groundLevel as the arm is resting on ground
 *          detectSkystoneLevel as the arm is slightly lifted to have Skystone light sensor at
 *              height, used in autonomous mode
 *          aboveFoundationLevel as the arm is just above the foundation, used in autonomous
 *          onFoundationLevel as the arm is holding the foundation
 *
 * @ArmMethods : moveArm_groundLevel()
 * @ArmMethods : moveArm_blockLevelUp()
 * @ArmMethods : moveArm_blockLevelDown()
 * @ArmMethods : moveArmToPlaceBlockAtLevel()
 * @ArmMethods : moveArmToLiftAfterBlockPlacement()
 * @ArmMethods : runArmToLevel()
 * @ArmAutoMethods : moveArm_detectSkystoneLevel()
 * @ArmAutoMethods : moveArm_aboveFoundationLevel(()
 * @ArmAutoMethods : moveArm_onFoundationLevel()
 *
 */

/**
 * Class Definition
 */
public class Arm {
    //Declare Arm Motor
    public DcMotor armMotor;

    //Declare Arm levels in arm motor encoder values set just above the block level
    int[] blockLevel = {
             0, //ground level
            -50, //block level 1
            -95, //block level 2
            -146, //block level 3
            -199, //block level 4
            -255, //block level 5
            -321 //block level 6
    };
    int groundLevel = 0;
    int detectSkystoneLevel = -20; //#TOBEFILLED correctly
    int aboveFoundationLevel = -50; //#TOBEFILLED correctly
    int onFoundationLevel = -10; //#TOBEFILLED correctly

    int currentLevel = 0;
    int MAX_BLOCK_LEVEL = 6;
    int DROP_BLOCK_HEIGHT = 10;
    int MAX_ARM_HEIGHT = -350;

    //Timer for timing out Arm motion incase targetPosition cannot be achieved
    ElapsedTime ArmMotionTimeOut = new ElapsedTime();

    //Constructor
    public Arm(HardwareMap hardwareMap) {
        armMotor = hardwareMap.dcMotor.get("arm");
        initArm();
    }

    /**
     * Initialize Arm - Reset, Set Zero Behavior to FLOAT (instead of BRAKE),
     * and mode to RUN_TO_POSITION (PID based rotation to
     * achieve the desire ed encoder count
     */
    public void initArm() {
        resetArm();
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    /**
     * Method to set Arm brake mode to ON when Zero (0.0) power is applied.
     * To be used when arm is above groundlevel
     * setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
     */
    public void turnArmBrakeModeOn(){
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

     /**
     * Method to set Arm brake mode to OFF when Zero (0.0) power is applied.
     * To be used when arm is on groundlevel or blockLevel[0]
     * setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
     */
    public void turnArmBrakeModeOff(){
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    /**
     * Reset function for motor encoders to be set to reset state of encoder.
     * Usage of this is typically followed by using setZeroBehaviour and then setting
     * the mode for the motor
     */
    public void resetArm() {

        DcMotor.RunMode runMode = armMotor.getMode();
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(runMode);
    }

    /**
     * Method to move Arm to groundlevel and turn Brake Mode OFF
     */
    public void moveArm_groundLevel(){
        armMotor.setTargetPosition(groundLevel);
        turnArmBrakeModeOff();
        runArmToLevel();
    }

    /**
     * Method to move Arm to detectSkystoneLevel and turn Brake Mode ON
     */
    public void moveArm_detectSkystoneLevel(){
        armMotor.setTargetPosition(detectSkystoneLevel);
        turnArmBrakeModeOn();
        runArmToLevel();
    }

    /**
     * Method to move Arm to aboveFoundationLevel and turn Brake Mode ON
     */
    public void moveArm_aboveFoundationLevel(){
        armMotor.setTargetPosition(aboveFoundationLevel);
        turnArmBrakeModeOn();
        runArmToLevel();
    }

    /**
     * Method to move Arm to onFoundationLevel and turn Brake Mode ON
     */
    public void moveArm_onFoundationLevel(){
        armMotor.setTargetPosition(onFoundationLevel);
        turnArmBrakeModeOn();
        runArmToLevel();
    }

    /**
     * Method to move arm up by a block level from current level in TeleOp and turn Brake Mode ON
     */
    public void moveArm_blockLevelUp(){
        turnArmBrakeModeOn();
        if (currentLevel < MAX_BLOCK_LEVEL) {
            armMotor.setTargetPosition(blockLevel[currentLevel+1]);
            currentLevel++;
            runArmToLevel();
        } else {
            armMotor.setPower(0.0);
        }
    }

    /**
     * Method to move arm down by a block level from current level in TeleOp
     * For blockLevel[1 to MAX_BLOCK_LEVEL], turn Brake Mode On
     * For blockLevel[0], set to groundlevel and turn Brake Mode Off
     */
    public void moveArm_blockLevelDown(){
        if (currentLevel > 1) {
            turnArmBrakeModeOn();
            armMotor.setTargetPosition(blockLevel[currentLevel-1]);
            currentLevel--;
            runArmToLevel();
        } else {
            turnArmBrakeModeOff();
            moveArm_groundLevel();
            currentLevel = 0;
            armMotor.setPower(0.0);
        }

    }

    /**
     * Method to move arm down a bit (DROP_BLOCK_HEIGHT) to place block on a level
     */
    public void moveArmToPlaceBlockAtLevel(){
        if (currentLevel >=1){
            turnArmBrakeModeOn();
            armMotor.setTargetPosition(blockLevel[currentLevel] - DROP_BLOCK_HEIGHT);
            runArmToLevel();
        }
    }

    /**
     * Method to move arm up to currentLevel to release block on a level
     */
    public void moveArmToLiftAfterBlockPlacement(){
        if (currentLevel >=1) {
            turnArmBrakeModeOn();
            armMotor.setTargetPosition(blockLevel[currentLevel]);
            runArmToLevel();
        }
    }

    /**
     * Method to run motor to set to the set position
     */

    public void runArmToLevel() {
        //armMotor.setTargetPosition(blockLevel[level]);;
        ArmMotionTimeOut.reset();
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Turn Motors on
        armMotor.setPower(1.0);
        //Move motor till target Position is achieved, or timeout in 3000 milliseconds
        while (!armMotor.isBusy() && (ArmMotionTimeOut.milliseconds()<3000)) {
            //Wait
        }
        //Turn Motor to BRAKE
        armMotor.setPower(0.0);
    }

}
