package systemdesign.lld.designpattern.factory.impl;

import systemdesign.lld.designpattern.factory.IPizzaType;

public class ClassicPizza implements IPizzaType {

    @Override
    public void preparePizza() {
        System.out.println("Preparing classic Pizza");
    }
}
