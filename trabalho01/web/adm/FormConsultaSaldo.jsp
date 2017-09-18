
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Consultar Saldo</title>
    </head>
    <body>
        <div id="log"></div>
        <h1><center>CONSULTAR SALDO</center></h1>
        <form id="formulario1" method="post" action="../ConsultaSaldo">
            <center>
            <p> Conta para consulta: <input type="number" name="conta" required="required"></p>
            <input type="submit" value="Efetuar Consulta">
            </center>
        </form>        
    </body>
</html>
