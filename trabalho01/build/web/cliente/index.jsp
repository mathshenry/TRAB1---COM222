
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Home Banking</title>
    </head>
    
    <body>
        <div id="log"></div>
        <h1><center>Home Banking</center></h1>
    <center><h3>Login:</h3></center>
    <form id="formulario" method="post" action="LoginCliente">
        <p>Conta: <input type="text"  name="usuario" placeholder="1234" required="required"></p>
        <p>Senha: <input name="senha" type="password" required="required"> </p>
        <p><input type="submit" value="Entrar"> </p>
    </form>

    <input id="botao1" type="button" value="Acesso para Funcionário" onclick="window.location.replace('adm/loginADM.jsp');">
</body>
</html>
