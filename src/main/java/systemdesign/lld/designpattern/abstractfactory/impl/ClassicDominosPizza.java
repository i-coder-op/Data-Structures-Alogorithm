package systemdesign.lld.designpattern.abstractfactory.impl;

import systemdesign.lld.designpattern.abstractfactory.IPizzaType;

public class ClassicDominosPizza implements IPizzaType {
    @Override
    public void pizzaType() {
        System.out.println("Dominos's Classic Pizza");
    }
}
