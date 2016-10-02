<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Annuity</title>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
            <h1 class="text-center">Annuity Calculator</h1>
            <hr>
            <form action="AnnuityCalc" name="adata" id="adata" method="post" class="form-horizontal">
                <br>
                <br>
                <div class="form-group">
                    <label  for="amt1" class="col-sm-5 control-label">Deposit at Beginning of Month</label>
                    <div class="input-group col-sm-3">
                        <div class="input-group-addon">$</div>
                        <input class="form-control" type="text" name="amt1" id="amt1" value="${annuity.depositStartOfMonth}" placeholder="Deposit 1"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="amt2" class="col-sm-5 control-label">Deposit at End of the Month</label>
                    <div class="input-group col-sm-3">
                        <div class="input-group-addon">$</div>
                        <input class="form-control" type="text" name="amt2" id="amt2" value="${annuity.depositEndOfMonth}" placeholder="Deposit 2"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="irt" class="col-sm-5 control-label">Annual Interest Rate</label>
                    <div class="input-group col-sm-3">
                        <div class="input-group-addon">i</div>
                        <input class="form-control" type="text" name="irt" id="irt" value="${annuity.rate}" placeholder="Rate in decimal"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="term" class="col-sm-5 control-label">Term (in months)</label>
                    <div class="input-group col-sm-3">
                        <div class="input-group-addon">t</div>
                        <input class="form-control" type="text" name="term" id="term" value="${annuity.term}" placeholder="Term in months"/>
                    </div>
                </div>

                <div class="form-group form-group-lg">
                    <br>
                    <br>
                    <div class="col-sm-4 col-sm-offset-4">
                        <input class="form-control btn btn-success btn-block" type="submit" value="Calculate"/>
                    </div>
                </div>


<!--
                Deposit at Begining of Month:
                <input type="text" name="amt1" id="amt1" value="${annuity.depositStartOfMonth}"/><br><br>
                Deposit at End of Month:
                <input type="text" name="amt2" id="amt2" value=""/><br><br>
                Annual Interest Rate:
                <input type="text" name="irt" id="irt" value="${annuity.rate}"/><br><br>
                Term(in mos):
                <input type="text" name="term" id="term" value="${annuity.term}"/><br><br>
                <input type="submit" value="Calculate"/>
-->
            </form>   

            <div>
                ${errorMessage}
            </div>
            </div>
        </div><!-- .jumbotron -->
    </body>
</html>