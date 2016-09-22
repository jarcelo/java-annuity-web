<%-- 
    Document   : AnnuitySchedule
    Created on : Sep 22, 2016, 12:21:57 AM
    Author     : josepharcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="business.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Schedule</title>
    </head>
    <body>
        <h1>Annuity Schedule</h1> <br>
        <p>
            An annuity with deposit of: ${annuity.deposit} each month earning 
            ${annuity.rate} annually will have a value of:
            ${annuity.finalValue} after
            ${annuity.term} months.
        </p>
        
        <table>
            <tr>
                <th>Month</th>
                <th>Beg. Balance</th>
                <th>Int.Earned</th>
                <th>End. Balance</th>
            </tr>
            <c:forEach var="annuityMonth" items="${annuity.months}">
                <tr>
                    <td>${annuityMonth.month}</td>
                    <td>${annuityMonth.beginningBalance}</td>
                    <td>${annuityMonth.interestEarned}</td>
                    <td>${annuityMonth.endingBalance}</td>
                </tr>
            </c:forEach>
        </table>
               
        <form action="NewAnnuity" method="post">
            <input type="submit" value="New Annuity">
        </form>
        <!--
        <a href="AnnuityInput.jsp">New Annuity</a>
        <% 
            //session.invalidate(); 
            //request.getSession().removeAttribute("annuity");
        %>
        -->
        
        
    </body>
</html>
