package systemdesign.lld.designpattern.abstractfactory.pizzatypefactory;

import systemdesign.lld.designpattern.abstractfactory.IPizzaProvider;
import systemdesign.lld.designpattern.abstractfactory.IPizzaType;
import systemdesign.lld.designpattern.abstractfactory.enums.PizzaProviderType;
import systemdesign.lld.designpattern.abstractfactory.enums.PizzaType;
import systemdesign.lld.designpattern.abstractfactory.impl.*;

public class PizzaTypeFactory {
    public static IPizzaType getPizzaType(PizzaType pizzaType, IPizzaProvider pizzaProviderType) {
        switch (pizzaType) {
            case CLASSIC -> {
                if (pizzaProviderType instanceof DominosPizzaProvider)
                    return new ClassicDominosPizza();
                else
                    return new ClassicPizzaHutPizza();
            }

            case FARMHOUSE -> {
                if (pizzaProviderType instanceof DominosPizzaProvider)
                    return new FarmHouseDominosPizza();
                else
                    return new FarmHousePizzaHutPizza();
            }

            default -> throw new RuntimeException("This type of pizza is not available");
        }
    }
}
