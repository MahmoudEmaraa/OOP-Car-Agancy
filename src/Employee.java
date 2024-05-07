class Employee extends Human{

    private double salary;
    private String role;

    public Employee(int id, String name , double salary, String role) {
        super(name , id);
        this.salary = salary;
        this.role = role;
    }


    public double getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }


}
