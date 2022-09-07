<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <c:url var="loginUrl" value="/logout"/>
        <form action="${loginUrl}" method="post">
            <input type="submit" value="Log in" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <c:url var="adduserURL" value="/user/create"/>
        <form action="${adduserURL}" method="get">
            <input type="submit" value="Register" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <security:authorize access="hasRole('ADMIN')">    
            <a href="<c:url value="/user" />">Manage User Accounts</a><br /><br />
        </security:authorize>
            
           
           <security:authorize access="isAuthenticated()">  
        <security:authentication property="principal.username" var="username"/> 
            <a href="<c:url value="/user/updateUser/${pageContext.request.userPrincipal.name}" />">personal infomation</a><br /><br />
        </security:authorize>
      <security:authorize access="hasRole('ADMIN')">
<a href="<c:url value="/ticket/create" />">Create an item</a><br /><br />
 </security:authorize>
            
        <c:choose>
            <c:when test="${fn:length(ticketDatabase)==0}">
                <i>There are no item here</i>
            </c:when>
  <c:otherwise>
             <c:forEach items="${ticketDatabase}" var="ticket">
            Ticket ${ticket.id}:
            Item Name:
            <a href="<c:url value="/ticket/view/${ticket.id}" />">
                <c:out value="${ticket.subject}" /></a>
                Description:
                <c:out value="${ticket.body}" /></a><br/>
                Price:
                <c:out value="${ticket.price}" /></a><br/>
                Availability:
                <c:out value="${ticket.quantity}" /></a>
            <security:authorize access="hasRole('ADMIN')">
                [<a href="<c:url value="/ticket/edit/${ticket.id}" />">Edit</a>]
            </security:authorize>
            <security:authorize access="hasRole('ADMIN')">            
                [<a href="<c:url value="/ticket/delete/${ticket.id}" />">Delete</a>]
            </security:authorize>
            <br /><br />
        </c:forEach>
    </c:otherwise>
        </c:choose>
             <a href="<c:url value="/cart" />">View Cart</a>
    </body>
</html>
