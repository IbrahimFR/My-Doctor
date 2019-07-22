<%--
  Created by IntelliJ IDEA.
  User: zamalek
  Date: 9/27/2016
  Time: 3:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <script type="text/javascript" src="jquery-1.2.6.min.js"></script>
  <title>Being Java Guys | Hello World</title>
</head>
<body>

<center>
  <h2>Being Java Guys | Hello World</h2>
  <h3>Please select a file to upload !</h3>
  <br />
  <form:form method="post" enctype="multipart/form-data"
             modelAttribute="uploadedFile" action="fileUpload.htm">
    <table>
      <tr>
        <td>Upload File: </td>
        <td><input type="file" name="file" />
        </td>
        <td style="color: red; font-style: italic;"><form:errors
                path="file" />
        </td>
      </tr>
      <tr>
        <td> </td>
        <td><input type="submit" value="Upload" />
          <input type="hidden" name="${_csrf.parameterName}"
                 value="${_csrf.token}" />
        </td>
        <td> </td>
      </tr>
    </table>

  </form:form>
</center>
</body>
</html>