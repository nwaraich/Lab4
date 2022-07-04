

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Edit Note</h1>
        <form method = "Post" action = "note">
            <label>Title:</label>
            <input type="text" name ="t_title" value = "${note.title}">
            <br>
            <label>Contents:</label>
            <input type="text" name ="c_contents" value="${note.contents}">
            <br>
            <input type ="submit"  name ="s_save" value="Save">
            
            
        </form>
    </body>
</html>
