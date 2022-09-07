package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Terrain;
import dal.TerrainDAO;

@Service
public class TerrainBLL {

	@Autowired
	private TerrainDAO dao;
	
	public List<Terrain> findAll() {
		return dao.findAll();
	}
	
	public Terrain findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Terrain terrain) {
		dao.save(terrain);
	}

	public List<Terrain> findByCriteria(String pSurfaceMin, String pSurfaceMax, String pProprioNom) {
		float surfaceMin = 0f;
		float surfaceMax = Float.MAX_VALUE;
		
		if (pSurfaceMin != null && !pSurfaceMin.isBlank()) {
			surfaceMin = Float.parseFloat(pSurfaceMin);
		}
		
		if (pSurfaceMax != null && !pSurfaceMax.isBlank()) {
			surfaceMax = Float.parseFloat(pSurfaceMax);
		}
		
		if (pProprioNom == null) {
			pProprioNom = "";
		}
		
		return dao.findBySurfaceTotaleBetweenAndProprietaireNomContaining(surfaceMin, surfaceMax, pProprioNom);
	}

	public List<Terrain> findByTri(String tri) {
		List<Terrain> resultat;
		switch (tri) {
		case "surface.totale": {
			resultat = dao.findByOrderBySurfaceTotale();
			break;
		}
		case "surface.cons": {
			resultat = dao.findByOrderBySurfaceConstructible();
			break;
		}
		case "proprio.nom" : {
			resultat = dao.findByOrderByProprietaireNom();
			break;
		}
		default : {
			resultat = dao.findAll();
			break;
		}
		}
		return resultat;
	}
}
