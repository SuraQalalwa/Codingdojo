public class TestOrders {
    public static void main(String[] args) {
        CoffeeKiosk order=new CoffeeKiosk();
        order.addMenuItem("banana",2.0,0);
        order.addMenuItem("coffee",1.5,1);
        order.addMenuItem("latte",4.5,2);
        order.addMenuItem("capuccino",3.0,3);
        order.addMenuItem("muffin",4.0,4);

//        order.displayMenu();
        order.newOrder();
    }

}
