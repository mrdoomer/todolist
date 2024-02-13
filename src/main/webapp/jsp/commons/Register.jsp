<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Registration</title>
  <jsp:include page="../commons/jscss.jsp" />
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f9f9f9;
    }
    .container {
      max-width: 500px;
      margin: 50px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 20px rgba(0,0,0,0.1);
    }
    h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }
    input[type="text"], input[type="email"], input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 8px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }
    input[type="submit"] {
      width: 100%;
      padding: 12px;
      margin-top: 20px;
      border: none;
      border-radius: 4px;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    .fa {
      margin-right: 5px;
    }
    .social-login {
      display: flex;
      justify-content: center;
      margin-top: 20px;
    }
    .social-login button {
      width: 40px;
      height: 40px;
      margin: 0 5px;
      border: none;
      border-radius: 50%;
      background-color: #3b5998;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .social-login button:hover {
      background-color: #2d4373;
    }
  </style>
</head>
<body>

<div class="container">
  <h2>User Registration</h2>
  	<jsp:include page="../commons/Messages.jsp" />
  
  <form action="saveUser" method="post">
    <input type="text" name="username" placeholder="Username" required>
    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" required>
    <input type="password" name="confirm_password" placeholder="Confirm Password" required>
    <input type="submit" value="Register">
  </form>
</div>

</body>
</html>
