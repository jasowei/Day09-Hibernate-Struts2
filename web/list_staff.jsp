<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/20
  Time: 上午10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <script src="jquery-3.2.1.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#department").change(function () {
                $("#post").empty();
                $("#post").append('<option value="-1">---请选择---</option>');
                $.post(
                        "findPost",
                        {
                            departid: $("#department").val()
                        },
                        function (data) {

                            $.each(data, function (i, n) {
                                $("#post").append('<option value=' + n.id + '>' + n.pname + '</option>');
                            });
                        },
                        'json'
                );
            });
        });
    </script>
    <style>
        table {
            border-collapse: collapse;
        }

        td {
            border: solid;
        }
    </style>
</head>
<body>
<form action="findStaff.action" method="post">
    部门:
    <select id="department" name="dept">
        <option value="-1">---请选择---</option>
        <s:iterator var="deptList" value="#session.departments">
            <option value="${deptList.id}">${deptList.dname}</option>
        </s:iterator>
    </select>
    职务:
    <select id="post" name="post">
        <option value="-1">---请选择---</option>
    </select>

    <input type="submit" value="query">
</form>
<table id="tab">
    <tr>
        <td>ID</td>
        <td>员工</td>
        <td>部门</td>
        <td>职务</td>
    </tr>
    <s:iterator value="staffs" var="staff">
        <tr>
            <td>${staff.id}</td>
            <td>${staff.sname}</td>
            <td>${staff.department.dname}</td>
            <td>${staff.post.pname}</td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
