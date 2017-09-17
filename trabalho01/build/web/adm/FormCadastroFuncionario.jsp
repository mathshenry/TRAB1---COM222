
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />

        <title>Cadastrar novo Funcionário</title>
    </head>
    <body>

        <div id="log"></div>
        <h1><center>CADASTRAR NOVO FUNCIONÁRIO</center></h1>
        <form id="formulario" method="post" action="../CadastraFuncionario">
            <fieldset>
                <legend>FUNCIONÁRIO</legend>
                <p> Nome: <input type="text" name="nome" required="required"> </p>
                <p> Email: <input type="text" name="email" required="required"> </p>
                <p> Função: <input type="text" name="funcao" required="required"> </p>
                <p> Senha: <input type="password" name="senha" required="required"> </p>
                <input type="submit" value="Efetuar Cadastro">
            </fieldset>
        </form>
    </body>
</html>
