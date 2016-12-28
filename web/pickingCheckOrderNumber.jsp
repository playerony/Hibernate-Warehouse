<%-- 
    Document   : pickingCheckOrderNumber
    Created on : 2016-12-20, 14:28:02
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check order number page</title>
    </head>
    <body>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
         </s:if>
        
        <s:form action="checkOrder">
            <s:textfield name="order.id" label="Order id "/>
		
            <s:submit value="Check order number"/>
        </s:form>
    </body>
</html>
