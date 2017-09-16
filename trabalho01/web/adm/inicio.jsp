
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio ADM</title>
    </head>
    <body>
        <h1><center>Área Administrativa</center></h1>
        <br>
        <fieldset><legend><h2>Gestão de Funcionários</h2></legend>
            <center>
                <input type="button" value="Adicionar Funcionários" onclick="window.location.replace('adm/FormCadastroFuncionario.jsp');">
            </center>
        </fieldset>
        <br>
        <fieldset><legend><h2>Gestão de Clientes</h2></legend>
            <center>
                <input type="button" value="Adicionar Cliente" onclick="window.location.replace('adm/FormCadastroCliente.jsp');">
            </center>
        </fieldset>
        <br>
        <fieldset><legend><h2>Gestão de Transações</h2></legend>
            <center>
                <input type="button" value="Saques" onclick="window.location.replace('FormCadastroFuncionario.jsp');">
                <input type="button" value="Depósitos" onclick="window.location.replace('FormCadastroCliente.jsp');">
                <input type="button" value="Pagamentos de contas" onclick="window.location.replace('adm/loginADM.jsp');">
                <input type="button" value="Transferências" onclick="window.location.replace('adm/loginADM.jsp');">
            </center>
        </fieldset>
        <br>
        <fieldset><legend><h2>Gestão de Extratos</h2></legend>
            <center>
                <input type="button" value="Saldo" onclick="window.location.replace('FormCadastroFuncionario.jsp');">
                <input type="button" value="Extrato" onclick="window.location.replace('FormCadastroCliente.jsp');">
            </center>
        </fieldset>
    </body>
</html>
