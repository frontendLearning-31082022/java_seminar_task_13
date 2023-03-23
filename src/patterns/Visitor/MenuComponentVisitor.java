package patterns.Visitor;

import patterns.Visitor.Menu_cafe_UsingVisitor.MenuComponent_UseVisitor;

public interface MenuComponentVisitor {
    void visit(MenuComponent_UseVisitor menuComponent);
}
