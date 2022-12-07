package servlet;

import jakarta.servlet.RequestDispatcher;

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



@WebServlet(urlPatterns = { "/editSinhVien" })
public class EditSinhVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	 
	    public EditSinhVienServlet() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	Connection conn = null;
			try {
				conn = DBConnection.getConnection();
			} catch (ClassNotFoundException |  SQLException e1) {
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
	            sv = DBUtils.findSinhVien(conn, id);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	        if (errorString != null && sv == null) {
	            response.sendRedirect(request.getServletPath() + "/sinhvienList");
	            return;
	        }
	 	  
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("sinhvien", sv);
	 
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/editSinhVienView.jsp");
	        dispatcher.forward(request, response);
	 
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	Connection conn = null;
			try {
				conn = DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	 
	        String idStr= (String)request.getParameter("id");
	        String hoten = new String(request.getParameter("hoten").getBytes("ISO-8859-1"), "UTF-8");
	        String diachi = new String(request.getParameter("diachi").getBytes("ISO-8859-1"), "UTF-8");
	        
	        int id = 0;
	        try {
	            id = Integer.parseInt(idStr);
	        } catch (Exception e) {
	        }
	        SinhVien sv = new SinhVien(id, hoten, diachi);
	 
	        String errorString = null;
	 
	        try {
	            DBUtils.updateSinhVien(conn, sv);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("sinhvien", sv);
	
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/editSinhVienView.jsp");
	            dispatcher.forward(request, response);
	        }
	        else {
	            response.sendRedirect(request.getContextPath() + "/sinhvienList");
	        }
	    }	 
	}
