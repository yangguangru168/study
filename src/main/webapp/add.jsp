<%--
  Created by IntelliJ IDEA.
  User: 杨光儒
  Date: 2018/8/13
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<center><h3>添加界面</h3></center>
<body>

<table style="position: absolute;width: 40%;left: 20%;top: 100px;"border="solid 1px"/>
    <form action="addServlet" method="post">

        <tbody>
        <tr>
            <td>标题:<input type="text" name="title"></td>
            <td>描述:<input type="text" name="description"></td>
            <td>
                语言:<select name="language">
                <option value="1">English</option>
                <option value="2">china</option>
                <option value="3">jpan</option>
                <option value="4">french</option>
                <option value="5">russian</option>
            </select>
            </td>
        </tr>
            <button style="margin-top: 54px;margin-left: 830px" type="submit">添加</button>
        </tbody>
    </form>
</body>
</html>