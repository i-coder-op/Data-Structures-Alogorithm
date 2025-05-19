package systemdesign.lld.designpattern.factory.runner;

import systemdesign.lld.designpattern.factory.IPizzaType;
import systemdesign.lld.designpattern.factory.enums.PizzaTypeEnum;
import systemdesign.lld.designpattern.factory.pizzatypefactory.PizzaTypeFactory;

public class PizzaTypeFactoryRunner {
    public static void main(String[] args) {
        IPizzaType classicPizza = PizzaTypeFactory.getPizzaType(PizzaTypeEnum.CLASSIC);
        classicPizza.preparePizza();

        IPizzaType farmhousePizza = PizzaTypeFactory.getPizzaType(PizzaTypeEnum.FARMHOUSE);
        farmhousePizza.preparePizza();
    }
}
