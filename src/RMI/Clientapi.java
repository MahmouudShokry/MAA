/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Youssef Negm
 */
public class Clientapi {

    public static void main(String[] args) {

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

            // This is where we create our get request
            GetRequest bue_website_request;
            bue_website_request = Unirest.get("http://usfngm.com/login.php?password=AHMED");
            String content = bue_website_request.asString().getBody();
            
            System.out.println(content);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
