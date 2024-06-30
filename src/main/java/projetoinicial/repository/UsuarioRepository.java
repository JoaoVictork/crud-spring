package projetoinicial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetoinicial.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNomeLike(String nome);
	
	@Modifying
	@Query(value = "select * from TB_USUARIO where nome like %:nome%", 
			nativeQuery = true)
	List<Usuario> buscaNomeSemHibernate(@Param("nome") String nome);
}
