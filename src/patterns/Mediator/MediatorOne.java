package patterns.Mediator;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class MediatorOne extends MediatorAbstract{
    public MediatorOne( Runnable... observables) {
        super(observables);

        registerObserver("Alarm thread",(object)->alarmDingDong());
        registerObserver("Система полива thread",(object)->irrigationCheckWater(object));
    }

    void alarmDingDong(){
        System.out.println("ДингДонг");
        Runnable coffeMachineRunnable=this.modules.get("CoffeMachine thread");
        synchronized (coffeMachineRunnable){coffeMachineRunnable.notify();}
    }

    void irrigationCheckWater(Object object){
        if (!object.toString().equals("checkWaterAvailiable"))return;

        IrrigationSystemThread irrigationSystemThread= (IrrigationSystemThread) modules.get("Система полива thread");
        if (!logicIrrigation())return;

        irrigationSystemThread.agreeWatering();
    }

    boolean logicIrrigation(){
//        check another modules, use some setted logic by user
        int des= JOptionPane.showConfirmDialog(null,"Произвести поливку вода доступна?");
        return des==0;
    }
}
