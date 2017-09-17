
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <title>Home Banking</title>
    </head>
    <body>
        <h1><center>Home Banking</center></h1>
        <p><center> Seja bem-vindo(a)!</center></p>
</br>
        <p><center><h3>Login:</h3></center></p>
        <form>
            <p><center>Conta: <input type="text" placeholder="1234"> <center></center></p>
            <p><center>Senha: <input type="password"> <center></center></p>
            <p><center><input type="submit" value="Entrar"> <center></center></p>
        </form>
</br>
        <input type="button" value="Acesso para Funcionários" onclick="window.location.replace('adm/loginADM.jsp');">
</body>
</html>
