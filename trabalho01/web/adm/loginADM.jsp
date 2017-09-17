<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />

        <title>Área Administrativa</title>
    </head>
    <body>
        <div id="log"></div>
        <h1><center>Área Administrativa</center></h1>
        <p><center> Seja bem-vindo(a)!</center></p>


<form id="formulario" method="post" action="../LoginADMServlet">
    <fieldset id="acesso">
        <legend>LOGIN:</legend>
        <p> Usuário: <input type="text" name="usuario" placeholder="1234"> </p> 
        <p> Senha: <input type="password" name="senha"> </p>
        <p><input type="submit" value="Entrar"> </p>
        <p><input type="button" value="Acesso para Clientes" onclick="window.location.replace('../index.jsp');"> </p>
    </fieldset>
</form>


</body>
</html>