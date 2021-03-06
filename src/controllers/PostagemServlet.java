package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import daojpa.DAO;
import daojpa.DAOPostagem;
import fachada.Fachada;
import modelo.Postagem;
import modelo.Usuario;

/**
 * Servlet implementation class PostagemServlet
 */
@WebServlet(urlPatterns={"/postagem"})
public class PostagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostagemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fachada.inicializar();
		response.setContentType("text/html");
		DAOPostagem daopostagem = new DAOPostagem();
		String id = request.getParameter("id");
		if (id != null) {
			RequestDispatcher rd = request.getRequestDispatcher("template/visualizar-postagem.jsp");
			Postagem p = daopostagem.localizarPeloId(Integer.parseInt(id));
			
			if(p != null) {
				DAO.iniciar();
				System.out.println("Postagem: " + p.getTitulo());
				p.setViews(p.getViews() + 1);
				daopostagem.atualizar(p);
				System.out.println("Qtd Views: " + p.getViews());
				DAO.efetivar();
				Fachada.finalizar();
				request.setAttribute("postagem", p);
				rd.forward(request, response);
			}else {
				response.sendRedirect("/Forum/template/forum.jsp");
			}
			
//			if ("include".equalsIgnoreCase(action)) {
//				rd.include(request, response);
//			} else if ("forward".equalsIgnoreCase(action)) {
//				rd.forward(request, response);
//			}
		}else {
			response.sendRedirect("/Forum/template/forum.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Cadastrar Postagem!!");
		String titulo = req.getParameter("titulo");
		String texto = req.getParameter("texto");
		String tema = req.getParameter("tema");
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("userLogged"); 
		if(usuario == null) {
			res.sendRedirect("/Forum/login");
		}
		try {
			Fachada.inicializar();
			
			Fachada.cadastrarPostagem(titulo, texto, tema, usuario);			
			Fachada.finalizar();
			res.sendRedirect("template/forum.jsp");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
