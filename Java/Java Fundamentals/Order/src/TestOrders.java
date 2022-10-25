import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Item item1= new Item();
        item1.name = "coffee";
        item1.price = 20;

        Item item2= new Item();
        item2.name = "capuccino";
        item2.price = 10;

        Item item3= new Item();
        item3.name = "latte";
        item3.price = 15;

        Item item4= new Item();
        item4.name = "mocha";
        item4.price = 30;

        // Order variables -- item1, item1 etc.

        Orders order1 = new Orders();
        order1.name = "Noah";
        order1.ready = true;
        order1.total = item2.price;
        order1.items.add(item2);


        Orders order2 = new Orders();
        order2.name = "Sam";
        order2.total = item3.price+item1.price;
        order2.ready= false;
        order2.items.add(item3);
        order2.items.add(item1);


        Orders order3 = new Orders();
        order3.name = "Amin";
        order3.total = item1.price;
        order3.ready= false;
        order3.items.add(item1);

        Orders order4 = new Orders();
        order4.name = "Jimmy";
        order4.total = item4.price;
        order4.ready= false;
        order4.items.add(item4);


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Your Order is: %s\n",order1.items.get(0).name);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Your Order is: %s\n",order2.items.get(0).name,order2.items.get(1).name);
        System.out.printf("Your Order is: %s\n",order2.items.get(1).name);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Your Order is: %s\n",order3.items.get(0).name);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Your Order is: %s\n",order4.items.get(0).name);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
