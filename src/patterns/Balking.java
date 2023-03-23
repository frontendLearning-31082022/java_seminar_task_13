package patterns;

public class Balking {
    public static void main(String[] args) {
        Heater heater=new Heater();
    }
}

class Heater{
    private boolean heatTurnedOn=false;

    public Heater(){
        new Thread( new Sensor1(this)).start();
        new Thread( new Sensor2(this)).start();
    }

    void heatDo() throws InterruptedException {
        synchronized (this){
            if (heatTurnedOn)return;
            heatTurnedOn=true;
        }
        pushStartRelay();
    }

    private void pushStartRelay(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Switching relay again");
                try {Thread.sleep(5000);} catch (InterruptedException e) {}
                heatTurnedOn=false;
            }
        }).start();
    }


    private class Sensor1 implements Runnable{
        Heater heater;
        public Sensor1(Heater heater) {this.heater = heater;}
        @Override
        public void run() {
            for (int i = 0; i < 100; i++)try {heater.heatDo();
            Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }
   private class Sensor2 implements Runnable {
        Heater heater;
        public Sensor2(Heater heater) {this.heater = heater;}
        @Override
        public void run() {
            for (int i = 0; i < 100; i++)try {heater.heatDo();
            Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }
}