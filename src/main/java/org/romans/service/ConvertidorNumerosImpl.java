package org.romans.service;

import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConvertidorNumerosImpl implements ConvertidorNumerosService {

    @Override
    public String convertirArabigoARomano(Integer numero){
        validarNumeroArabico(numero);

        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        return convertirARomano(numero, valores, simbolos);
    }

    private void validarNumeroArabico(Integer numero){
        if (numero == null) {
            throw new InvalidArabicNumberException("Número de entrada no puede ser null.");
        }
        if (numero <= 0 || numero > 3999) {
            throw new InvalidArabicNumberException("Número fuera del rango permitido: " + numero);
        }
    }

    private String convertirARomano(Integer numero, int[] valores, String[] simbolos){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                numero -= valores[i];
                result.append(simbolos[i]);
            }
        }
        return result.toString();
    }

    @Override
    public int convertirRomanoAArabigo(String numeroRomanoEntrada){
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

        return convertirAArabigo(numeroRomanoEntrada, mapa);
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

    private int convertirAArabigo(String numeroRomanoEntrada, Map<Character, Integer> mapa){
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
