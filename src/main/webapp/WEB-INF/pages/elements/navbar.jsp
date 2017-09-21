<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-fixed-top navbar-inverse navbar-color navbar-border" role="navigation">
    <div class="container">
        <div class="navbar-header ">
            <span class="navbar-brand" href="#">Мой план</span>
        </div>
        <div class="col-sm-3"></div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Новая <b class="caret"></b></a>
                    <ul class="dropdown-menu dropdown-menu-setting">
                        <li><a href="#" class="btn btn-lg href_for_sidebar" data-toggle="modal"
                               data-target="#modalForNewDream">Мечта</a></li>
                        <li><a href="#" class="btn btn-lg href_for_sidebar" data-toggle="modal"
                               data-target="#modalForNewTarget">Цель</a></li>
                        <li><a href="#" class="btn btn-lg href_for_sidebar" data-toggle="modal"
                               data-target="#modalForNewTask">Задача</a></li>
                    </ul>
                </li>
                <li><a href="/dreams">Мечты</a></li>
                <li><a href="/targets">Цели</a></li>
                <li class="active"><a href="/">Задачи на сегодня</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</div><!-- /.navbar -->