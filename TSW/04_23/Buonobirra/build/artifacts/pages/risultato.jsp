<!DOCTYPE html>
<%@ page import="java.util.List" %>
<html lang="it">
  <head>
    <meta charset="UTF-8" />
    <title>Le tue birre buone</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  </head>
  <body>
    <h1>Il gattino ti consiglia queste buone birre:</h1>
    <ul id="listaBirre">
      <%
        List<?> risultato = (List<?>) request.getAttribute("consigli");
        for (Object o : risultato) out.print("<li> " + o + "</li>");
      %>
    </ul>
  </body>
</html>
