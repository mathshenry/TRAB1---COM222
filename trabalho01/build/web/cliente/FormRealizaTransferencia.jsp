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
        <title>Realizar Transferência</title>
    </head>
    <body>
        <div id="log"></div>
        <h1><center>TRANFERENCIA</center></h1>
        <form id="formulario1" method="post" action="../RealizaTransferenciaCliente">
            <center>
            <p> Senha <input type="password" name="senha" required="required"><br></p>
            <p> Conta para crédito <input type="number" name="contaCredito" required="required"></p>
            <p> Valor <input type="text" name="valor" required="required"></p>
            <input type="submit" value="Efetuar Transferência">
            </center>
        </form>        
    </body>
</html>
