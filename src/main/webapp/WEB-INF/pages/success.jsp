<%--
  Created by IntelliJ IDEA.
  User: lhttq
  Date: 2020/2/23
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../static/js/jquery-1.12.4.min.js"></script>
    <script>
        $(function () {
            <c:forEach items="${list}" var="l">

            var url = "${l.bsBookcover}";
              alert(url);

            </c:forEach>
        });
    </script>
</head>
<body>
 <h3>Hello World!</h3>
<%--<c:forEach items="${list}" var="l">--%>
<%--    <img src="${l.bsBookcover}" alt="">--%>
<%--    ${l.bsBookcover}--%>
<%--&lt;%&ndash;    <c:out value="${l.bsBookname}"></c:out>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:out value="${l.bsBookcover}"></c:out>&ndash;%&gt;--%>
<%--    <br/>--%>
<%--</c:forEach>--%>
</body>
</html>
