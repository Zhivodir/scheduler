<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <div class="row" style="margin-top: 50px; height: 39px">
        <div class="col-sm-8 col-md-5"></div>
        <div class="col-sm-2 col-md-2">
            <h4 class="sub-header"></h4>
        </div>
        <div class="col-sm-8 col-md-5"></div>
    </div>
    <div class="row">
        <div class="col-sm-4 col-md-3 sidebar">
            <div class="container-fluid">
                <div class="row">
                    <div class="single left_side" id="left_side"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-8 col-md-9 main">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Время</th>
                        <th>Краткое содержание</th>
                        <th>Приоритет</th>
                    </tr>
                    </thead>
                    <tbody id="content">
                    <c:forEach items="${purposes}" var="purposes">
                        <tr>
                            <td>${purposes.id}</td>
                            <td>${purposes.description}</td>
                            <td>ipsum</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>