package patterns.Visitor.Menu_cafe_UsingVisitor;

public interface Ingridient {
    String getName();
}

class Bread implements Ingridient{

    @Override
    public String getName() {
        return "Bread";
    }
}

class Egg implements Ingridient{

    @Override
    public String getName() {
        return "Egg";
    }
}

class Sausage implements Ingridient{

    @Override
    public String getName() {
        return "Sausage";
    }
}

class Berries implements Ingridient{

    @Override
    public String getName() {
        return "Blueberries";
    }
}

class Blueberry_syrup implements Ingridient{

    @Override
    public String getName() {
        return "Blueberry_syrup";
    }
}

class Waffles implements Ingridient{

    @Override
    public String getName() {
        return "Waffles";
    }
}

class Tomato implements Ingridient{

    @Override
    public String getName() {
        return "Tomato";
    }
}
class Potato implements Ingridient{

    @Override
    public String getName() {
        return "";
    }
}
class Toppings implements Ingridient{

    @Override
    public String getName() {
        return "Toppings";
    }
}
class Spagetti implements Ingridient{

    @Override
    public String getName() {
        return "Spagetti";
    }
}
