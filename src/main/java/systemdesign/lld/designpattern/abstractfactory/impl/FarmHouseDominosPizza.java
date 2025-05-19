package systemdesign.lld.designpattern.abstractfactory.impl;

import systemdesign.lld.designpattern.abstractfactory.IPizzaType;

public class FarmHouseDominosPizza implements IPizzaType {

    @Override
    public void pizzaType() {
        System.out.println("Dominos's Farmhouse Pizza");
    }
}
