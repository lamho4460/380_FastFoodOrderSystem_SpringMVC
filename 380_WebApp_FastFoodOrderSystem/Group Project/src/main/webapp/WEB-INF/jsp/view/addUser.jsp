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

<h2>Create a User</h2>
<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="ticketUser">
    <form:label path="username">Username</form:label><br/>
    <form:input type="text" path="username" /><br/><br/>
    <form:label path="password">Password</form:label><br/>
    <form:input type="text" path="password" /><br/><br/>
    <form:label path="fullname">Full Name</form:label><br/>
    <form:input type="text" path="fullname" /><br/><br/>
    <form:label path="phonenumber">Phone Number</form:label><br/>
    <form:input type="tel" path="phonenumber" /><br/><br/>
    <form:label path="deliveraddress">Deliver Address</form:label><br/>
    <form:input type="text" path="deliveraddress" /><br/><br/>
    <form:label path="roles">Roles</form:label><br/>
    
    <form:checkbox path="roles" value="ROLE_USER" />ROLE_USER
    <security:authorize access="hasRole('ADMIN')">   
    <form:checkbox path="roles" value="ROLE_ADMIN" />ROLE_ADMIN
     </security:authorize>
    <br /><br />
    <input type="submit" value="Add User"/>
</form:form>
</body>
</html>
