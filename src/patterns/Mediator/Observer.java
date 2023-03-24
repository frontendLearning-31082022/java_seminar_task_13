package patterns.Mediator;

public interface Observer {
    void update(Object object);
}
interface Observable{

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();

    String getDescription();
}