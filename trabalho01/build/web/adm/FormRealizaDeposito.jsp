<%-- 
    Document   : FormRealizaSaque
    Created on : 17-Sep-2017, 20:14:19
    Author     : maths
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Realizar Depósito</title>
    </head>
    <body>
        <h1><center>Depósito</center></h1>
        <form method="post" action="../RealizaDeposito">
            <center>
            <p> Conta para crédito: <input type="number" name="conta" required="required"></p>
            <p> Valor: <input type="number" name="valor" required="required"></p>
            <input type="submit" value="Efetuar Depósito">
            </center>
        </form>        
    </body>
</html>
