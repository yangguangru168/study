package login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杨光儒
 * @Title: LoginFilter
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1015:38
 */
public class LoginFilter implements Filter {
    public static final String login_page = "/index.jsp";
    public static final String error_page = "/error.jsp";
    public void  destroy(){}
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*StringBuffer path = request.getRequestURL();
        System.out.println(path+"   a");
        String s = path.substring(path.lastIndexOf("/")+1);
        System.out.println(s+"   b");
        if ("index.jsp".equals(s) || "login".equals(s)){
            chain.doFilter(request,response);
            return;
        }
        Object u = request.getSession().getAttribute("username");
        System.out.println(u+"   c");
        if (u==null){
            response.sendRedirect("index.jsp");
            return;
        }
        chain.doFilter(request,response);*/
        String currentURL = request.getRequestURI();
        System.out.println("currentURL=="+currentURL);
        String ctxPath = request.getContextPath();
        System.out.println("ctxPath??"+ctxPath);
        String targetURL = currentURL.substring(ctxPath.length());
        System.out.println("targetURL++"+targetURL);
        //Object u = request.getSession().getAttribute("username");
        //System.out.println(u+" >>>");
        if (!("/index.jsp".equals(targetURL))) {
            System.out.println("1" + targetURL + "ctxPath:" + ctxPath + "currentURL:" + currentURL);
            if ((request.getSession().getAttribute("username")) == null) {
                response.sendRedirect("/index.jsp");
                return;
            } else {
                chain.doFilter(request, response);
                System.out.println("结束了？");
                return;
            }
        } else {
            System.out.println("访问正确");
            chain.doFilter(request, response);
            return;
        }
    }
    public void init(FilterConfig filterConfig)throws ServletException{

    }
}
