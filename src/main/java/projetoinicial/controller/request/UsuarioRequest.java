package projetoinicial.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projetoinicial.model.Endereco;
import projetoinicial.model.Usuario;

public class UsuarioRequest {

	@NotBlank(message = "o campo é obrigatório")
	private String nome;
	@NotNull(message = "o campo é obrigatório")
	private Integer idade;
	@NotBlank(message = "o campo é obrigatório")
	private String cpf;
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	public static Usuario toUsuario(UsuarioRequest usuarioRequest) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioRequest.getNome());
		usuario.setIdade(usuarioRequest.getIdade());
		usuario.setCpf(usuarioRequest.getCpf());
		usuario.setEndereco(usuarioRequest.getEndereco());
		return usuario;
	}
}
