<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="CrudDao.Conection"%>
<%@ page import="Entity.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Customer" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<% Customer c = new Conection().getall();
    System.out.println(c.getUsername());
%>
<center><p>欢迎：<%=c.getUsername()%></p></center>
<button style="margin-left: 263px;margin-top: 30px;"><a href="add.jsp">新增</a></button>
<table style="position: absolute;width: 60%;left: 20%;top: 100px;"border="1px">
    <thead>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>描述</th>
        <th>语种</th>
        <th colspan="2">操作</th>
    </tr>
    </thead>
    <tbody>
    <%List<Film> films = new Conection().getfilm();
        for (int i = 0;i < films.size();i++){
    %>
    <tr>
        <td><%=films.get(i).getFile_id()%></td>
        <td><%=films.get(i).getTitle()%></td>
        <td><%=films.get(i).getDescription()%></td>
        <td><%=films.get(i).getLanguage()%></td>
        <td><a href="/deleteServlet?id=<%=films.get(i).getFile_id()%>">删除</a></td>
        <td><a href="update.jsp?id=<%=films.get(i).getFile_id()%>">修改</a></td>
    </tr>
    <%
        }%>
    </tbody>
</table>
</body>
</html>
