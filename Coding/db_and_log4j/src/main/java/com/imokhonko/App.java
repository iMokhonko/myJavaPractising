package com.imokhonko;

import com.imokhonko.DAO.UsersDAO;

public class App {

    public static void main(String[] args) {

        UsersDAO usersDAO = new UsersDAO ();

        for (User user : usersDAO.selectAll ()) {
            System.out.println ("Name: " + user.getName ());
            System.out.println ("Address: " + user.getAddress ());
            System.out.println ("Email: " + user.getEmail ());
            System.out.println ("Phone number: " + user.getPhone_number ());
            System.out.println ("___________________________________________");
        }

    }

}
