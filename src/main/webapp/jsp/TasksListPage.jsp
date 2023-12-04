<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="Models.Task" %>--%>
<%--<%@ page import="Models.User" %>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>To Do List</title>--%>
<%--&lt;%&ndash;    <link rel="stylesheet" type="text/css" href="/css/ToDoList.css">&ndash;%&gt;--%>

<%--    <style>--%>
<%--        .gradient-custom-2 {--%>
<%--            /* fallback for old browsers */--%>
<%--            background: #7e40f6;--%>

<%--            /* Chrome 10-25, Safari 5.1-6 */--%>
<%--            background: -webkit-linear-gradient(--%>
<%--                    to right,--%>
<%--                    rgba(126, 64, 246, 1),--%>
<%--                    rgba(80, 139, 252, 1)--%>
<%--            );--%>

<%--            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */--%>
<%--            background: linear-gradient(--%>
<%--                    to right,--%>
<%--                    rgba(126, 64, 246, 1),--%>
<%--                    rgba(80, 139, 252, 1)--%>
<%--            );--%>
<%--        }--%>

<%--        .mask-custom {--%>
<%--            background: rgba(24, 24, 16, 0.2);--%>
<%--            border-radius: 2em;--%>
<%--            backdrop-filter: blur(25px);--%>
<%--            border: 2px solid rgba(255, 255, 255, 0.05);--%>
<%--            background-clip: padding-box;--%>
<%--            box-shadow: 10px 10px 10px rgba(46, 54, 68, 0.03);--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--&lt;%&ndash;<div class="table-responsive">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <table class="table table-hover table-bordered table-danger border-dark">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="col">#</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="col">Lorem</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="col">Ipsum</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="col">Dolor</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tbody>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="row">1</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Sit</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Amet</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Consectetur</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="row">2</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Adipisicing</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Elit</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Sint</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="row">3</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Hic</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Fugiat</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td>Temporibus</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tbody>&ndash;%&gt;--%>

<%--&lt;%&ndash;    </table>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<section class="vh-100 gradient-custom-2">--%>
<%--    <div class="container py-5 h-100">--%>
<%--        <div class="row d-flex justify-content-center align-items-center h-100">--%>
<%--            <div class="col-md-12 col-xl-10">--%>

<%--                <div class="card mask-custom">--%>
<%--                    <div class="card-body p-4 text-white">--%>

<%--                        <div class="text-center pt-3 pb-2">--%>
<%--                            <img src="/images/img.png"--%>
<%--                                 alt="Check" width="60">--%>
<%--                            <h2 class="my-4">Task List</h2>--%>
<%--                        </div>--%>

<%--                        <table class="table table-striped table-dark">--%>
<%--                            <thead>--%>
<%--                            <tr class="fw-normal">--%>
<%--                                <th scope="col">Task ID</th>--%>
<%--                                <th scope="col">Task Name</th>--%>
<%--                                <th scope="col">Description</th>--%>
<%--                                <th scope="col">Deadline</th>--%>
<%--                            </tr>--%>
<%--                            </thead>--%>
<%--                            <tbody>--%>

<%--                            <c:forEach items="${taskJsp}" var="task">--%>
<%--                                <tr class="fw-normal">--%>
<%--                                    <th scope="row">${task.taskId}</th>--%>
<%--&lt;%&ndash;                                    <td class="align-middle"></td>&ndash;%&gt;--%>
<%--                                    <td class="align-middle">${task.taskName}</td>--%>
<%--                                    <td class="align-middle">${task.taskDescription}</td>--%>
<%--                                    <td class="align-middle">${task.taskDeadline}</td>--%>
<%--                                </tr>--%>
<%--                            </c:forEach>--%>
<%--&lt;%&ndash;                                                        <tr class="fw-normal">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <th class="border-0">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava6-bg.webp"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                     alt="avatar 1" style="width: 45px; height: auto;">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                <span class="ms-2">Ben Smith</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            </th>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td class="border-0 align-middle">Ask for Lunch to Clients</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td class="border-0 align-middle">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                <h6 class="mb-0"><span class="badge bg-success">Low priority</span></h6>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            <td class="border-0 align-middle">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                <a href="#!" data-mdb-toggle="tooltip" title="Done"><i&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                        class="fas fa-check fa-lg text-success me-3"></i></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                <a href="#!" data-mdb-toggle="tooltip" title="Remove"><i&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                        class="fas fa-trash-alt fa-lg text-warning"></i></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                            </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                        </tr>&ndash;%&gt;--%>
<%--                            </tbody>--%>
<%--                        </table>--%>


<%--                    </div>--%>
<%--                </div>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--</body>--%>
<%--</html>--%>



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

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #343a40;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .action-buttons {
            display: flex;
            align-items: center;
        }

        .action-buttons a {
            padding: 6px 12px;
            margin-right: 5px;
            text-decoration: none;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .action-buttons a.btn-delete {
            background-color: #dc3545;
            color: white;
        }

        .action-buttons a.btn-finished {
            background-color: #28a745;
            color: white;
        }

        .action-buttons a:hover {
            filter: brightness(90%);
        }

        .divider {
            height: 1px;
            width: 6px;
            background-color: transparent;
            margin: 0 8px;
        }
    </style>
</head>
<body>

<section class="vh-100 gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-12 col-xl-10">

                <div class="card mask-custom">
                    <div class="card-body p-4 text-white">

                        <div class="text-center pt-3 pb-2">
                            <img src="/images/img.png" alt="Check" width="60">
                            <h2 class="my-4">Task List</h2>
                        </div>

                        <table class="table table-striped table-dark">
                            <thead>
                            <tr class="fw-normal">
                                <th scope="col">Task ID</th>
                                <th scope="col">Task Name</th>
                                <th scope="col">Description</th>
                                <th scope="col">Deadline</th>
                                <th scope="col">Actions</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${taskJsp}" var="task">
                                <tr class="fw-normal">
                                    <td scope="row">${task.taskId}</td>
                                    <td class="align-middle">${task.taskName}</td>
                                    <td class="align-middle">${task.taskDescription}</td>
                                    <td class="align-middle">${task.taskDeadline}</td>
                                    <td class="align-middle">
                                        <div class="action-buttons">
                                            <a href="/deleteTask?task_id=${task.taskId}" onclick="deleteTask(${task.taskId}); return false;" class="btn-delete">Delete</a>
                                            <span class="divider"></span>
                                            <a href="/markAsFinished?id=${task.taskId}" onclick="markAsFinished(${task.taskId}); return false;" class="btn-finished">Mark as Finished</a>
                                        </div>
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
</section>

<script>
    function deleteTask(taskId) {
        fetch('http://localhost:8080/tasks/${taskId}', {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    console.log('Task with ID ${taskId} deleted successfully');
                    document.getElementById('taskRow-${taskId}').remove();
                } else {
                    console.error('Failed to delete task with ID ${taskId}');
                }
            })
            .catch(error => {
                console.error('Error deleting task:', error);
            });
    }

    function markAsFinished(taskId) {
        fetch('http://localhost:8080/tasks/${taskId}/finish', {
            method: 'PUT'
        })
            .then(response => {
                if (response.ok) {
                    console.log('Task ID ${taskId} marked as finished');
                    document.getElementById('taskStatus-${taskId}').innerText = 'Finished';
                } else {
                    console.error(`Failed to mark task with ID ${taskId} as finished`);
                }
            })
            .catch(error => {
                console.error('Error marking task as finished:', error);
            });
    }
</script>

</body>
</html>




