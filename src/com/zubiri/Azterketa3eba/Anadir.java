package com.zubiri.Azterketa3eba;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Anadir
 */
public class Anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","zubiri");
		    Statement stm = conn.createStatement();
		    
			stm.executeUpdate("CREATE DATABASE IF NOT EXISTS matriculas");
			
			stm.executeUpdate("USE matriculas");
			
			stm.executeUpdate("CREATE TABLE IF NOT EXISTS matriculas ("
					+ "dni varchar(20) PRIMARY KEY,"
					+ "nombre varchar(20),"
					+ "apellido varchar(20),"
					+ "nacimiento varchar(20))");
			
			String dni = request.getParameter("dni");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String nacimiento = request.getParameter("ano");
			
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Azterketa</title><meta charset='utf8'/></head><body>");
			out.println("<table>");
			out.println("<tr><td>DNI:</td><td>"+dni+"</td></tr>");
			out.println("<tr><td>Nombre:</td><td>"+nombre+"</td></tr>");
			out.println("<tr><td>Apellido:</td><td>"+apellido+"</td></tr>");
			out.println("<tr><td>Año nacimiento:</td><td>"+nacimiento+"</td></tr>");
			out.println("</table>");
			out.println("</body></html>");
			
			stm.executeUpdate("INSERT INTO matriculas VALUES ('"+dni+"','"+nombre+"','"+apellido+"','"+nacimiento+"')");
			
			out.println("<a href='index.html'>Volver</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
