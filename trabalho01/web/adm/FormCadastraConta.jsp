<%-- 
    Document   : FormCadastraConta
    Created on : 17-Sep-2017, 18:39:26
    Author     : maths
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Cadastrar nova conta</title>
    </head>
    <body>
        <div id="log"></div>
        <h1><center>CADASTRAR NOVA CONTA</center></h1>
        <form id="formulario1" method="post" action="../CadastraConta">

            <p> CPF Correntista 1: <input type="text" name="correntista1" required="required"></p>
            <p> CPF Correntista 2: <input type="text" name="correntista2" ></p>
            <p> CPF Correntista 3: <input type="text" name="correntista3" ></p>
            <p> Saldo inicial: <input type="text" name="saldo" required="required"></p>
            <p> Limite: <input type="text" name="limite" required="required"></p>
            <p> Senha: <input type="password" name="senha" required="required"></p>
            <input type="submit" value="Efetuar Cadastro">

        </form>        
    </body>
</html>
