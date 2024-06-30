package projetoinicial.controller.response;

import projetoinicial.model.Usuario;

public class UsuarioResponse {

	private Long id;
	private String nome;
	private Integer idade;
	private String cpf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setId(usuario.getId());
		usuarioResponse.setNome(usuario.getNome());
		usuarioResponse.setIdade(usuario.getIdade());
		usuarioResponse.setCpf(usuario.getCpf());
		return usuarioResponse;
	}
}
