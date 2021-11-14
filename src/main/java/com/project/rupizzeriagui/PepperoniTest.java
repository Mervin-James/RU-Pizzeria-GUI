package com.project.rupizzeriagui;

import org.junit.Test;

import static org.junit.Assert.*;

public class PepperoniTest {

    @Test
    public void price() {
        //NOTE: The following test cases represent having 2 toppings
        // (adding 1 topping) to a small pepperoni pizza.

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
        // price stay at $8.99.
        p = PizzaMaker.createPizza("Pepperoni");
        assertEquals(p.price(), 8.99, 0d);

        //test case #12: adding 2 toppings to a pepperoni pizza increases
        // the price by $2.98 to $11.97
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Sausage);
        p.addTopping(Topping.GreenPepper);
        assertEquals(p.price(), 11.97, 0d);

        //test case #13: removing default topping (pepperoni) from a
        // pepperoni pizza is invalid (does not decrease the price below
        // $8.99).
        //NOTE: This case is handled by our GUI, since pizzas are
        // initialized with default toppings that cannot be removed.
        // Therefore, the minimum price of a pepperoni pizza is always $8.99.

        //test case #14: adding 6 toppings to a pepperoni pizza
        // (total 7 toppings) increases the price by $8.94 to $17.93
        p = PizzaMaker.createPizza("Pepperoni");
        p.addTopping(Topping.Sausage);
        p.addTopping(Topping.GreenPepper);
        p.addTopping(Topping.Chicken);
        p.addTopping(Topping.Beef);
        p.addTopping(Topping.Ham);
        p.addTopping(Topping.Onion);
        p.addTopping(Topping.Mushroom);
        assertEquals(p.price(), 17.93, 0d);

        //test case #15: adding 7 toppings to a pepperoni pizza (total 8
        // toppings) is invalid.
        //NOTE: this case is handled by our GUI, since the maximum toppings
        // allowed to be on a pizza is 7.

        //NOTE: The following test cases represent variations in sizes of
        // pepperoni pizzas.
        //test case #16: a small pepperoni pizza is priced at $8.99
        p = PizzaMaker.createPizza("Pepperoni");
        p.setSize(Size.small);
        assertEquals(p.price(), 8.99, 0d);

        //test case #17: a medium pepperoni pizza increases the price by $2
        // to $10.99
        p = PizzaMaker.createPizza("Pepperoni");
        p.setSize(Size.medium);
        assertEquals(p.price(), 10.99, 0d);

        //test case #18: a large pepperoni pizza increases the price by $4
        // to $12.99
        p = PizzaMaker.createPizza("Pepperoni");
        p.setSize(Size.large);
        assertEquals(p.price(), 12.99, 0d);

        //test case #19: adding an additional topping to a medium pepperoni
        // pizza increases the price by $1.49 for a topping and $2 for
        // the size increase for a total of $12.47
        p = PizzaMaker.createPizza("Pepperoni");
        p.setSize(Size.medium);
        p.addTopping(Topping.Onion);
        assertEquals(p.price(), 12.48, 0d);

        //test case #19: adding an additional topping to a large pepperoni
        // pizza increases the price by $1.49 for a topping and $4 for
        // the size increase for a total of $14.47
        p = PizzaMaker.createPizza("Pepperoni");
        p.setSize(Size.large);
        p.addTopping(Topping.Onion);
        assertEquals(p.price(), 14.48, 0d);
    }
}