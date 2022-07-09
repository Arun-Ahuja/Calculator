package com.example.arunahuja.myapplication;

public class Calculator {
    private double firstOperand;
    private double secondOperand;
    private char operator='f';

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double calculation(){
        switch (getOperator()) {

            case '+':
                return getFirstOperand() + getSecondOperand();

            case '-':
                return getFirstOperand() - getSecondOperand();

            case'*':
                return getFirstOperand() * getSecondOperand();

            case'/':
                return getFirstOperand()/getSecondOperand();

            case's': {
                double valueSin=Math.toRadians(getFirstOperand());
                System.out.println(valueSin+"sin value");

                return Math.sin(valueSin);

            }

            case'T':
            {
                double valueTan=Math.toRadians(getFirstOperand());
                System.out.println(valueTan+"tan value");
                System.out.println(Math.tan(valueTan)+"tan calculation");

                return Math.tan(getFirstOperand());
            }
            case'C':
            {
                double valueCos=Math.toRadians(getFirstOperand());
                System.out.println(valueCos+"cos value");
                 System.out.println(Math.cos(valueCos)+"cos calculation");
                return Math.cos(getFirstOperand());
            }
        }
        return getSecondOperand();
    }


}
