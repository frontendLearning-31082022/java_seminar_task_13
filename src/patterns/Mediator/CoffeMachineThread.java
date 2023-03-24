package patterns.Mediator;

public class CoffeMachineThread implements Runnable{
    private boolean coffeCup=false;
    private void makeCoffe() throws InterruptedException {
        System.out.println("making coffee..");
        Thread.sleep(4000);
        completeCoffe();
    }
    private String getName(){return "CoffeMachine thread";}
    @Override
    public String toString() {return getName();}
    private void completeCoffe(){coffeCup=true; }

    @Override
    public void run() {
         Thread.currentThread().setName(getName());

        while (true){
            synchronized (this){
                try {wait();
                } catch (InterruptedException e) {throw new RuntimeException(e);}
            }

            if (!this.coffeCup) {
                try {makeCoffe();
                } catch (InterruptedException e) {throw new RuntimeException(e);}
            }
        }
    }
}
