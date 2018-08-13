package Servlet;

import CrudDao.Conection;
import Entity.Film;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨光儒
 * @Title: ${NAME}
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1314:13
 */

public class AddServlet extends HttpServlet {
    Conection getcon = new Conection();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String language = request.getParameter("language");
        int lg = Integer.valueOf(language);
        System.out.println("title:"+title+"\n"+"des:"+description+"\n"+language);
        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguage_id(lg);
        System.out.println(film);

        try {
            int n =getcon.add(film);
            if(n>0){
                response.sendRedirect("success.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
