package tn.Dari.Achat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.Achat.Entities.imgDesc;

@Repository
public interface ImageRepo extends JpaRepository<imgDesc, Long> {
	

}
