package systemdesign.lld.designpattern.factory.impl;

import systemdesign.lld.designpattern.factory.IPizzaType;

public class FarmHousePizza implements IPizzaType {

    @Override
    public void preparePizza() {
        System.out.println("Preparing farmhouse pizza");
    }
}
