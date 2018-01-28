package controllers;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daojpa.DAO;
import fachada.Fachada;
import modelo.Usuario;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Oi, tou no formulário de registrar");
		response.sendRedirect("template/register.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		HttpSession session = req.getSession(); 
		try {
			Fachada.inicializar();
			Usuario u = Fachada.cadastrarUsuario(nome,email,senha);			
			if(session.isNew()){
				session.setAttribute("userLogged", u);
			}
			res.addCookie(new Cookie("userLogged", u.getEmail()));
			Fachada.finalizar();
			res.sendRedirect("template/dashboard_2.jsp");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
