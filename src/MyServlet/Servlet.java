package MyServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.io.IOException;

public class Servlet {
    @WebServlet(name = "Servlet")
    public class Servlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) {
            response.setContentType("text/html");

            String fname =request.getParameter("fname");
            String lname =request.getParameter("lname");
            String Male =request.getParameter("Male");
            String Female =request.getParameter("Female");
            String City =request.getParameter("City");
            String Country =request.getParameter("Country");
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }
}
