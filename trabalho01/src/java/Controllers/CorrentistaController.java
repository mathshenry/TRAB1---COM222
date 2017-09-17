/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.SQLException;
import utils.DatabaseController;

/**
 *
 * @author maths
 */
public class CorrentistaController {
   
    public void cadastraCorrentista(String CPF, String Nome, String Endereco, String Email) throws SQLException {
        DatabaseController.cadastraCorrentista(CPF, Nome, Endereco, Email);
    }
      
}
