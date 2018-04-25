package pers.hdh;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CrosFilter class<br/>
 *
 * @author hdonghong
 * @date 2018/04/18
 */
public class CrosFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.addHeader("Access-Control-Allow-Origin", "*");
        // origin为*是否能满足所有场景呢？
        response.addHeader("Access-Control-Allow-Methods", "*");

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
