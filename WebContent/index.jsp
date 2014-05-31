<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  登录测试：
  <form action="LoginAction" method="post">
    Mobile:<input type="text" name="mobile"><br/>
    Password:<input type="text" name="password"><br/>
    <input type="submit" value="login">
  </form>
  
  注册第一步测试：
  <form action="Register_1_Action" method="post">
    Mobile:<input type="text" name="mobile">
    <input type="submit" value="login">
  </form>
  
  注册第二步测试：
  <form action="Register_2_Action" method="post">
    Mobile:<input type="text" name="mobile">
    Captcha:<input type="text" name="captcha">
    Password:<input type="text" name="password">
    <input type="submit" value="login">
  </form>
</body>
</html>