package systemdesign.lld.designpattern.decorator.decorator.impl;

import systemdesign.lld.designpattern.decorator.ICoffee;
import systemdesign.lld.designpattern.decorator.decorator.CoffeeDecorator;

public class HotCoffee extends CoffeeDecorator {
    public HotCoffee(ICoffee coreCoffee) {
        super(coreCoffee, "Hot Coffee", 20.00);
    }
}
