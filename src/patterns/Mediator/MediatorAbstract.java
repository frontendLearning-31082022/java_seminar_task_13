package patterns.Mediator;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class MediatorAbstract {
    HashMap<String,Runnable> modules =new HashMap<>();
    public MediatorAbstract( Runnable... observables){
        for (Runnable module : observables)modules.put(module.toString(),module);
    }
    public void registerObserver(String nameModule, Observer observer){
        if (!(modules.get(nameModule) instanceof Observable))throw new UnsupportedOperationException();
        Observable observable= (Observable) modules.get(nameModule);

        observable.registerObserver(observer);
    }
}
