public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Item item1= new Item();
        item1.setName("coffee");
        item1.setPrice(20);

        Item item2= new Item();
        item2.setName("capuccino");
        item2.setPrice(10);

        Item item3= new Item();
        item3.setName("latte");
        item3.setPrice(15);

        Item item4= new Item();
        item4.setName("mocha");
        item4.setPrice(30);

        // Order variables -- item1, item1 etc.

        Orders order1 = new Orders();
        order1.setName("Noah");
        order1.setReady(true);
        order1.setTotal(item2.getPrice());
        order1.getItems().add(item2);


        Orders order2 = new Orders();
        order2.setName("Sam");
        order2.setTotal(item3.getPrice() + item1.getPrice());
        order2.setReady(false);
        order2.getItems().add(item3);
        order2.getItems().add(item1);


        Orders order3 = new Orders();
        order3.setName("Amin");
        order3.setTotal(item1.getPrice());
        order3.setReady(false);
        order3.getItems().add(item1);

        Orders order4 = new Orders();
        order4.setName("Jimmy");
        order4.setTotal(item4.getPrice());
        order4.setReady(false);
        order4.getItems().add(item4);


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %s\n", order1.getTotal());
        System.out.printf("Your Order is: %s\n", order1.getItems().get(0).getName());
        System.out.printf("Ready: %s\n", order1.isReady());

        System.out.printf("Name: %s\n", order2.getName());
        System.out.printf("Total: %s\n", order2.getTotal());
        System.out.printf("Your Order is: %s\n", order2.getItems().get(0).getName(), order2.getItems().get(1).getName());
        System.out.printf("Your Order is: %s\n", order2.getItems().get(1).getName());
        System.out.printf("Ready: %s\n", order2.isReady());

        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getTotal());
        System.out.printf("Your Order is: %s\n", order3.getItems().get(0).getName());
        System.out.printf("Ready: %s\n", order3.isReady());

        System.out.printf("Name: %s\n", order4.getName());
        System.out.printf("Total: %s\n", order4.getTotal());
        System.out.printf("Your Order is: %s\n", order4.getItems().get(0).getName());
        System.out.printf("Ready: %s\n", order4.isReady());
    }
}
