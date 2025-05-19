package systemdesign.lld.designpattern.abstractfactory.impl;

import systemdesign.lld.designpattern.abstractfactory.IPizzaProvider;

public class DominosPizzaProvider implements IPizzaProvider {

    @Override
    public void pizzaProvider() {
        System.out.println("Dominos Pizza Provider");
    }
}
