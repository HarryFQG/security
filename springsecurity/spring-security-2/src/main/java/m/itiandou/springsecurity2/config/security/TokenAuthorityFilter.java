package m.itiandou.springsecurity2.config.security;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author fengqigui
 * @description 自定义的Filter
 * @date 2018/05/02 10:59
 */
@Component
public class TokenAuthorityFilter extends GenericFilterBean {

    private static String token = "123456";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        final String accessToken = httpRequest.getHeader("token");

        chain.doFilter(request,response);

    }



}
