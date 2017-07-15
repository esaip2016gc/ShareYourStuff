<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Share Your Stuff</title>

    <!-- Custom styles for this template -->
    <link type="text/css" rel="stylesheet" href="<c:url value="css/index.css" />"/>

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


<div class="container" style="padding-top: 15px">
    <div class="row">
        <div class="col-md-12">
            <h1>Bootstrap starter template</h1>
            <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text
                and a mostly barebones HTML document.</p>
        </div>
    </div>

</div><!-- /.container -->

<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
