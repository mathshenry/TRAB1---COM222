
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />

        <title>Cadastrar novo Cliente</title>
    </head>
    <body>
        <div id="log"></div>
        <h1><center>CADRASTRAR NOVO CLIENTE</center></h1>
        <form id="formulario" autocomplete="off">
            <fieldset>
                <legend>Cliente</legend>
                
                    <p> Nome: <input type="text" name="nome" required="required"></p>
                    <p> CPF: <input type="number" name="cpf" required="required"></p>
                    <p> Endereço: <input type="text" name="end" required="required"></p>
                    <p> Email: <input type="email" name="email" required="required"></p>
                    <p> Senha: <input type="text" name="senha" required="required"></p>    
                    <input type="submit" value="Efetuar Cadastro">
                
            </fieldset>
        </form>

    </body>
</html>
