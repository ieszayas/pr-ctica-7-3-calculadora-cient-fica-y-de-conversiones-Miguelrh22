package com.miky.calculadora;

public class MikyMath {
    public static Double sumar(double n1, double n2){
        return n1 + n2;
    }
    public static Double restar(double n1, double n2){
        return n1 - n2;
    }

    public static Double dividir(double n1, double n2){
        return n1 / n2;
    }

    public static Double multiplicar(double n1, double n2){
        return n1 * n2;
    }

    public static Double calcular(double n1, double n2, Opera tipo){
        return switch (tipo){
            case SUMAR -> sumar(n1, n2);
            case RESTAR -> restar(n1, n2);
            case DIVIDIR -> dividir(n1, n2);
            case MULTIPLICAR -> multiplicar(n1, n2);
            default -> 0.0;
        };
    }
}
