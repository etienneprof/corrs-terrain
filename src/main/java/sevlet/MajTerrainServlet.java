package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import bll.ProprietaireBLL;
import bll.TerrainBLL;
import bo.Proprietaire;
import bo.Terrain;

/**
 * Servlet implementation class MajTerrainServlet
 */
@WebServlet("/gererTerrain")
public class MajTerrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private TerrainBLL tBll;
	@Autowired
	private ProprietaireBLL pBll;
       
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		if (pId != null) {
			int id = Integer.parseInt(pId);
			request.setAttribute("terrain", tBll.findById(id));
		}
		request.setAttribute("listeProprios", pBll.findAll());
		
		request.getRequestDispatcher("/WEB-INF/jsp/formulaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pSurfaceT = request.getParameter("surfaceT");
		String pSurfaceC = request.getParameter("surfaceC");
		String propId = request.getParameter("prop.id");
		String nom = request.getParameter("prop.nom");
		String prenom = request.getParameter("prop.prenom");
		
		Proprietaire proprio = new Proprietaire();
		proprio.setId(Integer.parseInt(propId));
		proprio.setNom(nom);
		proprio.setPrenom(prenom);
		
		Terrain terrain = new Terrain();
		// Utile que pour le update
		// Si l'identifiant est renseigne, je recupere les infos du terrain aupres de la bdd
		if (pId != null && !pId.isBlank()) {
			terrain = tBll.findById(Integer.parseInt(pId));
		}
		terrain.setSurfaceTotale(Float.parseFloat(pSurfaceT));
		terrain.setSurfaceConstructible(Float.parseFloat(pSurfaceC));
		
		terrain.setProprietaire(proprio);
		
		// Je ne fais un save que pour ajouter un proprietaire si celui ci n'existe pas
		if (proprio.getId() == 0) {
			pBll.save(proprio);
		}
		tBll.save(terrain);
		
		response.sendRedirect("accueil");
	}

}
