package org.romans;

import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;

import java.util.Map;

public class ConvertidorNumerosRomanos {

    public String aRomano(Integer numeroEntrada){

        validarNumeroArabico(numeroEntrada);

        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        return convertirARomano(numeroEntrada, valores, simbolos);
    }

    private void validarNumeroArabico(Integer numeroEntrada){
        if (numeroEntrada == null) {
            throw new InvalidArabicNumberException("Número de entrada no puede ser null.");
        }
        if (numeroEntrada <= 0 || numeroEntrada > 3999) {
            throw new InvalidArabicNumberException("Número fuera del rango permitido: " + numeroEntrada);
        }
    }

    private String convertirARomano(Integer numeroEntrada, int[] valores, String[] simbolos){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < valores.length; i++) {
            while (numeroEntrada >= valores[i]) {
                numeroEntrada -= valores[i];
                result.append(simbolos[i]);
            }
        }
        return result.toString();
    }

    public Integer aArabico(String numeroRomanoEntrada){

        validarNumeroRomano(numeroRomanoEntrada);

        Map<Character, Integer> mapa = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        return convertirAArabico(numeroRomanoEntrada, mapa);
    }

    private void validarNumeroRomano(String numeroRomanoEntrada){
        if (numeroRomanoEntrada == null){
            throw new InvalidRomanNumeralException("Número romano no puede ser null.");
        }

        numeroRomanoEntrada = numeroRomanoEntrada.trim();
        if (numeroRomanoEntrada.isEmpty()){
            throw new InvalidRomanNumeralException("Número romano no puede estar vacío.");
        }

        if (numeroRomanoEntrada.matches(".*(IIII|XXXX|CCCC|MMMM|VV|LL|DD).*")) {
            throw new InvalidRomanNumeralException("Repetición inválida en número romano: " + numeroRomanoEntrada);
        }
    }

    private Integer convertirAArabico(String numeroRomanoEntrada, Map<Character, Integer> mapa){

        int total = 0;
        int prev = 0;

        for (int i = numeroRomanoEntrada.length() - 1; i >= 0; i--) {
            char c = numeroRomanoEntrada.charAt(i);
            int valor = mapa.getOrDefault(c, -1);
            if (valor == -1) {
                throw new InvalidRomanNumeralException("Símbolo romano inválido: " + c);
            }

            if (valor < prev) {
                total -= valor;
            } else {
                total += valor;
            }
            prev = valor;
        }

        return total;
    }

}
