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
            <h2 class="text-center">Annuity Results</h1>
            <hr>
            <br>
                <div class="row">
                    <div class="col-sm-6">
                        <p class="text-left"><br>
                            An annuity with a deposit of 
                            <strong> <jsp:getProperty name="annuity" property="formattedDepositStartOfMonth" /> </strong>
                            at start of month and a deposit of  
                            <strong> <jsp:getProperty name="annuity" property="formattedDepositEndOfMonth" /> </strong>
                            at end of month earning 
                            <strong> <jsp:getProperty name="annuity" property="formattedRate" /> </strong>                           
                            annually will have a value of
                            <strong> <jsp:getProperty name="annuity" property="formattedFinalValue" /> </strong>
                            after
                            <strong> <jsp:getProperty name="annuity" property="term" /> </strong>
                            months, which includes
                            <strong> <jsp:getProperty name="annuity" property="formattedTotalInterestEarned" /> </strong>
                            in interest earned.
                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <br>
                            <br>
                            <div class="col-sm-10 col-sm-offset-1">
                                <form action="AnnuitySchedule.jsp" method="post" class="form-horizontal">
                                    <input class="btn btn-block btn-success center-block" type="submit" value="View Schedule"/>
                                </form>
                            </div>
                            <br>
                            <br>
                            <div class="col-sm-10 col-sm-offset-1">
                                <form action="NewAnnuity" method="post">
                                    <input class="btn btn-block btn-info center-block" type="submit" value="New Annuity">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <br><br><br>
            </div>
        </div>      
    </body>
</html>
