<%--
  Created by IntelliJ IDEA.
  User: ajita
  Date: 6/12/17
  Time: 2:34 AM
--%>
<%--
  Created by IntelliJ IDEA.
  User: ajita
  Date: 29/8/17
  Time: 1:32 AM
--%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Aisect</title>
    <asset:stylesheet href="bootstrap.css"/>
    <asset:stylesheet href="bootstrap.min.css"/>
    <asset:stylesheet href="flexslider.css"/>
    <asset:stylesheet href="main.css"/>
    <asset:stylesheet href="responsive.css"/>
    <asset:stylesheet href="animate.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

</head>

<body>

<!-- Header Section -->
<section class="tophead" role="tophead">
    <!-- Navigation Section -->
    <header id="header">
        <div class="header-content clearfix"> <a class="logo" href="#">Auro</a>
            <nav class="navigation" role="navigation">
                <ul class="primary-nav">
                    <li><a href="../index/#header-slider">Home</a></li>
                    <li><a href="../index/#services">Our Services</a></li>
                    <li><a href="../index/#testimonials">Testimonials</a></li>
                    <li><a href="../index/#contact">Contact</a></li>
                    <li><g:link controller="autherisation" action="logout">Logout</g:link></li>
                </ul>
            </nav>
            <a href="#" class="nav-toggle">Menu<span></span></a> </div>
    </header>
    <!-- Navigation Section -->
</section>
<!-- Header Section -->


<!-------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------->
<div class="container">
    <div class="row">
        <h2>Update Alert</h2>
        <g:uploadForm action="updatealert" method="post"  id="${alert.id}">
            <div class="form-group">
                <label>Title:</label>
                <input type="text" class="form-control" name="title" value="${alert.title}" required autofocus/>
            </div>
            <div class="form-group">
                <label>Description/Content:</label>
                <textarea class="form-control" rows="8" name="content">${alert.content}</textarea>
            </div>
            <div class="form-group">
                <label>Upload an image or file:</label>
                <input type="file" name="file">
            </div>
            <div class="form-group">
                <input type="submit" class="btn-primary btn" value="Update"/><a href="#" onclick="javascript:window.history.back();"><div class="btn btn-default">Back</div> </a>
            </div>
        </g:uploadForm>
    </div>
</div>






<!-- Testimonials section -->
<section id="testimonials" class="section testimonials no-padding">
    <div class="container-fluid">
        <div class="row no-gutter">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <div class="col-md-12">
                            <blockquote>
                                <h1>"Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Donec sed odio dui. Phasellus non dolor nibh. Nullam elementum Aenean eu leo quam..." </h1>
                                <p>Rene Brown, Open Window production</p>
                            </blockquote>
                        </div>
                    </li>
                    <li>
                        <div class="col-md-12">
                            <blockquote>
                                <h1>"Cras dictum tellus dui, vitae sollicitudin ipsum. Phasellus non dolor nibh. Nullam elementum tellus pretium feugiat shasellus non dolor nibh. Nullam elementum tellus pretium feugiat." </h1>
                                <p>Brain Rice, Lexix Private Limited.</p>
                            </blockquote>
                        </div>
                    </li>
                    <li>
                        <div class="col-md-12">
                            <blockquote>
                                <h1>"Cras mattis consectetur purus sit amet fermentum. Donec sed odio dui. Aenean lacinia bibendum nulla sed consectetur...." </h1>
                                <p>Andi Simond, Global Corporate Inc</p>
                            </blockquote>
                        </div>
                    </li>
                    <li>
                        <div class="col-md-12">
                            <blockquote>
                                <h1>"Lorem ipsum dolor sit amet, consectetur adipiscing elitPhasellus non dolor nibh. Nullam elementum tellus pretium feugiat. Cras dictum tellus dui sollcitudin." </h1>
                                <p>Kristy Gabbor, Martix Media</p>
                            </blockquote>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- Testimonials section -->

<!-- footer section -->
<footer id="contact" class="footer">
    <div class="container-fluid">
        <div class="col-md-2 left">
            <h4>Office Location</h4>
            <p> Bhilai</p>
        </div>
        <div class="col-md-2 left">
            <h4>Contact</h4>
            <p> Call: 0788-2326262 <br>
                Email : <a href="John@doe.com"> John@doe.com </a></p>
        </div>
        <div class="col-md-2 left">
            <h4>Social presense</h4>
            <ul class="footer-share">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
            </ul>
        </div>
        <div class="col-md-6 right">
            <p>© 2017 All rights reserved.<br>
                Made by <a href="http://www.sevenar.in/">SevenarLOGO</a></p>
        </div>
    </div>
</footer>
<!-- footer section -->
<!-- JS FILES -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="jquery.flexslider-min.js"/>
<asset:javascript src="retina.min.js"/>
<asset:javascript src="modernizr.js"/>
<asset:javascript src="main.js"/>

</body>
</html>
