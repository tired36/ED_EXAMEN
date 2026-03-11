package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class validadorPasswordTest {

    // ---- Tests de esPasswordValida ----

    @Test
    public void passwordNula_debeRetornarFalse() {
        String password = null;
        boolean resultado = ValidadorPassword.esPasswordValida(password);
        assertFalse(resultado);
    }

    @Test
    public void passwordMenorDeOchoCaracteres_debeRetornarFalse() {
        String password = "abc1";
        boolean resultado = ValidadorPassword.esPasswordValida(password);
        assertFalse(resultado);
    }

    @Test
    public void passwordSinDigito_debeRetornarFalse() {
        String password = "abcdefgh";
        boolean resultado = ValidadorPassword.esPasswordValida(password);
        assertFalse(resultado);
    }

    @Test
    public void passwordOchoCaracteresConDigito_debeRetornarTrue() {
        String password = "abcdefg1";
        boolean resultado = ValidadorPassword.esPasswordValida(password);
        assertTrue(resultado);
    }

    @Test
    public void passwordLargaConDigitos_debeRetornarTrue() {
        String password = "password123";
        boolean resultado = ValidadorPassword.esPasswordValida(password);
        assertTrue(resultado);
    }

    // ---- Tests de fuerzaPassword ----

    @Test
    public void passwordDebil_soloMinusculas_debeRetornarCero() {
        String password = "abcdefgh";
        int resultado = ValidadorPassword.fuerzaPassword(password);
        assertEquals(0, resultado);
    }

    @Test
    public void passwordFuerte_mayusMinusDigito_debeRetornarDos() {
        String password = "Password1";
        int resultado = ValidadorPassword.fuerzaPassword(password);
        assertEquals(2, resultado);
    }
}
