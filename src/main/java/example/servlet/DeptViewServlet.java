package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.entity.Department;

@WebServlet("/DeptView")
public class DeptViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Department dept = (Department) request.getAttribute("loadedDept");

        if (dept == null) {
            response.sendRedirect("Search.html");
            return;
        }

        String html = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Department Details</title>
                <style>
                    * {
                        box-sizing: border-box;
                        margin: 0;
                        padding: 0;
                        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    }

                    body {
                        background-color: #f0f4f8;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                        padding: 20px;
                    }

                    .card {
                        background-color: #ffffff;
                        padding: 36px 32px;
                        border-radius: 12px;
                        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
                        width: 100%;
                        max-width: 400px;
                    }

                    h2 {
                        color: #1e293b;
                        font-size: 1.5rem;
                        margin-bottom: 6px;
                        text-align: center;
                    }

                    p.subtitle {
                        color: #64748b;
                        font-size: 0.9rem;
                        text-align: center;
                        margin-bottom: 24px;
                    }

                    .details {
                        background-color: #f8fafc;
                        border: 1px solid #e2e8f0;
                        border-radius: 8px;
                        padding: 16px;
                        margin-bottom: 24px;
                    }

                    .detail-row {
                        display: flex;
                        justify-content: space-between;
                        padding: 10px 0;
                        border-bottom: 1px solid #e2e8f0;
                    }

                    .detail-row:last-child {
                        border-bottom: none;
                    }

                    .label {
                        font-size: 0.9rem;
                        font-weight: 600;
                        color: #64748b;
                    }

                    .value {
                        font-size: 0.95rem;
                        font-weight: 600;
                        color: #0f172a;
                    }

                    .btn {
                        display: block;
                        width: 100%;
                        padding: 12px;
                        background-color: #2563eb;
                        color: #ffffff;
                        text-align: center;
                        text-decoration: none;
                        border-radius: 8px;
                        font-size: 1rem;
                        font-weight: 600;
                        transition: background-color 0.2s;
                    }

                    .btn:hover {
                        background-color: #1d4ed8;
                    }
                </style>
            </head>
            <body>
                <div class="card">
                    <h2>Department Details</h2>
                    <p class="subtitle">Record found in database</p>
                    <div class="details">
                        <div class="detail-row">
                            <span class="label">Department No</span>
                            <span class="value">{{DEPT_NO}}</span>
                        </div>
                        <div class="detail-row">
                            <span class="label">Name</span>
                            <span class="value">{{DEPT_NAME}}</span>
                        </div>
                        <div class="detail-row">
                            <span class="label">Location</span>
                            <span class="value">{{DEPT_LOC}}</span>
                        </div>
                    </div>
                    <a href="Search.html" class="btn">Search Another</a>
                </div>
            </body>
            </html>
            """
            .replace("{{DEPT_NO}}", String.valueOf(dept.getDeptNo()))
            .replace("{{DEPT_NAME}}", dept.getName())
            .replace("{{DEPT_LOC}}", dept.getLocation());

        out.println(html);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}