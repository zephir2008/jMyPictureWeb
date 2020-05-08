package jpic.web.svc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ping
 */
@WebServlet(
		name = "Ping"
		,value = "/Ping"
		,initParams= {@WebInitParam(
				name="param1",value="maValeurInit"
				)}
		)
public class JmyPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String auteur;
    
    private static void writeln( HttpServletRequest request, HttpServletResponse response ) throws IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JmyPicture() {
    	super();
        //System.out.println("Ping !!");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("Servlet init");
    	this.auteur = this.getInitParameter("param1");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse answer) throws ServletException, IOException {
    	System.out.println("Service call");
    	super.service( request, answer );
    }

    @Override
    public void destroy() {
    	System.out.println("Servlet quit");
    	System.out.println( this.auteur );
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println( "GET !!!" );
		writeln( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println( "POST !!!" );
		writeln( request, response );
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println( "PUT !!!" );
		writeln( request, response );
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		writeln( request, response );
		System.out.println( "OPTIONS !!!" );
	}
}
