package patterns.Mediator;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IrrigationSystemThread implements Runnable,Observable {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private List<Observer> observers = new ArrayList<>();
    private Date dateWateringAgree=new Date();

    private void makeIrrigation(){
        if (!checkWaterAvailiable())return;
        System.out.println("Water go");
    }

    private boolean checkWaterAvailiable(){
        notifyObservers();
        Date reqWait=new Date();
        while ((new Date().getTime()-reqWait.getTime())/1000/60/60<2){
            synchronized (this){
                try {wait(new Date().getTime()-reqWait.getTime());
                    return true;
                } catch (InterruptedException e) {e.printStackTrace();}
            }
        }
        return false;
    }

    public synchronized void agreeWatering(){
        this.dateWateringAgree=new Date();
        synchronized (this){
            notifyAll();
        }
    }

    @Override
    public void run() {
        atMorningEveryDay();
//        makeIrrigation();
    }

    private void atMorningEveryDay(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,8);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        if (calendar.getTime().before(new Date()))calendar
                .set(Calendar.DAY_OF_MONTH,Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+1);

        executorService.schedule(()->{
            makeIrrigation();
            atMorningEveryDay();
        }, calendar.getTime().getTime()-new Date().getTime(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void registerObserver(Observer o) {observers.add(o);}
    @Override
    public void removeObserver(Observer o) {observers.remove(o);}
    @Override
    public void notifyObservers() {observers.forEach(x->new Thread(()->x.update("checkWaterAvailiable")).start() );}
    @Override
    public String getDescription() {return "Система полива";}
    private String getName(){return getDescription()+" thread";}
    @Override
    public String toString() {return getName();}
}
