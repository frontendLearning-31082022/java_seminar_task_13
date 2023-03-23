package patterns.Visitor.Menu_cafe_UsingVisitor;




public class MenuData {
    public static MenuComponent_UseVisitor generateAllMenus(){
        MenuComponent_UseVisitor allMenus = new Menu("ALL MENUS", "All menus combined");


        MenuComponent_UseVisitor pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent_UseVisitor dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent_UseVisitor cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent_UseVisitor dessertMenu =
                new Menu("DESSERT MENU", "Dessert of course!");
        MenuComponent_UseVisitor coffeeMenu = new Menu("COFFEE MENU", "Stuff to go with your afternoon coffee");

        pancakeHouseMenu.add(new MenuItem(
                "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99,new Egg(),new Bread()));
        pancakeHouseMenu.add(new MenuItem(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99,new Egg(),new Sausage(),new Bread()));
        pancakeHouseMenu.add(new MenuItem(
                "Blueberry Pancakes",
                "Pancakes made with fresh blueberries, and blueberry syrup",
                true,
                3.49,new Bread(),new Berries(),new Blueberry_syrup()));
        pancakeHouseMenu.add(new MenuItem(
                "Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59,new Waffles(),new Berries()));

        dinerMenu.add(new MenuItem(
                "Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99,new Tomato()));
        dinerMenu.add(new MenuItem(
                "BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99,new Tomato()));
        dinerMenu.add(new MenuItem(
                "Soup of the day",
                "A bowl of the soup of the day, with a side of potato salad",
                false,
                3.29,new Potato()));
        dinerMenu.add(new MenuItem(
                "Hot Dog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05,new Toppings(),new Sausage()));

        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59,new Bread(),new Toppings()));

        cafeMenu.add(coffeeMenu);

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        return allMenus;
    }
}
