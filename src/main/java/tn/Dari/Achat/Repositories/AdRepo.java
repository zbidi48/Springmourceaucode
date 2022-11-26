package tn.Dari.Achat.Repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Dari.Achat.Entities.Ad;

@Repository
@Primary
public interface AdRepo extends JpaRepository<Ad, Long>{

}
