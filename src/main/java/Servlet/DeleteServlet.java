package Servlet;

import CrudDao.Conection;

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
 * @date 2018/8/1315:44
 */
public class DeleteServlet extends HttpServlet {
    Conection getcon = new Conection();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String fid = request.getParameter("id");
        int id=Integer.valueOf(fid);
        try {
            int n = getcon.delect(id);
            if(n!=0){
                System.out.println("删除成功");
                response.sendRedirect("success.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
