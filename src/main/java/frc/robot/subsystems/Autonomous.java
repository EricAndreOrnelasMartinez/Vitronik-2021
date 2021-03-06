package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Autonomous extends Subsystem{
    private Timer timer;

    @Override
    protected void initDefaultCommand() {
    }
    public Autonomous(){
        timer = new Timer();
    }
    public void initTime(){
        timer.reset();
        timer.start();
    }

    public void start(){
        if(timer.get() <= 13 && timer.get() > 0){
            Robot.m_HopperInatkeSub.moveToS(0.5, 0.5);
            Robot.m_sShooterSub.shoot(-0.5);
        }else if(timer.get() > 13 && timer.get() < 15){
            Robot.m_ChassisSubsystem.moveForward(1, 0.1);
        }else{
            Robot.m_HopperInatkeSub.moveToS(0, 0);
            Robot.m_sShooterSub.shoot(0);
            Robot.m_ChassisSubsystem.stop();
        }
    }

    public boolean finished(){
        return (timer.get() > 15);
    }
    public void setTime(){
        timer.stop();
        timer.reset();
    }
    
}
