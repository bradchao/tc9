<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<sql:query var="rs" dataSource="jdbc/brad">
select * from cust
</sql:query>

<html>
  <head>
    <title>DB Test</title>
  </head>
  <body>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
    Foo ${row.account}<br/>
    
</c:forEach>
<hr />
	WebName: <%= pageContext.getServletContext().getInitParameter("x") %>
	${initParam['WebName'] }
	

  </body>
</html>