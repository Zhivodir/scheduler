<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <div class="row" style="margin-top: 50px;">
        <div class="col-sm-8 col-md-5"></div>
        <div class="col-sm-2 col-md-2">
            <h4 class="sub-header">${currentDate}</h4>
        </div>
        <div class="col-sm-8 col-md-5"></div>
    </div>
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="container-fluid">
                <div class="row">
                    <div class="single left_side" id="left_side"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-md-10 main">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Время</th>
                            <th>Краткое содержание</th>
                            <th>Приоритет</th>
                            <th>Вып./Нет</th>
                            <th>Header</th>
                        </tr>
                    </thead>
                    <tbody id="content">
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td>${task.id}</td>
                            <td>${task.description}</td>
                            <td>ipsum</td>
                            <td>dolor</td>
                            <td>sit</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>