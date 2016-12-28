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
        <s:form method="post" action="addWorker.jsp">
            <s:submit value="1. Add Worker"/>
        </s:form>
        
        <s:form method="post" action="deleteWorker.jsp">
            <s:submit value="2. Delete Worker"/>
        </s:form>
        
        <s:form method="post" action="pickingCheckOrderNumber.jsp">
            <s:submit value="3. Picking"/>
        </s:form>
            
        <s:form method="post" action="packingMenu.jsp">
            <s:submit value="4. Packing"/>
        </s:form>
	
        <s:form method="post" action="logout">
            <s:submit value="5. Logout"/>
        </s:form>
    </body>
</html>
