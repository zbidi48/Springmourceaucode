package tn.Dari.Achat.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.Achat.Entities.SellAd;
import tn.Dari.Achat.Entities.comment;
import tn.Dari.Achat.Services.CommentsService;

@RestController
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("/all")
	public List<comment> getallcomments1(){
		
		List<comment> comments = commentsService.getComments();
		return comments;
		
	}
	
	
	
	
	@GetMapping("/allList")
	public ResponseEntity<List<comment>> getallcomments(){
		
		List<comment> comments = commentsService.getComments();
		return new ResponseEntity<List<comment>>(comments, HttpStatus.OK);
		
	}
	/*
	@PostMapping("/add")
	public comment ajouter (comment comment) {
		return commentsService.addComment(comment);
	}
	
	*/
	@PostMapping("/Add")
	public ResponseEntity<comment> Ajoutercomment(@RequestBody comment comment){
		comment ajout = commentsService.addComment(comment);
		return new ResponseEntity<>(ajout, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/add1")
	public comment ajouter (comment comment) {
		return commentsService.addComment(comment);}

	@GetMapping("/find/{id}")
	public ResponseEntity<comment> findbyid (@PathVariable("id") Long id){
		comment com = commentsService.findById(id);
		return new ResponseEntity<comment>(com, HttpStatus.OK);
		
	}
	
	@PostMapping("/addcomment/{Adid}")
	public ResponseEntity<comment> addcommenttoad (@RequestBody comment comment, 
			@PathVariable("Adid") Long Adid){
		
		comment commentaireInter = commentsService.ajoutComentToAdById(comment, Adid);
		return new ResponseEntity<comment>(commentaireInter, HttpStatus.OK);
		
	}
	
	@GetMapping("/findBydesc/{description}")
	 public ResponseEntity<?> findBydescript (@PathVariable("description") String description ){
		
		List<comment> desc = commentsService.findByDescription(description);
		if (desc.isEmpty()) { return new ResponseEntity<String>("impossible de trouver le commentaire", HttpStatus.NOT_FOUND);}
		else return new ResponseEntity<List<comment>>(desc, HttpStatus.OK);
		
	}
	
	
}
