package org.romans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertidorNumerosRomanosTest {

    private ConvertidorNumerosRomanos convertidor;

    @BeforeEach
    void setUp() {
        convertidor = new ConvertidorNumerosRomanos();
    }

    @Test
    void testARomanoCasosBasicos() {
        assertThat(convertidor.aRomano(1)).isEqualTo("I");
        assertThat(convertidor.aRomano(5)).isEqualTo("V");
        assertThat(convertidor.aRomano(10)).isEqualTo("X");
    }

    @Test
    void testARomanoCasosCombinados() {
        assertThat(convertidor.aRomano(4)).isEqualTo("IV");
        assertThat(convertidor.aRomano(9)).isEqualTo("IX");
        assertThat(convertidor.aRomano(21)).isEqualTo("XXI");
        assertThat(convertidor.aRomano(50)).isEqualTo("L");
        assertThat(convertidor.aRomano(100)).isEqualTo("C");
        assertThat(convertidor.aRomano(500)).isEqualTo("D");
        assertThat(convertidor.aRomano(1000)).isEqualTo("M");
    }

    @Test
    void testARomanoBorderCases() {
        assertThat(convertidor.aRomano(1)).isEqualTo("I");
        assertThat(convertidor.aRomano(3999)).isEqualTo("MMMCMXCIX");
    }

    @Test
    void testARomanoInvalidos() {
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.aRomano(0));
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.aRomano(4000));
        assertThrows(InvalidArabicNumberException.class, () -> convertidor.aRomano(null));
    }

    @Test
    void testAArabicoCasosBasicos() {
        assertThat(convertidor.aArabico("I")).isEqualTo(1);
        assertThat(convertidor.aArabico("V")).isEqualTo(5);
        assertThat(convertidor.aArabico("X")).isEqualTo(10);
    }

    @Test
    void testAArabicoCasosCombinados() {
        assertThat(convertidor.aArabico("IV")).isEqualTo(4);
        assertThat(convertidor.aArabico("IX")).isEqualTo(9);
        assertThat(convertidor.aArabico("XXI")).isEqualTo(21);
        assertThat(convertidor.aArabico("L")).isEqualTo(50);
        assertThat(convertidor.aArabico("C")).isEqualTo(100);
        assertThat(convertidor.aArabico("D")).isEqualTo(500);
        assertThat(convertidor.aArabico("M")).isEqualTo(1000);
        assertThat(convertidor.aArabico("MMMCMXCIX")).isEqualTo(3999);
    }

    @Test
    void testAArabicoInvalidos() {
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.aArabico(null));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.aArabico(""));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.aArabico("ABC"));
        assertThrows(InvalidRomanNumeralException.class, () -> convertidor.aArabico("IIII"));
    }
}