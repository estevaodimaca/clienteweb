package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.model.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/clienteServlet", "/clienteController" })
public class ClienteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -95323411224845978L;

	List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteServlet() {
		System.out.println("Iniciando o ClienteServlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando ----- init()");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Chamando o Service");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Chamou pelo método GET");
		RequestDispatcher dispatcher = req.getRequestDispatcher("cliente.jsp");
		
		req.setAttribute("clientes", clientes);
		
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// recebendo email
		String email = req.getParameter("email");

		// colocando email em um objecto cliente
		Cliente cliente = new Cliente();
		cliente.setEmail(email);

		// adicionando cliente na lista
		clientes.add(cliente);

		System.out.println("Chamou pelo método POST");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print(
				"Chamou pelo método POST enviando email: " + email);

	}

	@Override
	public void destroy() {
		System.out.println("destroy...");
		super.destroy();
	}
}
