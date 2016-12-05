<html>
<head>
    <title>message</title>
</head>
<body>
    welcome,${userDemo.userName},${userDemo.id}
<br/>
    <form action="/users/tologout" method="post">
        <input value="${userDemo.id}" type="text">
        <input type="submit" value="登出"/>
    </form>
</body>

</html>