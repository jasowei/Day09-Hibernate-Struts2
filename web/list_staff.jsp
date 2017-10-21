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

            $.post(
                    "listStaff",
                    function (data) {
                        var _html = "";
                        $.each(data,function (i,n) {
                            _html += '<option value=' + n.id + ' >' + n.dname + '</option>';

                        });
                        $("#department").append(_html);
                    },
                    'json'
            );

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

        th{
            border: solid;
            color: brown;
        }
        td {
            border: solid;
        }
    </style>
</head>
<body>
<h1>{员工管理}</h1>
<form action="findStaff.action" method="post">
    部门:
    <select id="department" name="dept">
        <option value="-1">---请选择---</option>
        <%--<s:iterator var="deptList" value="#session.departments">--%>
            <%--<option value="${deptList.id}">${deptList.dname}</option>--%>
        <%--</s:iterator>--%>
    </select>
    职务:
    <select id="post" name="post">
        <option value="-1">---请选择---</option>
    </select>

    姓名:
    <input type="text" name="searchName">

    <input type="submit" value="query">
</form>
<table id="tab">
    <tr>
        <th>ID</th>
        <th>员工</th>
        <th>部门</th>
        <th>职务</th>
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
