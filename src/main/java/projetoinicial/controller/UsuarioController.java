package projetoinicial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import projetoinicial.controller.request.UsuarioRequest;
import projetoinicial.controller.response.UsuarioResponse;
import projetoinicial.model.Usuario;
import projetoinicial.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	//conflito
	//Alterei essa linha pelo branch

	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuario() {
		var response = usuarioService.listaUsuario();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public void salvarUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) throws Exception {
		Usuario usuario = UsuarioRequest.toUsuario(usuarioRequest);
		usuarioService.salvarUsuario(usuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> buscar(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.buscar(id);
		var response = UsuarioResponse.toUsuarioResponse(usuario);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Usuario>> buscarPorParametro(@RequestParam("nome") String nome) {
		var response = usuarioService.buscarPorParametro(nome);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable("id") Long id) {
		usuarioService.deletar(id);
	}
}
