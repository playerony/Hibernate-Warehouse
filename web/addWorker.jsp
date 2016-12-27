<%-- 
    Document   : AddWorker
    Created on : 2016-12-18, 19:34:16
    Author     : pawel_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Worker Panel</title>
    </head>
    <body>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
         </s:if>
        
        <s:form action="add">
            <s:textfield name="user.login" label="Login(Max 10 length)"/>
            <s:password name="user.password" label="Password(Max 10 length)"/>
            <s:textfield name="user.firstname" label="Firstname"/>
            <s:textfield name="user.lastname" label="Lastname"/>
            <s:select name="user.place" list="{'Gliwice', 'Zabrze'}" emptyOption="false" label="Select place"/>
            <s:select name="user.rank" list="{'Admin', 'Worker'}" emptyOption="false" label="Select rank"/>

            <s:submit value="Add Worker"/>
        </s:form>
    </body>
</html>
