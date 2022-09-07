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
<security:authorize access="hasRole('ADMIN')">  
<h2>Update a User :${user.username}</h2>
</security:authorize>

<security:authorize access="hasRole('USER')">  
<h2>${user.username}'s Personal Information</h2>
</security:authorize>

<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="UserForm">
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
    <input type="submit" value="Save"/><br/><br/>
</form:form>
     <a href="<c:url value="/" />">Return to main page</a>
</body>
</html>