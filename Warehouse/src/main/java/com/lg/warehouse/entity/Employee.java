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
    private String password;
    private String[] authorities;

    public Employee(String account,String password){
        this.account = account;
        this.password =password;
    }

    public Employee(String account,String password,String[] authorities){
        this.account = account;
        this.password =password;
        this.authorities = authorities;
    }

    public Employee(){}


    @Override
    public String toString() {
        return "Employee{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                '}';
    }

    public void setAuthorities(String[] authorities) {

        this.authorities = authorities;
    }

    public String[] getAuthorities() {

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
