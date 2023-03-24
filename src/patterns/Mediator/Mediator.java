package patterns.Mediator;

import java.util.Arrays;
import java.util.List;

public class Mediator {
    public static void main(String[] args) {
        List<Runnable> modules = Arrays.asList(
                new AlarmThread()
                ,new CoffeMachineThread()
                ,new IrrigationSystemThread());
        modules.forEach(x->new Thread(x).start());

        MediatorOne mediatorOne=new MediatorOne(modules.toArray(new Runnable[0]));
    }
}
