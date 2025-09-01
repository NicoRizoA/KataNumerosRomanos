package org.romans;

public class Main {
    public static void main(String[] args) {
        ConvertidorNumerosRomanos converter = new ConvertidorNumerosRomanos();

        System.out.println("1 → " + converter.aRomano(1));
        System.out.println("3999 → " + converter.aRomano(3999));
        System.out.println("IV → " + converter.aArabico("IV"));
        System.out.println("MMMCMXCIX → " + converter.aArabico("MMMCMXCIX"));
    }
}

