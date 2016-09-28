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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Annuity Schedule</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Annuity Schedule</h1> <br>
            <h4 class="text-center">
                An annuity with deposit of: ${annuity.deposit} each month earning 
                ${annuity.rate} annually will have a value of:
                ${annuity.finalValue} after
                ${annuity.term} months.
            </h4>

            <table class="table">
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
            <hr>
            <br>
            <form action="NewAnnuity" method="post">
                <input class="btn btn-info btn-md" type="submit" value="New Annuity">
            </form>
            <br>
            <br>
            <!--
            <a href="AnnuityInput.jsp">New Annuity</a>
            <% 
                //session.invalidate(); 
                //request.getSession().removeAttribute("annuity");
            %>
            -->
        </div> <!-- .container -->
    </body>
</html>
