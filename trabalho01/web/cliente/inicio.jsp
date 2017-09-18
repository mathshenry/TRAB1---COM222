
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Inicio ADM</title>
    </head>
    <body>
         <div id="log"></div>
        <h1><center>Home Banking</center></h1>

        <fieldset id="home"><legend><h2>Gestão de Transações</h2></legend>
            <center>
                <input type="button" value="Transferência" onclick="window.location.replace('FormRealizaTransferencia.jsp');">
            </center>
        </fieldset>
        <br>
        <fieldset id="home"><legend><h2>Gestão de Extratos</h2></legend>
            <center>
                <input type="button" value="Saldo" onclick="window.location.replace('../ConsultaSaldoCliente');">
                <input type="button" value="Extrato" onclick="window.location.replace('../ConsultaExtratoCliente');">
            </center>
        </fieldset>
    </body>
</html>
