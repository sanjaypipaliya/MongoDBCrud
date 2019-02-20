<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<a href="<c:url value="/crud/insert"/>">ADD</a><br/><br/>
		<table border="2">
			<tr align="center">
				<td>EmpId</td>
				<td>EmpName</td>
				<td>Username</td>
				
				<td>Action</td>
			
			</tr>

			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.getEmpId()}</td>
					<td>${emp.getEmpName()}</td>
					<td>${emp.getUsername()}</td>
				
					<td> 
					 	<a href='<c:url value="/crud/update/"></c:url>${emp.getEmpId()}'>Edit</a>
						<a href='<c:url value="/crud/delete/"></c:url>${emp.getEmpId()}'>Delete</a>
						</td>
					<%-- <td>
					<a href='<c:url value="/chat/chatEmp/"></c:url>${emp.getEmpId()}'>Text Chat</a>
						<a href='<c:url value="/chat/videoChat/"></c:url>${emp.getEmpId()}'>Video Chat</a>
					
					</td> --%>
					
				</tr>
			</c:forEach>

			
		</table>
		
</body>
</html>