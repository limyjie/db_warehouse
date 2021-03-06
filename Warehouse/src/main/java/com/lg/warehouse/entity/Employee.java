package com.lg.warehouse.entity;

import java.util.Arrays;

/**
 * @author lin
 * @ClassName Employee
 * @date 2018/9/3 16:13
 * @description
 **/

public class Employee {

    private String account;
    private String employeeName;
    private String password;
    private String authorities;

    public Employee(String account,String password){
        this.account = account;
        this.password =password;
    }

    public Employee(String account,String employeeName,String password,String authorities){
        this.account = account;
        this.employeeName = employeeName;
        this.password =password;
        this.authorities = authorities;

    }

    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "account='" + account + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", password='" + password + '\'' +
                ", authorities='" + authorities + '\'' +
                '}';
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAuthorities(String authorities) {

        this.authorities = authorities;
    }

    public String getAuthorities() {

        return authorities;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
