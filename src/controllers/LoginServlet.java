package controllers;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import fachada.Fachada;
import modelo.Usuario;
import util.Utilitaries;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Oi, vamo redirecionar!");
		response.sendRedirect("template/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		try {
			Fachada.inicializar();
			Usuario u = Fachada.efetuarLogin(login, Utilitaries.makeMd5(password));
			System.out.println("Usuário: " + u);
			session.setAttribute("userLogged", u);
			res.addCookie(new Cookie("userLogged", u.getLogin()));
			Fachada.finalizar();
			System.out.println("Loguei, vou redirecionar pro forum");
			res.sendRedirect("template/dashboard_2.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
	}

}
