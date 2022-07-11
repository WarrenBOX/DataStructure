package com.tunbobo.genericsDemo;

public class Printer <T>{
    T thingsToPrint; //declare the type that the class may use, and reference name to a specific address

    public Printer (T thingsToPrint ) {
        this.thingsToPrint = thingsToPrint;
    }

    public void print() {
        System.out.println(thingsToPrint);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "thingsToPrint=" + thingsToPrint +
                '}';
    }
}
