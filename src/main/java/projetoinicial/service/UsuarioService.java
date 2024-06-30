package projetoinicial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetoinicial.model.Usuario;
import projetoinicial.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public void salvarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public List<Usuario> buscarPorParametro(String nome) {
		return usuarioRepository.buscaNomeSemHibernate(nome);
	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
}
