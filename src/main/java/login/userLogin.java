package login;



import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 杨光儒
 * @Title: login
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1010:36
 */
public class userLogin extends HttpServlet {
    getconection gcon = new getconection();
    public void doPost(HttpServletRequest re, HttpServletResponse rp )
    throws  IOException, ServletException {
        re.setCharacterEncoding("utf-8");
        rp.setContentType("text/html;charset=utf-8");
        try {

            User user = gcon.getall();
            System.out.println(user.getPassword());
            String username = re.getParameter("username");

            String password = re.getParameter("pwd");
            if (username.equals(user.getUsername())) {
                if(password.equals(user.getPassword())){
                    HttpSession session = re.getSession();
                    session.setAttribute("username", username);
                    System.out.println(session);
                    System.out.println(session.getAttribute("username"));
                    rp.sendRedirect("/seccess.jsp");
                }else{
                    System.out.println("密码错误");
                    rp.sendRedirect("/error.jsp");
                }
            }else {
                rp.sendRedirect("/error.jsp");
            }
            System.out.println(username);
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse repm)
    throws ServletException,IOException{
    doPost(request,repm);
    }
}
