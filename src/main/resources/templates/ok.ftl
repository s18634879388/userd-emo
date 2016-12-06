<html>
<head>
    <title>message</title>
</head>
<body>
    welcome,${userDemo.userName}
<br/>
    <form action="/users/tologout" method="post">
        <input value="${userDemo.id}" name="id" type="hidden">
        <input type="submit" value="登出"/>
    </form>
</body>

</html>