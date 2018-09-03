package com.imokhonko;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String department;
    private String name;
    private int salary;
    private String currency;
    private String position;
    private List<String> skills = new ArrayList<>(10);

    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPosition() {
        return position;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", currency='" + currency + '\'' +
                ", position='" + position + '\'' +
                ", skills=" + skills +
                '}';
    }
}
