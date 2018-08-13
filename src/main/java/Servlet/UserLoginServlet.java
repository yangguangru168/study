package Servlet;



import CrudDao.Conection;
import Entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 杨光儒
 * @Title: login
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1010:36
 */
public class UserLoginServlet extends HttpServlet {
    Conection gcon = new Conection();
    public void doPost(HttpServletRequest re, HttpServletResponse rp )
    throws  IOException, ServletException {
        re.setCharacterEncoding("utf-8");
        rp.setContentType("text/html;charset=utf-8");
        try {
            Customer customer = gcon.getall();
            System.out.println("iii"+ customer.getUsername());
            String username = re.getParameter("username");
            System.out.println("qqq"+username);
            if (username.equals(customer.getUsername())) {
                HttpSession session = re.getSession();
                session.setAttribute("username", username);
                rp.sendRedirect("/success.jsp");
            }else {
                rp.sendRedirect("/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse repm)
    throws ServletException,IOException{
    doPost(request,repm);
    }

    /*public  void getSuccess(HttpServletRequest re, HttpServletResponse rp) throws Exception {
        getconection conn = new getconection();
        List<Film> list = new ArrayList<Film>();
        Film film = conn.getfilm();
        list.add(film);
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list);
        }
    }*/
}
