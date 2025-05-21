package systemdesign.lld.designpattern.decorator.coffee.decorator.impl;

import systemdesign.lld.designpattern.decorator.coffee.ICoffee;
import systemdesign.lld.designpattern.decorator.coffee.decorator.CoffeeDecorator;

public class HotCoffee extends CoffeeDecorator {
    public HotCoffee(ICoffee coreCoffee) {
        super(coreCoffee, "Hot Coffee", 20.00);
    }
}
