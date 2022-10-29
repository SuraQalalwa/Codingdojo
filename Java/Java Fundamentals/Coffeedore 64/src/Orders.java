import java.util.ArrayList;


class Orders {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Orders(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public double getTotalPrice(){
        double sum=0;
        for (int i = 0; i < this.items.size(); i++) {
            sum += this.items.get(i).getPrice();
        }return sum;}
        public void display() {
        System.out.println("Customer Name: " + getName());
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(this.items.get(i).getName() + " - $" + this.items.get(i).getPrice());
        }
        System.out.println("Total: $"+getTotalPrice());
            System.out.println("*****");

        }
    }
