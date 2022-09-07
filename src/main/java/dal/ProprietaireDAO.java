package dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Proprietaire;

@Repository
public interface ProprietaireDAO extends JpaRepository<Proprietaire, Integer> {
	List<Proprietaire> findByOrderByNom();
}
