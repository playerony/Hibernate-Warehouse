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
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        
        <s:form action="packMenu">
            <s:textfield name="palletsPicked.id" label="Pallete id"/>
            <s:textfield name="palleteInfo.id" label="Product id"/>
            <s:textfield name="palleteInfo.amount" label="Amount"/>
            
            <s:submit value="Pack"/>
        </s:form>
        
        <s:form action="finishPack">
            <s:submit value="Finish"/>
        </s:form>
        
        <s:form action="backPack">
            <s:submit value="Back"/>
        </s:form>
    </body>
</html>
