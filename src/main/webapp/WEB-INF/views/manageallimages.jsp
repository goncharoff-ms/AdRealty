<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Image Manager</title>
</head>
<body>

<h2>Image Manager</h2>


<form:form method="post" action="/addImage" commandName="image" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="content">Image</form:label></td>
            <td><input type="file" name="file" id="file"></td>
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
<c:if test="${!empty imageList}">
    <table>
        <tr>
            <th>Name | </th>
            <th>Content Type | </th>
            <th>Size | </th>
            <!-- <th>Pic | </th> -->
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${imageList}" var="image">
            <tr>
                <td>${image.name},</td>
                <td>${image.contentType}</td>
                <td>${image.length} bytes</td>
                <td><img src="${pageContext.request.contextPath}/image/${image.id}" /> </td>
                <td><a href="deleteImage/${image.id}">Delete Image</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>