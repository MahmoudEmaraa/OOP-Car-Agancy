import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int countCustomer = 1;
        int countEmployee = 2;
        int countCar = 8;
        boolean choice = true;
        int choice2;


        Vehicle[] vehicles = new Vehicle[1000];
        vehicles[0] = new Car(1, "Toyota", "Corolla", 2019, 1200);
        vehicles[1] = new Car(2, "Hyundai", "Accent", 2020, 900);
        vehicles[2] = new Car(3, "Fiat", "Tipo", 2021, 1300);
        vehicles[3] = new Car(4, "Opel", "Astra", 2018, 1300);
        vehicles[4] = new Car(5, "Opel", "Insignia", 2018, 800);
        vehicles[5] = new Car(6, "Chevrolet", "Optra", 2022, 1100);
        vehicles[6] = new Car(7, "Chevrolet", "Aveo", 2015, 600);
        vehicles[7] = new Car(8, "Kia", "Sportage", 2023, 2000);
        vehicles[8]= new Car(9 , "Hyundai", "Elantra",2015 , 600);


        Customer[] customers = new Customer[1000];
        customers[0] = new Customer(1, "Mahmoud emara", "emara@gmail.com", "01090760620");
        customers[1] = new Customer(2, "George Ashraf", "george@yahoo.com", "012019191718");


        Employee[] employees = new Employee[1000];
        employees[0] = new Employee(1, "Mohamed Elshorfa", 5000, "Salesman");
        employees[1] = new Employee(2, "Momen Radwan", 8000, "Manager");
        employees[2] = new Employee(3, "Ali Ahmed", 5000, "Salesman");


        try {
            while (choice) {

                System.out.println("                                               ");
                System.out.println("**** Welcome to our car agency system ****" + '\n');
                System.out.println("What would you like to do ?");
                System.out.println("1.Rent a car");
                System.out.println("2.Buy a car");
                System.out.println("3.Show all cars");
                System.out.println("4.Show all employees");
                System.out.println("5.Show all customers");
                System.out.println("6.Add cars");
                System.out.println("7.Add new customer");
                System.out.println("8.Add new employee");
                System.err.println("9.Exit");

                choice2 = input.nextInt();


                switch (choice2) {
                    case 1:
                        System.out.println("*** Renting a car... ***" + '\n');
                        Vehicle vehicleToRent = selectVehicle(vehicles, countCar);
                        int daysRented = selectDaysRented();
                        double rentalCost = 0;
                        if (vehicleToRent != null) {
                            rentalCost = vehicleToRent.calculateRentalCost(daysRented);
                        }
                        System.out.println("Rental cost: EGP " + rentalCost);
                        if (vehicleToRent != null) {
                            vehicleToRent.setRented(true);
                        }
                        break;

                    case 2:
                        System.out.println("*** Selling a car... ***" + '\n');
                        Vehicle vehicleToSell = selectVehicle(vehicles, countCar);
                        double salePrice = 0;
                        if (vehicleToSell != null) {
                            salePrice = vehicleToSell.calculateSalePrice();
                        }
                        System.out.println("Sale price: EGP " + salePrice);
                        break;

                    case 3:
                        displayCars(vehicles , countCar);
                        break;

                    case 4:
                        displayEmployee(employees, countEmployee);
                        break;

                    case 5:
                        System.out.println("Your customers");
                        displayCustomer(customers, countCustomer);
                        break;

                    case 6 :
                        countCar++;
                        addCar(vehicles , countCar);
                        System.out.println("CAR ADDED");
                        break;

                    case 7:
                        countCustomer++;
                        addUser(customers, countCustomer);
                        System.out.println("CUSTOMER ADDED");
                        break;

                    case 8:
                        countEmployee++;
                        addEmployee(employees, countEmployee);
                        System.out.println("EMPLOYEE ADDED");
                        break;

                    case 9:
                        System.out.println("THANK YOU <3");
                        choice = false;

                }

            }
        } catch (InputMismatchException exception) {
            System.out.println("Invalid Input , USE ONLY NUMBERS.");
        }
    }

    public static Vehicle selectVehicle(Vehicle[] vehicles,int countCar) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a vehicle by ID:");
        for (int i = 0; i<= countCar; i++){
            System.out.println(vehicles[i].getId() + ": " + vehicles[i].getManufacture() + " " + vehicles[i].getModel() + " (" + vehicles[i].getYear() + ")");
}
        int vehicleId = input.nextInt();
        for (int i = 0; i<= countCar; i++){
            if (vehicles[i].getId() == vehicleId) {
                if (vehicles[i].isRented()) {
                    System.out.println("Vehicle is already rented");
                } else {
                    return vehicles[i];
                }
            }
        }
        System.out.println("Vehicle not found");
        return null;
    }

    public static int selectDaysRented() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of days to rent:");
        int daysRented;
        daysRented = scanner.nextInt();
        return daysRented;
    }

    public static void addCar(Vehicle[] vehicles, int countCar) {
        Scanner input = new Scanner(System.in);
        System.out.println("**** ADDING NEW CAR ****" + '\n');
        System.out.println("Enter id : ");
        int id = input.nextInt();
        System.out.println("Enter manufacture : ");
        String manufacture = input.next();
        System.out.println("Enter model : ");
        String model = input.next();
        System.out.println("Enter year : ");
        int year = input.nextInt();
        System.out.println("Enter price per day : ");
        double pricePerDay = input.nextDouble();

        try {
            vehicles[countCar] = new Vehicle(id, manufacture, model, year, pricePerDay);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid");
        }
    }

    public static void addUser(Customer[] customers, int countCustomer) {
        Scanner input = new Scanner(System.in);
        System.out.println("**** ADDING NEW CUSTOMER ****" + '\n');
        System.out.println("Enter id :");
        int id = input.nextInt();
        System.out.println("Enter name :");
        String name = input.next();
        System.out.println("Enter email :");
        String email = input.next();
        System.out.println("Phone number :");
        String phone = input.next();

        try {
            customers[countCustomer] = new Customer(id, name, email, phone);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid");
        }
    }

    public static void addEmployee(Employee[] employees, int contEmployee) {
        Scanner input = new Scanner(System.in);
        System.out.println("**** ADDING NEW EMPLOYEE ****" + '\n');
        System.out.println("Enter id :");
        int id = input.nextInt();
        System.out.println("Enter name :");
        String name = input.next();
        System.out.println("Enter salary :");
        double salary = input.nextDouble();
        System.out.println("Enter role :");
        String role = input.next();

        try {
            employees[contEmployee] = new Employee(id, name, salary, role);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Invalid");
        }
    }

    public static void displayCustomer(Customer[] customers, int countCustomer) {
        for (int i = 0; i <= countCustomer; i++) {
            System.out.println("Id : " + customers[i].getId());
            System.out.println("Name : " + customers[i].getName());
            System.out.println("Email : " + customers[i].getEmail());
            System.out.println("Phone number : " + customers[i].getPhone());
            System.out.println("**********************************************");
        }
    }

    public static void displayEmployee(Employee[] employees, int countEmployee) {
        for (int u = 0; u <= countEmployee; u++) {
            System.out.println("Id : " + employees[u].getId());
            System.out.println("Name : " + employees[u].getName());
            System.out.println("Salary : " + employees[u].getSalary());
            System.out.println("Role : " + employees[u].getRole());
            System.out.println("**********************************************");
        }
    }

    public static void displayCars(Vehicle[] vehicles, int countCar) {
        for (int m = 0; m <= countCar; m++) {
            System.out.println("Id : " + vehicles[m].getId());
            System.out.println("Manufacture : " + vehicles[m].getManufacture());
            System.out.println("Model : " + vehicles[m].getModel());
            System.out.println("Year : " + vehicles[m].getYear());
            System.out.println("Price per day : " + vehicles[m].getPricePerDay());
            System.out.println("Is car rented ? : " + vehicles[m].isRented());
            System.out.println("**********************************************");
        }
    }
}