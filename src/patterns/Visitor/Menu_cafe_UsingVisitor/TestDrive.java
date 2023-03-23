package patterns.Visitor.Menu_cafe_UsingVisitor;

public class TestDrive {
    public static void main(String[] args) {
        MenuComponent_UseVisitor allMenus= MenuData.generateAllMenus();

        Waitress waitress=new Waitress(allMenus);
//        waitress.printMenu();

        waitress.printCalority();
    }
}
