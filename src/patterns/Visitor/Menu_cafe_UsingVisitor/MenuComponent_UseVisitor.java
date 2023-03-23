package patterns.Visitor.Menu_cafe_UsingVisitor;

import patterns.Visitor.MenuComponentVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MenuComponent_UseVisitor {
    public void  accept(MenuComponentVisitor visitor){
        visitor.visit(this);
    }
    public ArrayList<Ingridient> getIngridients(){
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent_UseVisitor menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent_UseVisitor menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent_UseVisitor getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
}
class Menu extends MenuComponent_UseVisitor {
    ArrayList<MenuComponent_UseVisitor> menuComponents = new ArrayList<MenuComponent_UseVisitor>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent_UseVisitor menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent_UseVisitor menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent_UseVisitor getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator<MenuComponent_UseVisitor> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent_UseVisitor menuComponent = (MenuComponent_UseVisitor) iterator.next();
            menuComponent.print();
        }
    }
}

class MenuItem extends MenuComponent_UseVisitor {
    String name;
    String description;
    boolean vegetarian;
    double price;
    ArrayList<Ingridient>ingridients;

    public ArrayList<Ingridient> getIngridients(){
        return ingridients;
    }

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price,Ingridient...ingridients)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
        this.ingridients=new ArrayList<>(Arrays.asList(ingridients));
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }

    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {System.out.print("(v)");}
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription()); }
}
