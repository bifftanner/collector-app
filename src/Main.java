public static void main(String[] args) {

    // Testing when I was originally building my scripts

    //Sneaker sneaker1 = new Sneaker("Jordan", "1", "Chicago", 10, 150, 500, true);
    //Sneaker sneaker2 = new Sneaker("Jordan", "4", "Black Cats", 8.5, 800, 1500, true);
    //Sneaker sneaker3 = new Sneaker("Adidas", "Superstars", "Black & White", 11, 90, 120, true);
    //Sneaker sneaker4 = new Sneaker("Jordan", "2", "Off White", 6.5, 250, 350, true);
    //Collector.vault.add(sneaker1);
    //Collector.vault.add(sneaker2);
    //Collector.vault.add(sneaker3);
    //Collector.vault.add(sneaker4);


    //System.out.println(sneaker1.toString());
    //System.out.println(sneaker2.toString());
    //System.out.println(sneaker3.toString());

    //System.out.println("-------------------");
    //Collector.searchVault("Jordan", "1", "Chicago", 10);

    //System.out.println("-------------------");
    //System.out.println("Total Stock Price: " + Collector.getTotalStockPrice());
    //System.out.println("Total Resale Price: " + Collector.getTotalResalePrice());

    //System.out.println("-------------------");
    //sneaker3.wearOnce();
    //sneaker4.wearOnce();
    //Collector.deadstockOnly();

    //System.out.println("-------------------");
    //Collector.filterByBrand("Jordan");

    System.out.println("---------------------------");

    // Printing 3 Shoes
    Sneaker sneaker3 = new Sneaker("Jordan", "4", "Black Cats", 8.5, 800, 1500, true);
    Sneaker sneaker4 = new Sneaker("Adidas", "Superstars", "Black & White", 11, 90, 120, true);
    Sneaker sneaker5 = new Sneaker("Jordan", "2", "Off White", 6.5, 250, 350, true);
    Collector.addSneaker(sneaker3);
    Collector.addSneaker(sneaker4);
    Collector.addSneaker(sneaker5);
    System.out.println(sneaker3.toString());
    System.out.println(sneaker4.toString());
    System.out.println(sneaker5.toString());

    System.out.println("---------------------------");

    // Aliasing
    Sneaker sneaker1 = new Sneaker("Jordan", "1", "Chicago", 10, 150, 500, true);
    Sneaker sneaker2 = sneaker1;
    sneaker2.wearOnce();
    System.out.println(sneaker1.getIsDeadstock());
    Menu.runLoop();
}