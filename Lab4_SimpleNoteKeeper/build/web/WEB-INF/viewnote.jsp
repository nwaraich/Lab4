

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>View Note</h1>
        <h2>Title:</h2>
        <p>${note.title}</p>
        <br>
        <h2>Contents:</h2>
        <p>${note.contents}</p>
        <br>
        <a href="note?edit">edit</a>
    </body>
</html>
