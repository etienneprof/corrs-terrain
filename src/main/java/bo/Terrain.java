package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="terrains")
public class Terrain {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float surfaceTotale;
	private float surfaceConstructible;
	
	@ManyToOne
	private Proprietaire proprietaire;
	
	public Terrain() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSurfaceTotale() {
		return surfaceTotale;
	}

	public void setSurfaceTotale(float surfaceTotale) {
		this.surfaceTotale = surfaceTotale;
	}

	public float getSurfaceConstructible() {
		return surfaceConstructible;
	}

	public void setSurfaceConstructible(float surfaceConstructible) {
		this.surfaceConstructible = surfaceConstructible;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
}
