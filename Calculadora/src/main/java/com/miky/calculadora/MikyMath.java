package com.miky.calculadora;

public class MikyMath {

    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_JPY = 110.0;

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

    public static Double exp(double n1){
        return Math.pow(n1, 2);
    }

    public static Double sqrt(double n1){
        return Math.sqrt(n1);
    }

    public static Double sin(double n1){
        return Math.sin(Math.toRadians(n1));
    }

    public static Double cos(double n1){
        return Math.cos(Math.toRadians(n1));
    }

    public static Double tan(double n1){
        return Math.tan(Math.toRadians(n1));
    }


    public static double convertirLongitud(double valor, String unidadDe, String unidadA) {
        double factorConversion = 1.0;

        switch (unidadDe) {
            case "Metros":
                if ("Kilómetros".equals(unidadA)) {
                    factorConversion = 0.001;
                } else if ("Millas".equals(unidadA)) {
                    factorConversion = 0.000621371;
                }
                break;
            case "Kilómetros":
                if ("Metros".equals(unidadA)) {
                    factorConversion = 1000.0;
                } else if ("Millas".equals(unidadA)) {
                    factorConversion = 0.621371;
                }
                break;
            case "Millas":
                if ("Metros".equals(unidadA)) {
                    factorConversion = 1609.34;
                } else if ("Kilómetros".equals(unidadA)) {
                    factorConversion = 1.60934;
                }
                break;
        }

        return valor * factorConversion;
    }

    public static double convertirVolumen(double valor, String unidadDe, String unidadA) {
        double factorConversion = 1.0;

        switch (unidadDe) {
            case "Litros":
                if ("Galones".equals(unidadA)) {
                    factorConversion = 0.264172;
                } else if ("Cubos".equals(unidadA)) {
                    factorConversion = 0.001;
                }
                break;
            case "Galones":
                if ("Litros".equals(unidadA)) {
                    factorConversion = 3.78541;
                } else if ("Cubos".equals(unidadA)) {
                    factorConversion = 0.004329;
                }
                break;
            case "Cubos":
                if ("Litros".equals(unidadA)) {
                    factorConversion = 1000.0;
                } else if ("Galones".equals(unidadA)) {
                    factorConversion = 231.0;
                }
                break;
        }

        return valor * factorConversion;
    }

    public static double convertirTemperatura(double valor, String unidadDe, String unidadA) {
        double resultado = 0.0;

        if ("Celsius".equals(unidadDe)) {
            if ("Fahrenheit".equals(unidadA)) {
                resultado = (valor * 9 / 5) + 32;
            } else if ("Kelvin".equals(unidadA)) {
                resultado = valor + 273.15;
            }
        } else if ("Fahrenheit".equals(unidadDe)) {
            if ("Celsius".equals(unidadA)) {
                resultado = (valor - 32) * 5 / 9;
            } else if ("Kelvin".equals(unidadA)) {
                resultado = (valor + 459.67) * 5 / 9;
            }
        } else if ("Kelvin".equals(unidadDe)) {
            if ("Celsius".equals(unidadA)) {
                resultado = valor - 273.15;
            } else if ("Fahrenheit".equals(unidadA)) {
                resultado = (valor * 9 / 5) - 459.67;
            }
        }

        return resultado;
    }

    public static double convertirMoneda(String monedaInicial, String monedaFinal, double valor) {
        if (monedaInicial.equals(monedaFinal)) {
            return valor;
        }

        double valorEnUSD = convertirAUSD(monedaInicial, valor);
        return convertirDesdeUSD(monedaFinal, valorEnUSD);
    }

    private static double convertirAUSD(String moneda, double valor) {
        switch (moneda) {
            case "USD":
                return valor;
            case "EUR":
                return valor / USD_TO_EUR;
            case "GBP":
                return valor / USD_TO_GBP;
            case "JPY":
                return valor / USD_TO_JPY;
            default:
                throw new IllegalArgumentException("Moneda no reconocida: " + moneda);
        }
    }

    private static double convertirDesdeUSD(String moneda, double valorEnUSD) {
        switch (moneda) {
            case "USD":
                return valorEnUSD;
            case "EUR":
                return valorEnUSD * USD_TO_EUR;
            case "GBP":
                return valorEnUSD * USD_TO_GBP;
            case "JPY":
                return valorEnUSD * USD_TO_JPY;
            default:
                throw new IllegalArgumentException("Moneda no reconocida: " + moneda);
        }
    }

}
