<%--
  Created by IntelliJ IDEA.
  User: ajita
  Date: 24/8/17
  Time: 12:19 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Log in</title>
    <asset:stylesheet href="bootstrap.css"/>

</head>

<body style="background-color: rgba(58,86,87,0.67)">
<div class="container">
    <div class="row" style="padding-top: 15%">
        <div class="col-md-offset-4 col-md-4 panel panel-default">
            <center><h2>Login</h2></center>
            <g:if test="${flash.wrong}">
                <div class="alert-danger alert">${flash.wrong}</div>
             </g:if>
            <form action="check">
                <div class="form-group">
                    <label>User Name</label>
                    <input type="text" class="form-control" name="userName"/>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn-block btn-primary btn" value="Log in"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>