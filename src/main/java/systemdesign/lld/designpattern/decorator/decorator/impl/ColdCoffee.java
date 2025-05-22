package systemdesign.lld.designpattern.decorator.decorator.impl;

import systemdesign.lld.designpattern.decorator.ICoffee;
import systemdesign.lld.designpattern.decorator.decorator.CoffeeDecorator;

public class ColdCoffee extends CoffeeDecorator {
    public ColdCoffee(ICoffee coreCoffee) {
        super(coreCoffee, "Cold Coffee", 14.00);
    }
}
