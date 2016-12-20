<%-- 
    Document   : admin
    Created on : 2016-12-14, 19:54:49
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin panel</title>
    </head>
    <body>
        <form method="post" action="addWorker.jsp">
            <input type="submit" value="1. Add Worker">
        </form>
	
        <form method="post" action="deleteWorker.jsp">
            <input type="submit" value="2. Delete Worker">
        </form>
	
        <form method="post" action="pickingCheckOrderNumber.jsp">
            <input type="submit" value="3. Picking">
        </form>
            
        <form method="post" action="PackingCheckSession">
            <input type="submit" value="4. Packing">
        </form>
	
        <form method="post" action="Logout">
            <input type="submit" value="5. Logout">
        </form>
    </body>
</html>
