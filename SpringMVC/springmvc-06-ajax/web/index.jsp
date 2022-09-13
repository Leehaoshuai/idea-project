<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.1.js"></script>

    <%--js 是一个随便的语言--%>
    <script>function a() {
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{"name":$("#username").val()},
        success:function (data,status){
          console.log(data);
          console.log(status);
        }
      })
    }
    </script>

  </head>
  <body>
  <%--失去焦点后，发起一个请求(携带信息)到后台--%>
  用户名：<input type="text" id="username" onblur="a()">
  </body>
</html>
