package dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Terrain;

@Repository
public interface TerrainDAO extends JpaRepository<Terrain, Integer> {

	List<Terrain> findBySurfaceTotaleBetween(float surfaceMin, float surfaceMax);
	List<Terrain> findBySurfaceTotaleBetweenAndSurfaceConstructibleBetween(float surfaceTMin, float surfaceTMax, float surfaceCMin, float surfaceCMax);
	List<Terrain> findBySurfaceTotaleBetweenAndProprietaireNomContaining(float surfaceMin, float surfaceMax, String pProprioNom);
	List<Terrain> findByOrderBySurfaceTotale();
	List<Terrain> findByOrderBySurfaceConstructible();
	List<Terrain> findByOrderByProprietaireNom();

}
