package systemdesign.lld.designpattern.abstractfactory.runner;

import systemdesign.lld.designpattern.abstractfactory.IPizzaProvider;
import systemdesign.lld.designpattern.abstractfactory.IPizzaType;
import systemdesign.lld.designpattern.abstractfactory.enums.PizzaProviderType;
import systemdesign.lld.designpattern.abstractfactory.enums.PizzaType;
import systemdesign.lld.designpattern.abstractfactory.pizzaproviderfactory.PizzaProviderFactory;
import systemdesign.lld.designpattern.abstractfactory.pizzatypefactory.PizzaTypeFactory;

public class PizzaFactoryTypeRunner {
    public static void main(String[] args) {
        IPizzaProvider pizzaProvider = PizzaProviderFactory.getPizzaProviderType(PizzaProviderType.DOMINOS);
        pizzaProvider.pizzaProvider();

        IPizzaType pizzaTypeClassic = PizzaTypeFactory.getPizzaType(PizzaType.CLASSIC, pizzaProvider);
        pizzaTypeClassic.pizzaType();

        IPizzaType pizzaTypeFarmhouse = PizzaTypeFactory.getPizzaType(PizzaType.FARMHOUSE, pizzaProvider);
        pizzaTypeFarmhouse.pizzaType();


        pizzaProvider = PizzaProviderFactory.getPizzaProviderType(PizzaProviderType.PIZZA_HUT);
        pizzaProvider.pizzaProvider();

        pizzaTypeClassic = PizzaTypeFactory.getPizzaType(PizzaType.CLASSIC, pizzaProvider);
        pizzaTypeClassic.pizzaType();

        pizzaTypeFarmhouse = PizzaTypeFactory.getPizzaType(PizzaType.FARMHOUSE, pizzaProvider);
        pizzaTypeFarmhouse.pizzaType();

    }
}
