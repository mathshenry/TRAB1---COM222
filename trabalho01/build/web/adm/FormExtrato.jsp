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
        <title>Consultar Extrato</title>
    </head>
    <body>
        <h1><center>Consultar Extrato</center></h1>
        <form method="post" action="../ConsultaExtrato">
            <center>
            <p> Conta para consulta: <input type="number" name="conta" required="required"></p>
            <input type="submit" value="Efetuar Consulta">
            </center>
        </form>        
    </body>
</html>
