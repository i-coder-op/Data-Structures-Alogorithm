package systemdesign.lld.designpattern.decorator.coffee.decorator.impl;

import systemdesign.lld.designpattern.decorator.coffee.ICoffee;
import systemdesign.lld.designpattern.decorator.coffee.decorator.CoffeeDecorator;

public class ColdCoffee extends CoffeeDecorator {
    public ColdCoffee(ICoffee coreCoffee) {
        super(coreCoffee, "Cold Coffee", 14.00);
    }
}
