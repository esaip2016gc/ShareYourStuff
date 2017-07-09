<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Share Your Stuff | Register</title>

        <!-- Custom styles for this template -->
        <link type="text/css" rel="stylesheet" href="<c:url value="css/signin.css" />" />

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">
    </head>
<body>

<div class="container">

    <form class="form-signin" method="POST" action="/register">
        <h2 class="form-signin-heading">Please sign up</h2>

        <div class="form-control">
            <label for="inputUsername" class="sr-only">Username</label>
            <input type="text" name="inputUsername" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        </div>

        <div class="form-control">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required>
        </div>

        <div class="form-control">
            <label for="inputFirstname" class="sr-only">Firstname</label>
            <input type="text" name="inputFirstname" id="inputFirstname" class="form-control" placeholder="Firstname" required>
        </div>

        <div class="form-control">
            <label for="inputLastname" class="sr-only">Lastname</label>
            <input type="text" name="inputLastname" id="inputLastname" class="form-control" placeholder="Lastname" required>
        </div>

        <div class="form-control">
            <label for="inputAge" class="sr-only">Age</label>
            <input type="number" name="inputAge" id="inputAge" class="form-control" placeholder="Age" required>
        </div>

        <div class="form-control">
            <label for="inputTel" class="sr-only">Phone number</label>
            <input type="text" name="inputTel" id="inputTel" class="form-control" placeholder="Phone number" required>
        </div>

        <div class="form-control">
            <label for="inputMail" class="sr-only">Mail</label>
            <input type="text" name="inputMail" id="inputMail" class="form-control" placeholder="Mail" required>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    </form>

</div> <!-- /container -->

    <script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</body>
</html>
