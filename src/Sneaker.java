public class Sneaker {
    private final String brand;
    private final String model;
    private final String colorway;
    private final double size;
    private double price = 0;
    private double resalePrice = 0;
    private static int sneakerCount = 0;
    private boolean isDeadstock = true;


    public Sneaker(String brand, String model, String colorway, double size, double price, double resalePrice, boolean isDeadstock) {
        this.brand = brand;
        this.model = model;
        this.colorway = colorway;
        size = roundSize(size);
        this.size = size;
        this.price = price;
        this.resalePrice = resalePrice;
        this.isDeadstock = isDeadstock;
        sneakerCount++;
    }

    public void setResalePrice(double resalePrice) {
        if (resalePrice > this.resalePrice) {
            this.resalePrice = resalePrice;
        } else {
            System.out.println("New Resale price is lower than current resale price");
            resalePrice = this.resalePrice;
            this.resalePrice = resalePrice;
        }
    }

    public void wearOnce() {
        this.isDeadstock = false;
        this.resalePrice = this.resalePrice - (this.resalePrice/4);
        System.out.println("Wore the shoe once!");
    }

    private double roundSize(double size) {
        return Math.round(size * 2.0) / 2.0;
    }

    public static int getSneakerCount() {
        return sneakerCount;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getColorway() {
        return this.colorway;
    }

    public double getPrice() {return this.price;}

    public double getResalePrice() {return this.resalePrice;}

    public boolean getIsDeadstock() {return this.isDeadstock;}

    public double getSize() {return this.size;}

    public String toString() {
        String deadstockString = "";
        if (isDeadstock == true) {
            deadstockString = "Yes";
        } else if (isDeadstock == false) {
            deadstockString = "No";
        }
        return brand + " " + model + " " + colorway + " | Size: " + size + " | $" + price + " retail / $" + resalePrice + " resale | Deadstock: " + deadstockString;
    }
}