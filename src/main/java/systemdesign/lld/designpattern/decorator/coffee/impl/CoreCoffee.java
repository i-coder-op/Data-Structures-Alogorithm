package systemdesign.lld.designpattern.decorator.coffee.impl;

import systemdesign.lld.designpattern.decorator.coffee.ICoffee;

public class CoreCoffee implements ICoffee {
    public String coffeeType = "CoreCoffee";
    public Double coffeePrice = 40.0;

    @Override
    public String getCoffeeType() {
        return this.coffeeType;
    }

    @Override
    public Double getCoffeePrice() {
        return this.coffeePrice;
    }
}
