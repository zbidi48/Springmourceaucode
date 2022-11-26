package tn.Dari.Achat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import tn.Dari.Achat.Entities.Ad;

@NoRepositoryBean
public interface AbstractAdRepo <T extends Ad> extends JpaRepository<T, Long> {


}
