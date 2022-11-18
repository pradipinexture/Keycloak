<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Login Page in HTML with CSS Code Example</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"><link rel="stylesheet" href="./style.css">
<link href="${url.resourcesPath}/css/style.css" rel="stylesheet" />
</head>
<body>
<!-- partial:index.partial.html -->
<div class="box-form">
	<div class="left">
		<div class="overlay">
            <h1>Hello World.</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Curabitur et est sed felis aliquet sollicitudin</p>
            <span>
                <p>login with social media</p>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i> Login with Twitter</a>
            </span>
		</div>
	</div>
		<div class="right">
            <h5>Login</h5>
            <p>Don't have an account? <a href="#">Creat Your Account</a> it takes less than a minute</p>
               <form id="kc-form-login" class="inputs" onsubmit="return true;" action="${url.loginAction}" method="post">

               
                    <input id="username" class="login-field" placeholder="${msg("username")}" type="text" name="username" tabindex="1">
                    <input id="password" class="login-field" placeholder="${msg("password")}" type="password" name="password" tabindex="2">
                    <input class="Login" type="submit" value="${msg("doLogIn")}" tabindex="3">
                </form>
		</div>
	</div>

</div>
<!-- partial -->

</body>
</html>