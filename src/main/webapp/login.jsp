<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>用户登录</title>
</head>
<body>
${error }
<form action="loginIn.do" method="post">
    用户名:<input type="text" name="userName" /><br />
    密&nbsp;&nbsp;码:<input type="text" name="userPwd" /><br />
    <input type="submit" value="登陆" />
</form>

</body>
</html>