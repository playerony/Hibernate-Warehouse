<%-- 
    Document   : login
    Created on : 2016-12-14, 15:14:12
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Login panel</title>
    </head>
    <body>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
         </s:if>
        
        <s:form action="login">
            <s:textfield name="user.login" label="Login"/>
            <s:password name="user.password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>
