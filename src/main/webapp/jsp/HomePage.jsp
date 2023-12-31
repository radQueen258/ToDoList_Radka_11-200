<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/welcomePage.css">
  <title>Welcome to Our Page</title>

  <style>
    .overlay {

      height: 100%;
      width: 0;
      position: fixed;
      z-index: 1;
      left: 0;
      top: 0;
      background-color: rgba(120, 25, 74, 0.8);
      background-color: rgba(120,25,74, 1);
      overflow-x: hidden;
      transition: 0.5s;
    }

    /* Position the content inside the overlay */
    .overlay-content {
      position: relative;
      top: 25%;
      width: 100%;
      text-align: center;
      margin-top: 30px;
    }

    /* The navigation links inside the overlay */
    .overlay a {
      padding: 8px;
      text-decoration: none;
      font-size: 36px;
      color: #818181;
      display: block;
      transition: 0.3s;
    }


    .overlay a:hover, .overlay a:focus {
      color: #f1f1f1;
    }


    .overlay .closebtn {
      position: absolute;
      top: 20px;
      right: 45px;
      font-size: 60px;
    }


    @media screen and (max-height: 450px) {
      .overlay a {font-size: 20px}
      .overlay .closebtn {
        font-size: 40px;
        top: 15px;
        right: 35px;
      }
    }
  </style>


</head>
<body>

<!-- The overlay -->
<div id="myNav" class="overlay">

  <!-- Button to close the overlay navigation -->
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

  <div class="overlay-content">
    <a href="/jsp/HomePage.jsp">Home</a>
    <a href="/taskByUser">Tasks</a>
    <a href="/jsp/CreateTask.jsp">Create Task</a>
    <a href="/profile">Profile</a>
    <a href="/login" id="logoutLink">Logout</a>
  </div>

</div>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Welcome Back!</h1>
    <p class="lead">"Organizing your tasks is the key to productivity and success."</p>
  </div>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">MENU</span>

<script>
  //Function to handle the menu appearance
  function openNav() {
    document.getElementById("myNav").style.width = "100%";
  }

  function closeNav() {
    document.getElementById("myNav").style.width = "0%";
  }


</script>

</body>
</html>

