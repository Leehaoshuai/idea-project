<%--
  Created by IntelliJ IDEA.
  User: Leehao
  Date: 2022/9/14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>

  <form action="${pageContext.request.contextPath}/download" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="download">
  </form>

  <a href="${pageContext.request.contextPath}/static/1.png">下载图片</a>

  </body>
</html>
