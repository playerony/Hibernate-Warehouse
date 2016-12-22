<%-- 
    Document   : pickingMenu
    Created on : 2016-12-20, 15:13:57
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Picking menu page</title>
    </head>
    <body>
         <s:form action="pickMenu">
            <s:textfield name="palleteInfo.id" label="Product id"/>
            <s:textfield name="palleteInfo.amount" label="Amount"/>
            <s:textfield name="palletsInMagazine.location" label="Location"/>
            
            <s:submit value="Add another item"/>
        </s:form>
        
        <s:form action="finishPick">
            <s:submit value="Finish"/>
        </s:form>
        
        <s:form action="backPick">
            <s:submit value="Back"/>
        </s:form>
    </body>
</html>
