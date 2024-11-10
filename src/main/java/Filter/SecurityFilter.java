package Filter;

import Structs.AppContext;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class SecurityFilter implements Filter {
    @Inject
    AppContext context;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        String queryString = req.getQueryString();
        String path = requestURI + "?" + queryString;

        if (context.getActiveUser() == null) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(req.getContextPath() + "/login.xhtml?redirectTo=" + path);
        } else {
            chain.doFilter(request, response);
        }
    }
}
