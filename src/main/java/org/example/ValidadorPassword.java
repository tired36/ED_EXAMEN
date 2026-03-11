package org.example;

public class ValidadorPassword {

    public static boolean esPasswordValida(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        boolean tieneDigito = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                tieneDigito = true;
            }
        }
        return tieneDigito;
    }

    public static int fuerzaPassword(String password) {
        if (password == null || password.length() < 8) {
            return 0;
        }
        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneDigito = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) tieneMayus = true;
            if (Character.isLowerCase(c)) tieneMinus = true;
            if (Character.isDigit(c)) tieneDigito = true;
        }
        int tipos = 0;
        if (tieneMayus) tipos++;
        if (tieneMinus) tipos++;
        if (tieneDigito) tipos++;
        if (tipos <= 1) return 0;
        if (tipos == 2) return 1;
        return 2;
    }
}
