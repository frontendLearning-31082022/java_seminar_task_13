package patterns.Visitor.Menu_cafe;

public class TestDrive {
    public static void main(String[] args) {
        MenuComponent allMenus= MenuData.generateAllMenus();

        Waitress waitress=new Waitress(allMenus);
        waitress.printMenu();
    }
}
