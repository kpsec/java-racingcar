package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    int a = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;

    String method = "";

    public int add(int a, int b) {
        return a+b;
    }
    public int substract(int a, int b) {
        return a-b;
    }
    public int multiply(int a, int b) {
        return a*b;
    }
    public int divide(int a, int b) {
        return a/b;
    }

    public static void main(String[] args) {
        String input = "2 + 3 / 1";
        String[] numbers = input.split("[^0-9]");
        String[] operands = input.split("[0-9]+");
        for(String s : numbers) System.out.print(s);
        System.out.println("");
        for(String s : operands) System.out.print(s);
    }

    public int calulator(String input) {
        inputValidCheck(input);

        List<String> inputString = new ArrayList<>();
        inputString.addAll(List.of(input.split(" ")));
        a = Integer.parseInt(inputString.get(0));
        inputString.remove(0);

        while(!inputString.isEmpty()) {
            method = operandValidCheck(inputString.get(0));
            inputString.remove(0);
            b = Integer.parseInt(inputString.get(0));
            a = judgeMethod(a,b,method);
            inputString.remove(0);
        }
        System.out.println(a);
        return a;
    }

    private String operandValidCheck(String s) {
        if(!(s.equals("+") && s.equals("-") && s.equals("*") && s.equals("/"))) {
            throw new IllegalArgumentException();
        }
        return s;
    }

    private int judgeMethod(int a, int b, String method) {
        if(method.equals("+"))
            return add(a, b);
        if(method.equals("-"))
            return substract(a, b);
        if(method.equals("*"))
            return multiply(a, b);
        if(method.equals("/"))
            return divide(a, b);
        return -9;
    }

    private void inputValidCheck(String input) {
        if(input.isBlank() || input.isEmpty() || input == null) {
            throw new IllegalArgumentException();
        }
    }

}
