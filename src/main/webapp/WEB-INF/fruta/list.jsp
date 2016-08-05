<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>List</title>
    </head>
    <body>
        <h1>Exemplo Teste de Software</h1>
        <jsp:include page="/WEB-INF/fruta/_insert_form.jsp"></jsp:include>
        <ul>
            <c:forEach items="${list}" var="cidade">
                <li>${cidade}</li>
            </c:forEach>
        </ul>
    </body>
</html>
