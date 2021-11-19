package MyFilter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    private ServletContext context;
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);

        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
            this.context.log("Unauthorized access request");
            res.sendRedirect("Signup.html");
        }else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

        this.context = config.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }


}
