<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
    <head>
        <title>View Cart</title>
    </head>
    <body>
        <a href="<c:url value="/cart/emptycart" />">Empty Cart</a>
        <h1>View Cart</h1>
        
        <%
            @SuppressWarnings("unchecked")
            Map<String, Integer> cart =
                   (Map<String, Integer>) session.getAttribute("cart");

            if (cart == null || cart.size() == 0) { %>
                Your cart is empty
        <%  } else { %>
            <ul>
            <% for (String id: cart.keySet()) { %>
                <li>Item Name: <%=id%>(qty:<%=cart.get(id)%>) </li>
            <% } %>
            </ul>
            <% } %><br /> 
        <a href="<c:url value="/" />">Return to main page</a><br/><br/>
        <a href="<c:url value="/ticket/payment" />">Pay the Bill</a>
    </body>
</html>
