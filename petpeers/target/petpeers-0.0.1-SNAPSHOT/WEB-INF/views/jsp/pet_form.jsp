<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style> 
   h2 {
   text-align:center;
  }
        .error {
         color: #ff0000;
      }
  
</style>
</head>
<body>
    <form:form action="save" modelAttribute="object" method="Get">

 

        <h2>Pet Information</h2>

 

            
<%--        Name: <form:input path="name" /> --%>
<!--         <br> -->
<%--        Age:  <form:input path="age" /> --%>
<!--         <br> -->
<%--        Place: <form:input path="place" /> --%>
<!--         <br> -->

 

                  <form:errors path = "*" cssClass = "error" element = "div" />
         <table>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "age">Age</form:label></td>
               <td><form:input path = "age" /></td>
            </tr>
            <tr>
               <td><form:label path = "place">Place</form:label></td>
               <td><form:input path = "place" /></td>
               </tr>
            <tr>
               <td colspan = "2">
               <input type = "submit" value = "Save"/>
               <input type="reset" value="Reset"> 
               </td>
            </tr>
         </table>  

 

    </form:form>
</body>
</html>