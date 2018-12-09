/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jason;

/**
 *
 * @author foxah
 */
public class encpass {
    ResponseBody password;
    
    public String getResult() {
        return password.val;
    }
    
    class ResponseBody {
        String val;
    }
}
