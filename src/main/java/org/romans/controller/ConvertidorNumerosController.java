package org.romans.controller;

import org.romans.dto.ConversionResponseDTO;
import org.romans.exceptions.InvalidArabicNumberException;
import org.romans.exceptions.InvalidRomanNumeralException;
import org.romans.service.ConvertidorNumerosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/romanos")
public class ConvertidorNumerosController {

    private final ConvertidorNumerosService servicio;

    public ConvertidorNumerosController(ConvertidorNumerosService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/arabigo-a-romano")
    public ResponseEntity<ConversionResponseDTO> arabigoARomano(@RequestParam(required = false) Integer valor) {
        if (valor == null) {
            throw new InvalidArabicNumberException("Valor no puede ser nulo o estar vacío.");
        }
        String resultado = servicio.convertirArabigoARomano(valor);
        return ResponseEntity.ok(new ConversionResponseDTO(valor.toString(), resultado));
    }

    @GetMapping("/romano-a-arabigo")
    public ResponseEntity<ConversionResponseDTO> romanoAArabigo(@RequestParam(required = false) String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new InvalidRomanNumeralException("Valor no puede ser nulo o estar vacío.");
        }
        int resultado = servicio.convertirRomanoAArabigo(valor);
        return ResponseEntity.ok(new ConversionResponseDTO(valor, String.valueOf(resultado)));
    }

}
