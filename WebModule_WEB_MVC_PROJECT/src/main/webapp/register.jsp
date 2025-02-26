<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        /* Background Styling */
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #4CAF50, #2196F3);
            font-family: Arial, sans-serif;
        }
        
        /* Login Box */
        .login-box {
            background: white;
            padding: 30px;
            text-align: center;
            border-radius: 10px;
            box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.2);
            width: 300px;
        }
        
        /* Heading */
        h2 {
            color: #333;
            font-size: 24px;
            margin-bottom: 15px;
        }
        
        /* Input Fields */
        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 8px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        
        /* Login Button */
        .btn {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #ff5722;
            color: white;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            transition: 0.3s;
            border: none;
            cursor: pointer;
        }
        
        .btn:hover {
            background-color: #e64a19;
        }
        
        /* Forgot Password Link */
        .forgot-password {
            display: block;
            margin-top: 10px;
            font-size: 14px;
            color: #555;
            text-decoration: none;
        }

        .forgot-password:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="login-box">
        <h2>Sign Up</h2>
        <p>We are excited to have you here. Register and enjoy your time!</p>
        <form action="registerServlet" method="post">
            <input type="text" name="user_name" placeholder="Enter Name" required>
            <br>
            <input type="text" name="user_email" placeholder="Enter Email" required>
            <br>
            <input type="text" name="user_password" placeholder="Enter Password" required>
            <br>
            <input type="text" name="user_contact" placeholder="Enter Contact" required>
            <br>
            <input type="text" name="user_city" placeholder="Enter City" required>
            <br>
            <input type="text" name="user_gender" placeholder="Enter Gender" required>
            <br>
            <button class="btn" type="submit">Sign Up</button>
        </form>
         <a href="login.jsp" class="btn">Login</a>
        <a href="index.html" class="btn">Home</a>
    </div>


</body>
</html>