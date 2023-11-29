<%@ page import="java.util.List" %>
<%@ page import="Models.Task" %>
<%@ page import="Models.User" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>To Do List</title>
<%--    <link rel="stylesheet" type="text/css" href="/css/ToDoList.css">--%>

    <style>
        .gradient-custom-2 {
            /* fallback for old browsers */
            background: #7e40f6;

            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(
                    to right,
                    rgba(126, 64, 246, 1),
                    rgba(80, 139, 252, 1)
            );

            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(
                    to right,
                    rgba(126, 64, 246, 1),
                    rgba(80, 139, 252, 1)
            );
        }

        .mask-custom {
            background: rgba(24, 24, 16, 0.2);
            border-radius: 2em;
            backdrop-filter: blur(25px);
            border: 2px solid rgba(255, 255, 255, 0.05);
            background-clip: padding-box;
            box-shadow: 10px 10px 10px rgba(46, 54, 68, 0.03);
        }
    </style>
</head>
<body>

<%--<div class="table-responsive">--%>
<%--    <table class="table table-hover table-bordered table-danger border-dark">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th scope="col">#</th>--%>
<%--            <th scope="col">Lorem</th>--%>
<%--            <th scope="col">Ipsum</th>--%>
<%--            <th scope="col">Dolor</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <th scope="row">1</th>--%>
<%--            <td>Sit</td>--%>
<%--            <td>Amet</td>--%>
<%--            <td>Consectetur</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th scope="row">2</th>--%>
<%--            <td>Adipisicing</td>--%>
<%--            <td>Elit</td>--%>
<%--            <td>Sint</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th scope="row">3</th>--%>
<%--            <td>Hic</td>--%>
<%--            <td>Fugiat</td>--%>
<%--            <td>Temporibus</td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>

<%--    </table>--%>
<%--</div>--%>

<section class="vh-100 gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-12 col-xl-10">

                <div class="card mask-custom">
                    <div class="card-body p-4 text-white">

                        <div class="text-center pt-3 pb-2">
                            <img src="/images/img.png"
                                 alt="Check" width="60">
                            <h2 class="my-4">Task List</h2>
                        </div>

                        <table class="table table-striped table-dark">
                            <thead>
                            <tr class="fw-normal">
                                <th scope="col">Task ID</th>
                                <th scope="col">Task Name</th>
                                <th scope="col">Description</th>
                                <th scope="col">Deadline</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${taskJsp}" var="task">
                                <tr class="fw-normal">
                                    <th scope="row">${task.taskId}</th>
<%--                                    <td class="align-middle"></td>--%>
                                    <td class="align-middle">${task.taskName}</td>
                                    <td class="align-middle">${task.taskDescription}</td>
                                    <td class="align-middle">${task.taskDeadline}</td>
                                </tr>
                            </c:forEach>
<%--                                                        <tr class="fw-normal">--%>
<%--                                                            <th class="border-0">--%>
<%--                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"--%>
<%--                                                                     alt="avatar 1" style="width: 45px; height: auto;">--%>
<%--                                                                <span class="ms-2">Ben Smith</span>--%>
<%--                                                            </th>--%>
<%--                                                            <td class="border-0 align-middle">Ask for Lunch to Clients</td>--%>
<%--                                                            <td class="border-0 align-middle">--%>
<%--                                                                <h6 class="mb-0"><span class="badge bg-success">Low priority</span></h6>--%>
<%--                                                            </td>--%>
<%--                                                            <td class="border-0 align-middle">--%>
<%--                                                                <a href="#!" data-mdb-toggle="tooltip" title="Done"><i--%>
<%--                                                                        class="fas fa-check fa-lg text-success me-3"></i></a>--%>
<%--                                                                <a href="#!" data-mdb-toggle="tooltip" title="Remove"><i--%>
<%--                                                                        class="fas fa-trash-alt fa-lg text-warning"></i></a>--%>
<%--                                                            </td>--%>
<%--                                                        </tr>--%>
                            </tbody>
                        </table>


                    </div>
                </div>

            </div>
        </div>
    </div>
</section>

</body>
</html>






















<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="Models.Task" %>--%>
<%--<%@ page import="Models.User" %>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Tasks</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--           <th >User Nickname</th>--%>
<%--            <th >Task ID</th>--%>
<%--           <th >Task</th>--%>
<%--            <th >Description</th>--%>
<%--             <th >Deadline</th>--%>
<%--        </tr>--%>
<%--            <td>${user.nickname}</td>--%>
<%--            <c:forEach items="${taskJsp}" var="task">--%>
<%--                <tr>--%>
<%--                    <td>${task.taskId}</td>--%>
<%--                    <td>${task.taskName}</td>--%>
<%--                    <td>${task.taskDescription}</td>--%>
<%--                    <td>${task.taskDeadline}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>

<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>



