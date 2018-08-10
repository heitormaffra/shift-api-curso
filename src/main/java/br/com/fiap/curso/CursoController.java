package br.com.fiap.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cursos")
public class CursoController {

	@Autowired
	private CursoDAO cursoDAO;

	@RequestMapping(method=RequestMethod.POST)
	public String create(@RequestBody CursoEntity curso) {
		String cursoId = "";
		try {
			cursoDAO.save(curso);
			cursoId = String.valueOf(curso.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "Curso criado com sucesso, id = " + cursoId;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CursoEntity>> listAll() {
		try {
			List<CursoEntity> lista = (List<CursoEntity>) this.cursoDAO.findAll();
			return new ResponseEntity<List<CursoEntity>>(new ArrayList<CursoEntity>(lista), HttpStatus.OK);
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value="/cursos/{id}", method=RequestMethod.GET)
	public ResponseEntity<CursoEntity> listById(@RequestParam("id") int id) {
		try {
			Optional<CursoEntity> list = this.cursoDAO.findById(id);
			
			CursoEntity curso =  list!= null && list.isPresent() ? list.get() : null;
			
			return new ResponseEntity<CursoEntity>(curso, HttpStatus.OK);
		} catch (Exception ex) {
			return null;
		}
	}

}
