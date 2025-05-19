package systemdesign.lld.designpattern.abstractfactory.impl;

import systemdesign.lld.designpattern.abstractfactory.IPizzaType;

public class ClassicPizzaHutPizza implements IPizzaType {
    @Override
    public void pizzaType() {
        System.out.println("Pizza Hut's Classic Pizza");
    }
}
