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
            <h2 class="text-center">Annuity Schedule</h1> <br>
            <h4 class="text-center">
                An annuity with deposit of: ${annuity.formattedDepositStartOfMonth} at start of month
                and a deposit of: ${annuity.formattedDepositEndOfMonth} at end of month earning 
                ${annuity.formattedRate} annually will have a value of:
                ${annuity.formattedFinalValue} after
                ${annuity.term} months.
            </h4>
            <br>
            <table class="table">
                <tr>
                    <th class="text-center">Month</th>
                    <th class="text-center">Beginning Balance</th>
                    <th class="text-center">Deposit</th>
                    <th class="text-center">Interest Earned</th>
                    <th class="text-center">Ending Balance</th>
                </tr>
                <c:forEach var="annuityMonth" items="${annuity.months}">
                    <tr>
                        <td class="text-center">${annuityMonth.month}</td>
                        <td class="text-center">${annuityMonth.beginningBalance}</td>
                        <td class="text-center">${annuityMonth.deposit}</td>
                        <td class="text-center">${annuityMonth.interestEarned}</td>
                        <td class="text-center">${annuityMonth.endingBalance}</td>
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
        </div> 
    </body>
</html>
