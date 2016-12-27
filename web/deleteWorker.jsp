<%-- 
    Document   : DeleteWorker
    Created on : 2016-12-19, 21:37:00
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Worker Panel</title>
    </head>
    <body>
        <s:form action="delete">
            <s:textfield name="user.firstname" label="Firstname"/>
            <s:textfield name="user.lastname" label="Lastname"/>

            <s:submit value="Delete Worker"/>
        </s:form>
        
        <s:form action="backUser">
            <s:submit value="Back"/>
        </s:form>
    </body>
</html>
