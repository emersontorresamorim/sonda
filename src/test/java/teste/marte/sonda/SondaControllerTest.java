package teste.marte.sonda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import teste.marte.sonda.dto.EntradaDTO;
import teste.marte.sonda.dto.SondaDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class SondaControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void deveConsumirEndpointSondaComSucesso() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0]").value("1 3 N"))
				.andExpect(jsonPath("$[1]").value("5 1 L"));
	}

	private static String getJsonEntrada() {
		try {
			List<SondaDTO> sondasDTO = new ArrayList<>();
			sondasDTO.add(new SondaDTO("1 2 N", "EMEMEMEMM"));
			sondasDTO.add(new SondaDTO("3 3 L", "MMDMMDMDDM"));

			EntradaDTO entrada = new EntradaDTO("5 5", sondasDTO);
			return new ObjectMapper().writeValueAsString(entrada);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
