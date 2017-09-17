
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar novo Cliente</title>
    </head>
    <body>
        <h1><center>Cadastrar novo Cliente</center></h1>
        <form method="post" action="../CadastraCorrentista">
            <center>
            <p> Nome: <input type="text" name="nome" required="required"></p>
            <p> CPF: <input type="number" name="cpf" required="required"></p>
            <p> Endereço: <input type="text" name="endereco" required="required"></p>
            <p> Email: <input type="email" name="email" required="required"></p>
            <input type="submit" value="Efetuar Cadastro">
            </center>
        </form>        
    </body>
</html>
