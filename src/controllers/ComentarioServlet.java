package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fachada.Fachada;
import modelo.Usuario;

/**
 * Servlet implementation class ComentarioServlet
 */
@WebServlet("/comentario")
public class ComentarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Cadastrar Comentario!!");
		String idpostagem = req.getParameter("idpostagem");
		String comentario = req.getParameter("comentario");
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("userLogged"); 
		if(usuario == null) {
			res.sendRedirect("/Forum/login");
		}
		try {
			Fachada.inicializar();
			Fachada.cadastrarComentario(comentario, usuario, Integer.parseInt(idpostagem));			
			Fachada.finalizar();
			res.sendRedirect("template/forum.jsp");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
