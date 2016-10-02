<%-- 
    Document   : AnnuityResults
    Created on : Sep 22, 2016, 12:13:35 AM
    Author     : josepharcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="annuity" scope="session" class="business.Annuity" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Annuity Results</title>
    </head>
    <body>
        <div class="container">
             <div class="jumbotron">
            <h1 class="text-center">Annuity Results</h1>
            <hr>
            <br>
            <h4 class="text-center">
                An annuity with deposit of: ${annuity.depositStartOfMonth} each month,
                and deposit of : ${annuity.depositEndOfMonth} earning 
                ${annuity.rate} annually will have a value of:
                
                ${annuity.term} months.
            </h4>

            <p class="text-center"> Using  standard jsp tags: <br>
                An annuity with a deposit of: 
                <jsp:getProperty name="annuity" property="depositStartOfMonth" />
                at the start of the month and a deposit of : 
                <jsp:getProperty name="annuity" property="depositEndOfMonth" />
                at end of the month earning 
                <jsp:getProperty name="annuity" property="rate" />
                annually will have a value of:
                <jsp:getProperty name="annuity" property="finalValue" />
                after
                <jsp:getProperty name="annuity" property="term" />
                months.
            </p>

            <form action="AnnuitySchedule.jsp" method="post">
                <input class="btn bt-default center-block" type="submit" value="Schedule"/>
            </form>

            <form action="NewAnnuity" method="post">
                <input class="btn btn-info center-block" type="submit" value="New Annuity">
            </form>
        </div>
        </div>      
    </body>
</html>
