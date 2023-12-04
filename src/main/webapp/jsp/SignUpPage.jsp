<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign Up Page</title>
  <link rel="stylesheet" type="text/css" href="/css/signup.css">
</head>
<body>
<form action="/signUp" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to  create an account.</p>
    <hr>

    <label><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label><b>Nickname</b></label>
    <input type="text" placeholder="Enter Nickname" name="nickname" required>


    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    <p>By creating an account you agree to our <a href="?" style="color:dodgerblue">Terms & Privacy</a>. </p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
      <br>
      <span class="acc">Already have <a href="/jsp/LoginPage.jsp">an account</a>?</span>
    </div>
  </div>
</form>
</body>
</html>