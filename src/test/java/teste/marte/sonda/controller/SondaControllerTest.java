package teste.marte.sonda.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

	private String getJsonEntrada(String limitePlanalto, String posicaoSonda, String comandoSonda) {
		try {
			List<SondaDTO> sondasDTO = new ArrayList<>();
			sondasDTO.add(new SondaDTO(posicaoSonda, comandoSonda));
			EntradaDTO entrada = new EntradaDTO(limitePlanalto, sondasDTO);
			return new ObjectMapper().writeValueAsString(entrada);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void deveExecutarComandoSondaViaRestComSucesso() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 2 N", "EMEMEMEMM"))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0]").value("1 3 N")).andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemPlanaltoNulo() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada(null, "1 2 N", "EMEMEMEMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"Os valores de Limite superior do Planalto não podem ser nulos.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemPlanaltoInvalido() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 a", "1 2 N", "EMEMEMEMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"Os valores de Limite superior X ou Y do Planalto são inválidos.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemSondaNula() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", null, "EMEMEMEMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"Os valores de posição X, Y e Direção da Sonda não podem ser nulos.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemPosicaoSondaInvalida() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 * N", "EMEMEMEMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"Os valores de posição X ou Y da Sonda são inválidos.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemDirecaoSondaInvalida() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 2 X", "EMEMEMEMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"O valor de Direção da Sonda é inválido.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemComandoSondaNuloOuVazio() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 2 N", ""))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"O valor de Comando da Sonda não pode ser nulo ou vazio.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemComandoSondaInvalido() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 2 N", "EMEMEMEKM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"O valor de Comando da Sonda é inválido.\"}}"))
				.andDo(print());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void deveRetornarMensagemMovimentoSondaInvalido() throws Exception {
		mvc.perform(post("/sonda/executar").content(getJsonEntrada("5 5", "1 2 N", "EMEMEMEMMMMM"))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(content().string(
						"{\"errors\":{\"Sonda application error\":\"Movimento de Sonda inválido. (Localização: 1 5 N - Planalto: 5 5).\"}}"))
				.andDo(print());
	}
}
