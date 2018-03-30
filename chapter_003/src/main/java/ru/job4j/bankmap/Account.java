package ru.job4j.bankmap;

public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public void addMoney(double value) {
        this.value = this.value + value;
    }

    public void takeMoney(double value) {
        if (value <= this.value) {
            this.value = this.value - value;
        }
    }
}
