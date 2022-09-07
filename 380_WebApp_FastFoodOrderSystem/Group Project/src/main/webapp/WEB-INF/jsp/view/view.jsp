<!DOCTYPE html>
<html>
    <head>
        <title>Customer Support</title>
    </head>
    <body>
        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Item #${ticket.id}: <c:out value="${ticket.subject}" /></h2>
        <security:authorize access="hasRole('ADMIN') or principal.username=='${ticket.customerName}'">
            [<a href="<c:url value="/ticket/edit/${ticket.id}" />">Edit</a>]
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            [<a href="<c:url value="/ticket/delete/${ticket.id}" />">Delete</a>]
        </security:authorize>
        <br /><br />
            Item Name:
            <a href="<c:url value="/ticket/view/${ticket.id}" />">
                <c:out value="${ticket.subject}" /></a>
                Description:
                <c:out value="${ticket.body}" /></a><br/>
                Price:
                <c:out value="${ticket.price}" /></a><br/>
                Availability:
                <c:out value="${ticket.quantity}" /></a>
            Attachments:
            <c:forEach items="${ticket.attachments}" var="attachment"
                       varStatus="status">
                <c:if test="${!status.first}">, 
                <a href="<c:url value="/ticket/${ticket.id}/attachment/${attachment.name}" />">
                    <c:out value="${attachment.name}" /></a>
                   <img src="/Lab09/ticket/${ticket.id}/attachment/${attachment.name}" width="400" height="300"/>
                    </c:if>
            </c:forEach><br /><br />
            <hr> Comment:<br/>
            <c:if test="${fn:length(comment)==0}"> No Comment!</c:if>
                    <c:forEach items="${comment}" var="comment">
                        <c:out value="${comment.username}"></c:out> :
                        <c:out value="${comment.comment}"></c:out><br/>
                        
                    </c:forEach> 
               
           
            
            <a href="<c:url value="/addcart/${ticket.id}" />"> Add to cart </a><br />
             <a href="<c:url value="/ticket/addcomment/${ticket.id}" />">Add comment</a><br />

        <a href="<c:url value="/" />">Return to main page</a>
    </body>
</html>