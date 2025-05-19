package systemdesign.lld.designpattern.abstractfactory.impl;

import systemdesign.lld.designpattern.abstractfactory.IPizzaProvider;

public class PizzaHutPizzaProvider implements IPizzaProvider {
    @Override
    public void pizzaProvider() {
        System.out.println("PizzaHut Pizza Provider");
    }
}
