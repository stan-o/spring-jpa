<%-- 
    Document   : home
    Created on : Oct 6, 2016, 12:06:37 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.1.0.js"></script>
        <link rel="stylesheet" type="text/css" href="http://getbootstrap.com/examples/dashboard/dashboard.css"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>
<!--        <script src="${base}/static/angular.js"></script>
        <script src="${base}/static/angularapp/app.js"></script>
        <script src="${base}/static/angularapp/controllers/home-controller.js"></script>-->
        <script type="text/javascript">
            
        </script>
        
        <style type="text/css">
            .absolute{
                position: absolute;
            }
            .main-content{
                float: right;
                width: 83%;
            }
        </style>
    </head>
    <body>
        <%@include file="common/header-nav.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <%@include file="common/left_sidebar.jsp" %>
                <div class="row">
                    <div class="main main-content">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                    <tr class="info">
                                        <th>#</th>
                                        <th>Login</th>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>email</th>
                                        <th>phone</th>
                                        <th>Group</th>
                                        <th>State</th>
                                        <th>Edit</th>
                                        <th>Remove</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${users}">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.username}</td>
                                            <td>${user.firstname}</td>
                                            <td>${user.lastname}</td>
                                            <td>${user.email}</td>
                                            <td>${user.phone}</td>
                                            <td>
                                                <c:forEach var="role" items="${user.userRolesList}">
                                                    ${role.rolename}&nbsp;
                                                </c:forEach>
                                            </td>
                                            <!--<td>-->
                                            <c:choose>
                                                <c:when test="${user.active}">
                                                    <td class="success">active</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td class="danger">disabled</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <!--</td>-->
                                            
                                            <td>
                                                <a class="btn btn-primary" href="${base}/admin/user/edit/${user.id}">
                                                    Edit
                                                </a>
                                            </td>
                                            <td>
                                                <div class="btn btn-danger">
                                                    Remove
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <a class="btn btn-primary" href="${base}/admin/user/edit/0">
                                Add user
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
