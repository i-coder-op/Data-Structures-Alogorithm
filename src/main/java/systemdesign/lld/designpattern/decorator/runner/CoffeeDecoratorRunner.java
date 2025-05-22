package systemdesign.lld.designpattern.decorator.runner;

import systemdesign.lld.designpattern.decorator.ICoffee;
import systemdesign.lld.designpattern.decorator.decorator.impl.ColdCoffee;
import systemdesign.lld.designpattern.decorator.decorator.impl.HotCoffee;
import systemdesign.lld.designpattern.decorator.impl.CoreCoffee;

public class CoffeeDecoratorRunner {
    public static void main(String[] args) {
        ICoffee coreCoffee = new CoreCoffee();

        System.out.println(coreCoffee.getCoffeeType() + " : " + coreCoffee.getCoffeePrice());

        //Adding extra layer
        ColdCoffee coldCoffee = new ColdCoffee(coreCoffee);
        HotCoffee hotCoffee = new HotCoffee(coreCoffee);

        System.out.println(coldCoffee.getCoffeeType() + " : " + coldCoffee.getCoffeePrice());
        System.out.println(hotCoffee.getCoffeeType() + " : " + hotCoffee.getCoffeePrice());
    }
}
