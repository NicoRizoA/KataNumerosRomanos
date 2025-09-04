package org.romans;

import org.junit.jupiter.api.Test;
import org.romans.dto.ConversionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConvertidorNumerosControllerTest {

    @LocalServerPort
    private int puerto;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + puerto + "/api/romanos";
    }

    @Test
    void testArabigoARomanoValido() {
        ResponseEntity<ConversionResponseDTO> response = restTemplate.getForEntity(
                baseUrl() + "/arabigo-a-romano?valor=21", ConversionResponseDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getEntrada()).isEqualTo("21");
        assertThat(response.getBody().getSalida()).isEqualTo("XXI");
    }

    @Test
    void testRomanoAArabigoValido() {
        ResponseEntity<ConversionResponseDTO> response = restTemplate.getForEntity(
                baseUrl() + "/romano-a-arabigo?valor=XXI", ConversionResponseDTO.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getEntrada()).isEqualTo("XXI");
        assertThat(response.getBody().getSalida()).isEqualTo("21");
    }

}
