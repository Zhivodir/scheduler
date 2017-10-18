<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Мои мечты</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/pickmeup.css" rel="stylesheet">
    <link href="css/forTree.css" rel="stylesheet">
    <link href="css/content.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<sec:authorize access="isAuthenticated()">
    <c:set var="dreams" value="${purposes}" scope="request"/>
    <c:import url="parts_of_page/forPurposes/navbar.jsp"/>
    <c:import url="parts_of_page/forPurposes/content_space.jsp"/>
    <c:import url="/WEB-INF/pages/modal/createNewTask.jsp"/>
    <c:import url="/WEB-INF/pages/modal/createNewDream.jsp"/>
    <c:import url="/WEB-INF/pages/modal/createNewPurpose.jsp"/>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/createNewTask.js"></script>
    <script src="js/pickmeup.js"></script>
    <script src="js/pickmeup_config.js"></script>
    <script src="js/other.js"></script>
    <script src="js/treeForNewTask.js"></script>
    <script src="js/treeForContent.js"></script>

</sec:authorize>
</body>
</html>
