package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import bean.SinhVien;
import conn.DBConnection;
import utils.DBUtils;


/**
 * Servlet implementation class DeleteSinhVienServlet
 */
@WebServlet(urlPatterns = { "/deleteSinhVien" })
public class DeleteSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSinhVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		Connection conn = null;
		try
		{
			conn = DBConnection.getConnection();
			
		} catch (ClassNotFoundException |  SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
        String idStr = (String) request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }
        SinhVien sv = null;
 
        String errorString = null;
 
        try {
            DBUtils.deleteSinhVien(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
  
        response.sendRedirect(request.getContextPath() + "/sinhvienList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
