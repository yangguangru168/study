<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="CrudDao.Conection"%>
<%@ page import="Entity.Film" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<h3>修改页面</h3>
<table style="position: absolute;width: 30%;left: 20%;top: 100px;"border="1px">
    <form action="updateServlet" method="post">
    <thead>
    <tr>
        <th>标题</th>
        <th>描述</th>
        <th>语种</th>
    </tr>
    </thead>
    <tbody>
    <%String id = request.getParameter("id");
       Film film = new Conection().getById(id);
    %>
    <tr>

        <input type="hidden"  name="fid" value="<%=film.getFile_id()%>">
        <td><input type="text" name="title" value="<%=film.getTitle()%>"></td>
        <td><input type="text" name="description" value="<%=film.getDescription()%>"></td>
        <td><input type="text" name="language" value="<%=film.getLanguage_id()%>"></td>
    </tr>

    </tbody>
        <button style="margin-left: 263px;margin-top: 26px" type="submit">更新</button>
    </form>
</table>
</body>
</html>
