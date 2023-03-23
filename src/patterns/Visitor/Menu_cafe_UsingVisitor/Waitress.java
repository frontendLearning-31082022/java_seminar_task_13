package patterns.Visitor.Menu_cafe_UsingVisitor;


import patterns.Visitor.MenuComponentVisitor_calories;
import patterns.Visitor.MenuComponentVisitor_healthRating;

public class Waitress {
    MenuComponent_UseVisitor allMenus;
    public Waitress(MenuComponent_UseVisitor allMenus) {
        this.allMenus = allMenus;
    }
    public void printMenu() {
        allMenus.print();
    }

    public void printCalority() {
        allMenus.accept(new MenuComponentVisitor_calories());
    }

    public void printHealthRating() {
        allMenus.accept(new MenuComponentVisitor_healthRating());
    }

}
