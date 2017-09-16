
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar novo Funcionário</title>
    </head>
    <body>
        <h1><center>Cadastrar novo Funcionário</center></h1>
        <form method="post" action="../CadastraFuncionario">
            <center>
            <p> Nome: <input type="text" name="nome" required="required"> </p>
            <p> Email: <input type="text" name="email" required="required"> </p>
            <p> Função: <input type="text" name="funcao" required="required"> </p>
            <p> Senha: <input type="password" name="senha" required="required"> </p>
            <input type="submit" value="Efetuar Cadastro">
            </center>
        </form>
    </body>
</html>
