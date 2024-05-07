public class Vehicle {
    private  int id;
    private  String manufacture;
    private String model;
    private  int year;
    private  double pricePerDay;
    private boolean rented;

    public Vehicle(int id, String manufacture, String model, int year, double pricePerDay) {
        this.id = id;
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.rented = false;
    }

    public int getId() {
        return id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public double calculateRentalCost(int days) {
        double rentalCost;
        rentalCost = days * getPricePerDay();
        return rentalCost;
    }

     public double calculateSalePrice() {
        double salePrice;
        salePrice = getPricePerDay() * 365 * 2;
        return salePrice;
    }
}