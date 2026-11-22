package example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.dao.AppDao;
import example.dao.DepartmentDao;
import example.entity.Department;

@WebServlet(name = "deptSearchServlet", urlPatterns = { "/deptSearch" })
public class deptSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String dept_no = request.getParameter("dept_no");
        int deptNo = Integer.parseInt(dept_no);

        AppDao<Department, Integer> daoRef = new DepartmentDao();
        Department searchedDept = daoRef.getById(deptNo);
        RequestDispatcher dispatcher = null;
        if (searchedDept == null) {
            out.println("<h1>Department not found!!! Try again</h1>");
            dispatcher = request.getRequestDispatcher("Search.html");
            dispatcher.include(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("DeptView"); // Matches @WebServlet("/DeptView")
            request.setAttribute("loadedDept", searchedDept);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}