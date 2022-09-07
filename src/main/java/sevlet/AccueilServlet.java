package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import bll.TerrainBLL;
import bo.Terrain;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private TerrainBLL bll;
       
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tri = request.getParameter("tri");
		if (tri != null && !tri.isBlank()) {
			// Cas de figure de tri
			List<Terrain> terrains = bll.findByTri(tri);
			request.setAttribute("listeTerrains", terrains);
		} else {
			// Cas de figure de filtre
			String pSurfaceMin = request.getParameter("surface.min");
			String pSurfaceMax = request.getParameter("surface.max");
			String pProprioNom = request.getParameter("proprio.nom");
			
			List<Terrain> terrains = bll.findByCriteria(pSurfaceMin, pSurfaceMax, pProprioNom);
			request.setAttribute("listeTerrains", terrains);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
