package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Proprietaire;
import dal.ProprietaireDAO;

@Service
public class ProprietaireBLL {
	@Autowired
	private ProprietaireDAO dao;
	
	public List<Proprietaire> findAll() {
		return dao.findAll();
	}
	
	public List<Proprietaire> findAllOrderByNom() {
		return dao.findByOrderByNom();
	}
	
	public Proprietaire findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Proprietaire proprietaire) {
		dao.save(proprietaire);
	}
}
