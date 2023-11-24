package Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURI();
        if ("/registration".equals(url)) {
            chain.doFilter(request, response); // Allow access to the registration page
            return;
        }

        // For other requests, continue with the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
