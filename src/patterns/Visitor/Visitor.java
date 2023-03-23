package patterns.Visitor;

import patterns.Visitor.Menu_cafe_UsingVisitor.MenuComponent_UseVisitor;
import patterns.Visitor.Menu_cafe_UsingVisitor.MenuData;
import patterns.Visitor.Menu_cafe_UsingVisitor.Waitress;

public class Visitor {

    public static void main(String[] args) {
        MenuComponent_UseVisitor allMenus = MenuData.generateAllMenus();

        Waitress waitress = new Waitress(allMenus);
        waitress.printCalority();
        waitress.printHealthRating();
    }

}
