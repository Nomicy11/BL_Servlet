<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        /* Global Styles */
        body {
            font-family: 'Poppins', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            text-align: center;
        }

        /* Card Container */
        .container {
            background: rgba(255, 255, 255, 0.15);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
            backdrop-filter: blur(10px);
            animation: fadeIn 0.8s ease-in-out;
        }

        /* Animations */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        /* Welcome Message */
        h2 {
            font-size: 24px;
            margin-bottom: 10px;
        }

        p {
            font-size: 16px;
            margin-bottom: 20px;
        }

        /* Button */
        button {
            background: linear-gradient(135deg, #ff7eb3, #ff758c);
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            font-size: 18px;
            cursor: pointer;
            transition: 0.3s ease;
        }

        button:hover {
            background: linear-gradient(135deg, #ff758c, #ff7eb3);
        }

        /* Logout Button */
        .logout-form {
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Welcome, <%= request.getAttribute("user") != null ? request.getAttribute("user") : "Guest" %>! 🎉</h2>
        <p>You have successfully logged in.</p>

        <!-- Logout button -->
        <form action="login.html" method="get" class="logout-form">
            <button type="submit">Logout</button>
        </form>
    </div>

</body>
</html>
