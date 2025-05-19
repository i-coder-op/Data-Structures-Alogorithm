package systemdesign.lld.designpattern.abstractfactory.pizzaproviderfactory;

import systemdesign.lld.designpattern.abstractfactory.IPizzaProvider;
import systemdesign.lld.designpattern.abstractfactory.enums.PizzaProviderType;
import systemdesign.lld.designpattern.abstractfactory.impl.DominosPizzaProvider;
import systemdesign.lld.designpattern.abstractfactory.impl.PizzaHutPizzaProvider;

public class PizzaProviderFactory {
    public static IPizzaProvider getPizzaProviderType (PizzaProviderType pizzaProviderType) {
        switch (pizzaProviderType) {
            case DOMINOS -> {
                return new DominosPizzaProvider();
            }

            case PIZZA_HUT -> {
                return new PizzaHutPizzaProvider();
            }

            default -> throw new RuntimeException("This pizza provider is not in market!!");
        }
    }
}
