<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Image Manager</title>
</head>
<body>

<h2>Image Manager</h2>

<form:form method="post" action="/new/image" commandName="image" enctype="multipart/form-data">
    <table>
        <tr>
            <input type="hidden" name="adId" value="${adId}"/>
            <td><form:label path="content">Image</form:label></td>
            <td><input type="file" name="image" id="file"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Upload"/>
            </td>
        </tr>
    </table>
</form:form>
<br>
<br>
<h3>All the images</h3>


</body>
</html>