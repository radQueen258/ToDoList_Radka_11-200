<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
<form action="/login" method="post">
    <div class = "imgcontainer">
        <img src="/images/LoginAvatar.webp" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="?">password</a>?</span>
        <br>
        <span class="noacc">Don't have <a href="/jsp/SignUpPage.jsp">an account</a>?</span>
    </div>
</form>
</body>
</html>