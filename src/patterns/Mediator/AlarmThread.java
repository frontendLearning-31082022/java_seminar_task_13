package patterns.Mediator;

import java.util.ArrayList;
import java.util.List;

public class AlarmThread implements Observable, Runnable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void run() {
        Thread.currentThread().setName(getName());
        while (true){
            try {Thread.sleep(5000);
            } catch (InterruptedException e) {throw new RuntimeException(e);}

            notifyObservers();
        }
    }

    private String getName(){
        return "Alarm thread";
    }
    @Override
    public String toString() {return getName();}
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {observers.forEach(x->x.update(null));}
    @Override
    public String getDescription() {
        return "Будильник";
    }
}