package tn.Dari.Achat.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.Dari.Achat.Entities.comment;

@Repository
public interface CommentsRepo extends JpaRepository<comment, Long>{

	comment findCommentById(Long id);
	
	@Query(" select u from comment u where u.description like %:description% ")
	List<comment> findCommentByDes(@Param("description") String description);
	



}
