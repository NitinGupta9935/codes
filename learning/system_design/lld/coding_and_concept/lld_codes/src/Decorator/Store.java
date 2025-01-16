package Decorator;

import Decorator.BasePizza.BasePizza;
import Decorator.BasePizza.Margherita;

public class Store {

    public static void main(String args[]) {

        BasePizza pizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(pizza.cost());

    }
}
