package patterns.Visitor;

import patterns.Visitor.Menu_cafe_UsingVisitor.Ingridient;
import patterns.Visitor.Menu_cafe_UsingVisitor.MenuComponent_UseVisitor;

import java.util.ArrayList;
import java.util.Map;

public class MenuComponentVisitor_calories implements MenuComponentVisitor {

    int innerPrintOffset=0;

    Map<String, Integer> calority = Map.of(
            "Berries", 33,
            "Blueberry_syrup", 55,
            "Bread", 256,
            "Egg", 155,
            "Potato", 76,
            "Sausage", 230,
            "Spagetti", 158,
            "Tomato", 20,
            "Apple", 5,
            "Waffles", 291
    );


    @Override
    public void visit(MenuComponent_UseVisitor menuComponent) {
        innerPrintOffset++;

        int iter=0;
        while (true){
            MenuComponent_UseVisitor elem=null;

            try {elem=menuComponent.getChild(iter);
            }catch (IndexOutOfBoundsException fff){
                break;
            }

            boolean itsMenu=true;
            try {
                MenuComponent_UseVisitor childCheck = elem.getChild(0);
            }catch (UnsupportedOperationException f){
                itsMenu=false;
            }catch (IndexOutOfBoundsException e){}

            if (itsMenu){
                String nameMenuItem= elem.getName();
                print("Меню "+nameMenuItem+" "+elem.getDescription());
                visit(elem);
                iter++;
                continue;
            }

            if (!itsMenu){
                String nameMenuItem= elem.getName();
                int allCalorityVal=0;
                ArrayList<String>calorityList=new ArrayList<>();
                for (Ingridient ingridient : elem.getIngridients()) {
                    String nameIngr=ingridient.getClass().getSimpleName();
                    Integer callority=this.calority.get(nameIngr);
                    callority= callority!=null?callority:-1;
                    calorityList.add(nameIngr+" калорийность "+callority);
                    if (callority!=-1)allCalorityVal+=callority;
                }

                print("\tБлюдо "+nameMenuItem+" калорийность "+allCalorityVal);
                calorityList.forEach(x->  print("\t\t\tВ составе "+x));

                iter++;
            }
        }

    }


    void print(String msg){
        System.out.println("\t".repeat(innerPrintOffset) +msg);
    }
}
