
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/style.css" rel='stylesheet' type='text/css' />
        <title>Inicio ADM</title>
    </head>
    <body>
         <div id="log"></div>
        <h1><center>Área Administrativa</center></h1>

        <fieldset id="home"><legend><h2>Gestão de Funcionários</h2></legend>
           <center>
                <input type="submit" value="Cadastrar Funcionário" onclick="window.location.replace('FormCadastroFuncionario.jsp');">
          </center>
        </fieldset>
       
        <fieldset id="home"><legend><h2>Gestão de Clientes</h2></legend>
            <center>
                <input type="submit" value="Cadastrar Cliente" onclick="window.location.replace('FormCadastroCliente.jsp');">
            </center>
        </fieldset>
       
        <fieldset id="home"><legend><h2>Gestão de Contas</h2></legend>
            <center>
                <input type="submit" value="Criar conta" onclick="window.location.replace('FormCadastraConta.jsp');">
            </center>
        </fieldset>
       
        <fieldset id="home"><legend><h2>Gestão de Transações</h2></legend>
            <center>
                <input type="submit" value="Saque" onclick="window.location.replace('FormRealizaSaque.jsp');">
                <input type="submit" value="Depósito" onclick="window.location.replace('FormRealizaDeposito.jsp');">
                <input type="submit" value="Pagamento de contas" onclick="window.location.replace('FormPagamentoDeConta.jsp');">
                <input type="submit" value="Transferência" onclick="window.location.replace('FormRealizaTransferencia.jsp');">
            </center>
        </fieldset>
       
        <fieldset id="home"><legend><h2>Gestão de Extratos</h2></legend>
            <center>
                <input type="submit" value="Saldo" onclick="window.location.replace('FormConsultaSaldo.jsp');">
                <input type="submit" value="Extrato" onclick="window.location.replace('FormExtrato.jsp');">
            </center>
        </fieldset>
    </body>
</html>
