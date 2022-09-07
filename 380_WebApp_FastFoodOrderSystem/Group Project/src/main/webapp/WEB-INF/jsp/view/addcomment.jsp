<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Comment</title>
    </head>
    <body>
        <h2>Add Comment</h2>
         <form:form method="POST" enctype="multipart/form-data"
                    modelAttribute="commentForm">
        <form:textarea path="comment" rows="5" cols="30" /><br /><br />
        <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
