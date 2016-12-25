<%-- 
    Document   : packingMenu
    Created on : 2016-12-25, 16:15:59
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Packing menu page</title>
    </head>
    <body>
        <s:form action="pickMenu">
            <s:textfield name="palleteInfo.id" label="Product id"/>
            <s:textfield name="palleteInfo.amount" label="Amount"/>
            <s:textfield name="palletsInMagazine.location" label="Location"/>
            
            <s:submit value="Add another item"/>
        </s:form>
        
        <s:form action="finishPack">
            <s:submit value="Finish"/>
        </s:form>
        
        <s:form action="backPack">
            <s:submit value="Back"/>
        </s:form>
    </body>
</html>
