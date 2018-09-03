package com.imokhonko;

public class User {

    private final String name;
    private final String phone_number;
    private final String email;
    private final String address;

    public User(String name, String phone_number,
                String email, String address) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        User user = (User) o;

        if (name != null ? !name.equals ( user.name ) : user.name != null) return false;
        if (phone_number != null ? !phone_number.equals ( user.phone_number ) : user.phone_number != null) return false;
        if (email != null ? !email.equals ( user.email ) : user.email != null) return false;
        return address != null ? address.equals ( user.address ) : user.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode () : 0;
        result = 31 * result + (phone_number != null ? phone_number.hashCode () : 0);
        result = 31 * result + (email != null ? email.hashCode () : 0);
        result = 31 * result + (address != null ? address.hashCode () : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", phone_number='" + phone_number + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + '}';
    }

    public static class Builder {

        private String name;
        private String phone_number;
        private String email;
        private String address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phone_number(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(name, phone_number, email, address);
        }

    }

}
