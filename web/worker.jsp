<%-- 
    Document   : worker
    Created on : 2016-12-16, 10:59:50
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker panel</title>
    </head>
    <body>
        <s:form method="post" action="pickingCheckOrderNumber.jsp">
            <s:submit value="1. Picking"/>
        </s:form>
            
        <s:form method="post" action="packingMenu.jsp">
            <s:submit value="2. Packing"/>
        </s:form>
	
        <s:form method="post" action="logout">
            <s:submit value="3. Logout"/>
        </s:form>
    </body>
</html>
