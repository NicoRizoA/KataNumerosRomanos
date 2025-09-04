package org.romans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;
import org.romans.service.ConvertidorNumerosImpl;
import org.romans.service.ConvertidorNumerosService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertidorNumerosServiceTest {

    private ConvertidorNumerosService convertidor;

    @BeforeEach
    void setUp() {
        convertidor = new ConvertidorNumerosImpl();
    }

    @Test
    void testConvertirArabigoARomanoCasosBasicos() {
        assertThat(convertidor.convertirArabigoARomano(1)).isEqualTo("I");
        assertThat(convertidor.convertirArabigoARomano(5)).isEqualTo("V");
        assertThat(convertidor.convertirArabigoARomano(10)).isEqualTo("X");
    }

    @Test
    void testConvertirArabigoARomanoCasosCombinados() {
        assertThat(convertidor.convertirArabigoARomano(4)).isEqualTo("IV");
        assertThat(convertidor.convertirArabigoARomano(9)).isEqualTo("IX");
        assertThat(convertidor.convertirArabigoARomano(21)).isEqualTo("XXI");
        assertThat(convertidor.convertirArabigoARomano(50)).isEqualTo("L");
        assertThat(convertidor.convertirArabigoARomano(100)).isEqualTo("C");
        assertThat(convertidor.convertirArabigoARomano(500)).isEqualTo("D");
        assertThat(convertidor.convertirArabigoARomano(1000)).isEqualTo("M");
    }

    @Test
    void testConvertirArabigoARomanoBorderCases() {
        assertThat(convertidor.convertirArabigoARomano(1)).isEqualTo("I");
        assertThat(convertidor.convertirArabigoARomano(3999)).isEqualTo("MMMCMXCIX");
    }

    @Test
    void testConvertirArabigoARomanoInvalidos() {
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.convertirArabigoARomano(0));
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.convertirArabigoARomano(4000));
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.convertirArabigoARomano(null));
    }

    @Test
    void testConvertirRomanoAArabigoCasosBasicos() {
        assertThat(convertidor.convertirRomanoAArabigo("I")).isEqualTo(1);
        assertThat(convertidor.convertirRomanoAArabigo("V")).isEqualTo(5);
        assertThat(convertidor.convertirRomanoAArabigo("X")).isEqualTo(10);
    }

    @Test
    void testConvertirRomanoAArabigoCasosCombinados() {
        assertThat(convertidor.convertirRomanoAArabigo("IV")).isEqualTo(4);
        assertThat(convertidor.convertirRomanoAArabigo("IX")).isEqualTo(9);
        assertThat(convertidor.convertirRomanoAArabigo("XXI")).isEqualTo(21);
        assertThat(convertidor.convertirRomanoAArabigo("L")).isEqualTo(50);
        assertThat(convertidor.convertirRomanoAArabigo("C")).isEqualTo(100);
        assertThat(convertidor.convertirRomanoAArabigo("D")).isEqualTo(500);
        assertThat(convertidor.convertirRomanoAArabigo("M")).isEqualTo(1000);
        assertThat(convertidor.convertirRomanoAArabigo("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    void testConvertirRomanoAArabigoInvalidos() {
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.convertirRomanoAArabigo(null));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.convertirRomanoAArabigo(""));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.convertirRomanoAArabigo("ABC"));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.convertirRomanoAArabigo("IIII"));
    }
}