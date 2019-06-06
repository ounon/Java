package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetier;
import metier.ICreditMetier;

@WebServlet(name="cs", urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet{
	
	private ICreditMetier metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditMetier();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("creditModel", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//lire les donnees de la requête
		double montant = Double.parseDouble(req.getParameter("montant"));
		double taux = Double.parseDouble(req.getParameter("taux"));
		int duree = Integer.parseInt(req.getParameter("duree"));
		
		//stocker les donnees dans model
		CreditModel model = new CreditModel(montant,taux,duree);
		
		//appel couche metier
		double res = metier.calculerMensualiteCredit(montant, taux, duree);
		
		model.setMensualite(res);
		
	    // on stocke le modele dans l'objet request
		req.setAttribute("creditModel", model);
		
		// on transmet à la vue
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	
	}
}
