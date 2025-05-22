package systemdesign.lld.designpattern.decorator.decorator;

import systemdesign.lld.designpattern.decorator.ICoffee;

public abstract class CoffeeDecorator implements ICoffee {

    public ICoffee coreCoffee;
    public String coffeeType;
    public Double coffeePrice;

    public CoffeeDecorator(ICoffee coreCoffee, String coffeeType, Double coffeePrice) {
        this.coffeePrice = coffeePrice;
        this.coffeeType = coffeeType;
        this.coreCoffee = coreCoffee;
    }

    @Override
    public String getCoffeeType() {
        return this.coreCoffee.getCoffeeType() + ": " + this.coffeeType;
    }

    @Override
    public Double getCoffeePrice() {
        return this.coreCoffee.getCoffeePrice() + this.coffeePrice;
    }
}
