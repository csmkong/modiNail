<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
Statement stmt =null;
ResultSet rs = null;
try{
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=HeadFirstEX","csmkong","Init1234!");
    stmt = conn.createStatement();
    rs = stmt.executeQuery("select * from userinfo");
    while(rs.next()){
    	out.println(rs.getString("id"));
    }
    out.println("success");
} catch(Exception e) {
        out.println(e);
}

%>

</body>
</html>