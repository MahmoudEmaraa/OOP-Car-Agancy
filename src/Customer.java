class Customer extends  Human{

    private String email;
    private String phone;

    public Customer(int id, String name, String email, String phone) {
        super(name , id);
        this.email = email;
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


}