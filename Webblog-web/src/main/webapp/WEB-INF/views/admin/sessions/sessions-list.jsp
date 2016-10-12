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
        <script type="text/javascript">
            
        </script>
        
        <style type="text/css">
            .absolute{
                position: absolute;
            }
            .main-content{
                float: right;
                width: 82%;
            }
            .head-left{
                width: 240px;
            }
            .fit-content{
                padding-left: 30px;
                padding-right: 30px;
            }
            .tbl-right{
                width: 600px;
            }
            .tbl-user{
                width: 840px;
            }
            .tbl-user-label{
                float: right;
                margin-right: 30px;
            }
            .chbox-medium{
                width: 20px;
                height: 20px;
            }
            
        </style>
    </head>
    <body>
        <%@include file="../common/header-nav.jsp" %>        
        <div class="container-fluid fit-content">
            <div class="row">
                <%@include file="../common/left_sidebar.jsp" %>
                <div class="row">
                    <div class="main main-content">
                        <div class="table-responsive">
                            <table class="table table-bordered tbl-user">                                                   
                                <thead>
                                    <tr class="info">
                                        <th class="head-left">ID</th>
                                        <th class="tbl-right">Device</th>
                                        <th class="tbl-right">Remove</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <c:forEach var="session" begin="0" end="${len-1}" step="1">
                                        <tr class="info">
                                            <td>
                                                ${sessions[session]}
                                            </td>
                                            <td>
                                                ${sessionsInfo[session].device}
                                            </td>
                                            <td>
                                                <button class="btn btn-primary">Remove</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
