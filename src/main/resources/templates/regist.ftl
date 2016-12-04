<html>

<head>
    <title>登录页面</title>
</head>
<body>
    <form action="/users/tologin" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" /> </td>
            </tr>
            <input type="submit" value="登录"/>
        </table>
    </form>
</body>

</html>