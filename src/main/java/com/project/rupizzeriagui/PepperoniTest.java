package com.project.rupizzeriagui;

import org.junit.Test;

import static org.junit.Assert.*;

public class PepperoniTest {

    @Test
    public void price() {
        //NOTE: The following test cases test adding only 1 topping to a
        // pepperoni pizza.

        //test case #1: adding sausage to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        Pizza p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Sausage);
        assertEquals(p.price(), 10.48, 0d);

        //test case #2: adding chicken to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Chicken);
        assertEquals(p.price(), 10.48, 0d);

        //test case #3: adding beef to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Beef);
        assertEquals(p.price(), 10.48, 0d);

        //test case #4: adding ham to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Ham);
        assertEquals(p.price(), 10.48, 0d);

        //test case #5: adding green pepper to a pepperoni pizza increases
        // the price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.GreenPepper);
        assertEquals(p.price(), 10.48, 0d);

        //test case #6: adding onion to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Onion);
        assertEquals(p.price(), 10.48, 0d);

        //test case #7: adding mushroom to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Mushroom);
        assertEquals(p.price(), 10.48, 0d);

        //test case #8: adding Pineapple to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Pineapple);
        assertEquals(p.price(), 10.48, 0d);

        //test case #9: adding black olives to a pepperoni pizza increases the
        // price by $1.49 to $10.48.
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.BlackOlives);
        assertEquals(p.price(), 10.48, 0d);

        //test case #10: adding pepperoni to a pepperoni pizza is invalid.
        //NOTE: This case is handled by our GUI, since pepperoni is
        // included by default and cannot be removed or added.

        //test case #11: adding 0 toppings to a pepperoni pizza makes the
        // price $11.97.
        p = PizzaMaker.createPizza("Pepperoni");
        assertEquals(p.price(), 11.97, 0d);

        //test case #11: adding 2 toppings to a pepperoni pizza increases
        // the price by $2.98 to $11.97
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Sausage);
        p.addTopping(Topping.GreenPepper);
        assertEquals(p.price(), 11.97, 0d);
    }
}