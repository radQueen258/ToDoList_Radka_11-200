<%@ page import="java.util.List" %>
<%@ page import="Models.Task" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tasks</title>
</head>
<body>
<div>
    <table>
        <tr>
           <th >User Nickname</th>
           <th >Task</th>
            <th >Priority</th>
             <th >Actions</th>
        </tr>
            <c:forEach items="${taskJsp}" var="task">--%>
                <tr>
                    <td>${task.task_id}</td>
                    <td>${task.task_name}</td>
                    <td>${task.description}</td>
                    <td>${task.deadline}</td>
                </tr>
            </c:forEach>

    </table>
</div>
</body>
</html>









<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>To Do List</title>--%>
<%--    <link rel="stylesheet" type="text/css" href="/css/ToDoList.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<section class="vh-100 gradient-custom-2">--%>
<%--    <div class="container py-5 h-100">--%>
<%--        <div class="row d-flex justify-content-center align-items-center h-100">--%>
<%--            <div class="col-md-12 col-xl-10">--%>

<%--                <div class="card mask-custom">--%>
<%--                    <div class="card-body p-4 text-white">--%>

<%--                        <div class="text-center pt-3 pb-2">--%>
<%--                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-todo-list/check1.webp"--%>
<%--                                 alt="Check" width="60">--%>
<%--                            <h2 class="my-4">Task List</h2>--%>
<%--                        </div>--%>
<%--                           <table class="table text-white mb-0">--%>
<%--                               <thead>--%>
<%--                                    <tr>--%>
<%--                                        <th scope="col">User Nickname</th>--%>
<%--                                        <th scope="col">Task</th>--%>
<%--                                        <th scope="col">Priority</th>--%>
<%--                                        <th scope="col">Actions</th>--%>
<%--                                    </tr>--%>
<%--                               </thead>--%>
<%--                                <c:forEach items="${taskJsp}" var="task">--%>
<%--                                     <tr>--%>
<%--                                        <td>${task.task_id}</td>--%>
<%--                                        <td>${task.task_name}</td>--%>
<%--                                         <td>${task.description}</td>--%>
<%--                                         <td>${task.deadline}</td>--%>
<%--                                     </tr>--%>
<%--                                </c:forEach>--%>
<%--                           </table>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </section>--%>
<%--</body>--%>
<%--</html>--%>
