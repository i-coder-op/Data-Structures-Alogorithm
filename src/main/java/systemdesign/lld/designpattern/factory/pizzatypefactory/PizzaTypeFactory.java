package systemdesign.lld.designpattern.factory.pizzatypefactory;

import systemdesign.lld.designpattern.factory.IPizzaType;
import systemdesign.lld.designpattern.factory.enums.PizzaTypeEnum;
import systemdesign.lld.designpattern.factory.impl.ClassicPizza;
import systemdesign.lld.designpattern.factory.impl.FarmHousePizza;

public class PizzaTypeFactory {
    public static IPizzaType getPizzaType (PizzaTypeEnum pizzaType) {
        switch (pizzaType) {
            case CLASSIC -> {
                return new ClassicPizza();
            }
            case FARMHOUSE -> {
                return new FarmHousePizza();
            }
            default -> throw new RuntimeException("Unsupported pizza type");
        }
    }
}
