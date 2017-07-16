<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Share Your Stuff | Sell</title>

    <link type="text/css" rel="stylesheet" href="<c:url value="css/signin.css" />"/>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- <a class="navbar-brand" href="#">SHARE YOUR STUFF</a> -->
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">HOME</a></li>
                <c:choose>
                    <c:when test="${sessionScope.get('username') != null}">
                        <li><a href="/sell">Sell a stuff</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <c:choose>
                    <c:when test="${sessionScope.get('username') == null}">
                        <li><a href="/login">LOGIN</a></li>
                        <li><a href="/register">REGISTER</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a>WELCOME ${sessionScope.get('username')}</a></li>
                        <li><a href="/logout">LOGOUT</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="wrapper">
        <form class="form-signin" method="POST" action="/sell">
            <h3 class="form-signin-heading">Describe your product</h3>
            <hr class="colorgraph">
            <br>

            <label for="inputName" class="sr-only">Name</label>
            <input type="text" name="inputName" id="inputName" class="form-control" placeholder="Product's name"
                   required="" autofocus="">

            <label for="inputProductType" class="sr-only">Type of product</label>
            <select name="inputProductType" id="inputProductType" class="form-control">
                <c:forEach var = "i" begin = "0" end = "${objectTypeList.size()-1}">
                    <option value="${objectTypeList.get(i).getId()}">${objectTypeList.get(i).getName()}</option>
                </c:forEach>
            </select>

            <label for="inputComment" class="sr-only">Comment</label>
            <textarea name="inputName" id="inputComment" class="form-control" placeholder="Comment"
                      required="" autofocus=""></textarea>

            <label for="inputPrice" class="sr-only">Price</label>
            <input type="number" name="inputName" id="inputPrice" class="form-control" placeholder="Price"
                   required="" autofocus="">

            <br>
            <button class="btn btn-primary btn-block" type="submit">Sell your product</button>
        </form>
    </div>
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
