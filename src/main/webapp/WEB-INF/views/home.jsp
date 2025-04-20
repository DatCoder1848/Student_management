<%--
  Created by IntelliJ IDEA.
  User: TAN DAT
  Date: 20-Apr-25
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="vi">
<head>
    <meta charset="utf-8" />
    <title>Manage Users</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="author" />

    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/css/layout.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="${pageContext.request.contextPath}/resources/css/gof.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/resources/css/model_message.css" rel="stylesheet" type="text/css" />
    <!-- END THEME LAYOUT STYLES -->

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/IUser.png" />
</head>

<body>
<!-- BEGIN TABLE PORTLET -->
<div class="g-12 col-xs-12 col-sm-12 portlet light bordered" style="min-height: 170px">
    <!-- Tiêu đề -->
    <img src="${pageContext.request.contextPath}/resources/images/IUser.png" class="title-icons" alt="Logo" />
    <span class="caption-subject font-dark bold">Manage Users</span>

    <!-- Bảng hiển thị thông tin sinh viên -->
    <div class="row mt-3">
        <div class="col-md-12">
            <h3 class="font-dark bold">User Lists</h3>
            <table class="table table-bordered">
                <thead class="bg-primary text-white">
                <tr>
                    <th>CHOOSE</th>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Mark</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>
                            <input type="radio" name="selectedStudent" value="${student.id}"
                                   onclick="populateForm('${student.id}', '${student.firstName}', '${student.lastName}', '${student.mark}')">
                        </td>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.mark}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Form nhập liệu -->
    <div class="row mt-4">
        <div class="col-md-6">
            <form id="studentForm" method="POST" action="${pageContext.request.contextPath}/manageStudent">
                <div class="form-group">
                    <label>ID</label>
                    <input name="txtID" id="txtID" class="form-control" placeholder="Enter ID" />
                </div>
                <div class="form-group">
                    <label>First Name</label>
                    <input name="txtFirstName" id="txtFirstName" class="form-control" placeholder="Enter First Name" />
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input name="txtLastName" id="txtLastName" class="form-control" placeholder="Enter Last Name" />
                </div>
                <div class="form-group">
                    <label>Mark</label>
                    <input name="txtMark" id="txtMark" class="form-control" placeholder="Enter Mark" />
                </div>

                <!-- Các nút chức năng -->
                <div class="form-group mt-3">
                    <button type="submit" name="btnManageStudent" value="add" class="btn btn-primary">Add</button>
                    <button type="submit" name="btnManageStudent" value="update" class="btn btn-warning">Update</button>
                    <button type="submit" name="btnManageStudent" value="delete" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- END TABLE PORTLET -->

<!-- Hiển thị thông báo nếu có -->
<c:if test="${not empty message}">
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            showMessage('${message}');
        });
    </script>
</c:if>

<!-- Thêm các file JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/LBS_Func_Generaljs.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/LBS_Valid_Generaljs.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/LBS_Modal_MESSAGE_Generaljs.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/OamUserJs_Generaljs.js"></script>
</body>
</html>