package com.example.employeeinformation.model;

public class Employee {
    private String Id;
    private String name;
    private int age;
    private String maritalStatus;
    private String citizenship;

    public Employee(String Id,String name, int age, String maritalStatus, String citizenship) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
    }

    public Employee() {

    }

    // getters and setters

    public String getId(){
        return Id;
    }

    public void setId(String Id){
        this.Id = Id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
}
