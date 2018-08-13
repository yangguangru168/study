package Servlet;

import CrudDao.Conection;
import Entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨光儒
 * @Title: ${NAME}
 * @ProjectName projectStudy
 * @Description: TODO
 * @date 2018/8/1317:23
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    Conection gc = new Conection();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String fid=request.getParameter("fid");
        int film_id=Integer.valueOf(fid);
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String language = request.getParameter("language");
        int lg = Integer.valueOf(language);
        System.out.println("film_id:"+film_id+"\n"+"title:"+title+"\n"+"des:"+description+"\n"+language);

        Film film = new Film();
        film.setFile_id(film_id);
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguage_id(lg);
        System.out.println(film);

        try {
            int n = gc.update(film);
            if(n>0){
                response.sendRedirect("success.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
