<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity</title>
    </head>
    <body>
        <h1>Annuity Calculator</h1>

        <form action="AnnuityCalc" name="adata" id="adata" method="post">
            Deposit at Begining of Month:
            <input type="text" name="amt1" id="amt1" value="${annuity.deposit}"/><br><br>
            Deposit at End of Month:
            <input type="text" name="amt2" id="amt2" value=""/><br><br>
            Annual Interest Rate:
            <input type="text" name="irt" id="irt" value="${annuity.rate}"/><br><br>
            Term(in mos):
            <input type="text" name="term" id="term" value="${annuity.term}"/><br><br>
            <input type="submit" value="Calculate"/>
        </form>   
        
        <div>
            ${errorMessage}
        </div>
    </body>
</html>