<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área Administrativa</title>
    </head>
    <body>
        <h1><center>Área Administrativa</center></h1>
        <p><center> Seja bem-vindo(a)!</center></p>
</br>
        <p><center><h3>Login:</h3></center></p>
        <form method="post" action="../loginFuncServlet">
            <p><center>Usuário: <input type="text" name="usuario" placeholder="1234"> <center></center></p>
            <p><center>Senha: <input type="password" name="senha"> <center></center></p>
            <p><center><input type="submit" value="Entrar"> <center></center></p>
        </form>
</br>
        <input type="button" value="Acesso para Clientes" onclick="window.location.replace('../index.jsp');">
</body>
</html>