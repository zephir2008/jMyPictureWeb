package jpic.web.svc;

import java.io.IOException;
import java.io.PrintWriter;

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
			name="param1",
			value="maValeurInit"
		)}
)
public class Ping extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String auteur;
    
//    private static PrintWriter writeln( HttpServletRequest request, HttpServletResponse response ) throws IOException {
//		return response.getWriter().append("Served at: ").append(request.getContextPath());
//    }
// 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ping() {
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
    	System.out.println();
    	super.destroy();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println( "GET !!!" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println( "POST !!!" );
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println( "PUT !!!" );
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// writeln( request, response, "OPTIONS !!!"+"<br>"+auteur );
		System.out.println( "OPTIONS !!!" );
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
