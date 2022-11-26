package tn.Dari.Achat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.Dari.Achat.Entities.SellAd;
import tn.Dari.Achat.Entities.comment;
import tn.Dari.Achat.Exception.SellAdNotFoundException;
import tn.Dari.Achat.Repositories.CommentsRepo;
import tn.Dari.Achat.Repositories.SellRepo;

@Service
public class CommentsService {
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
private SellService sellService;	
	
	public comment addComment(comment comment) {
		
		return commentsRepo.save(comment);
	}
	
	public List<comment> getComments(){
		return commentsRepo.findAll();
	}
	
	

	public comment findById(Long id) {
		return commentsRepo.findById(id).orElseThrow(()->
		new SellAdNotFoundException(id)
				);
	}
	
	public comment ajoutComentToAdById(comment comment, Long adid) {
		SellAd sellinter = sellService.findSellAdById(adid);
		
		comment cominter = commentsRepo.save(comment);
		cominter.setAd(sellinter);
		
		return commentsRepo.save(comment);
	}
	
	public List<comment> findByDescription(String description) {
		return commentsRepo.findCommentByDes(description);
	
	}


}
