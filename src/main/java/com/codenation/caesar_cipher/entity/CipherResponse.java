package com.codenation.caesar_cipher.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CipherResponse {

	@JsonProperty("numero_casas")
	private int numeroCasas;

	@JsonProperty("token")
	private String token;
	
	@JsonProperty("cifrado")
	private String cifrado;
	
	@JsonProperty("decifrado")
	private String decifrado;

	@JsonProperty("resumo_criptografico")
	private String resumoCriptografico;

	public CipherResponse() {
		super();
	}

	public CipherResponse(int numeroCasas, String token, String cifrado, String decifrado, String resumoCriptografico) {
		super();
		this.numeroCasas = numeroCasas;
		this.token = token;
		this.cifrado = cifrado;
		this.decifrado = decifrado;
		this.resumoCriptografico = resumoCriptografico;
	}

	public int getNumeroCasas() {
		return numeroCasas;
	}

	public void setNumeroCasas(int numeroCasas) {
		this.numeroCasas = numeroCasas;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String getResumoCriptografico() {
		return resumoCriptografico;
	}

	public void setResumoCriptografico(String resumoCriptografico) {
		this.resumoCriptografico = resumoCriptografico;
	}

}
