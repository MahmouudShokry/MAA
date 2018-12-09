
package RMI;

import Jason.encpass;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.Objects.hash;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import online.store.OnlineStore;
//import json.CurrencyResponse;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class GUIcon {
    
    private OnlineStore gui;

    public GUIcon(OnlineStore gui) {
        this.gui = gui;
      //  gui.getConvertBtn().addActionListener(new ConvertButtonHandler());
    }
    
     class ConvertButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // This code ignores SSL certificates when dealing with HTTPS
                SSLContext sslcontext = SSLContexts.custom()
                        .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                        .build();
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
                CloseableHttpClient httpclient = HttpClients.custom()
                        .setSSLSocketFactory(sslsf)
                        .build();
                Unirest.setHttpClient(httpclient);
                
                // Get Password from text field
               //String password = (gui.jPasswordField1().getText());
                String url = "http://usfngm.com/login.php?password=ahmed" ;
                String fullurl  = url;
                String json = Unirest.get(fullurl).asString().getBody();
                encpass result = new Gson().fromJson(json, encpass.class);
                // Get JSON response
                String output = result.getResult();
                // Finally, setting the result
                System.out.print(output.toString());
                
                
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        }
    }

     
    }

