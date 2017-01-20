import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestFulClient {

    public static void main(String[] args) {
        try {
            DefaultHttpClient Client = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet("http://192.168.8.51:15672/api/queues/");
            String encoding = DatatypeConverter.printBase64Binary("admin:admin".getBytes("UTF-8"));

            httpGet.setHeader("Authorization", "Basic " +encoding);

            HttpResponse response = Client.execute(httpGet);

            System.out.println("response =" + response);

            BufferedReader breader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder responseString = new StringBuilder();
            String line = "";
            while ((line = breader.readLine()) !=null) {
                responseString.append(line);
            }
            breader.close();
            String repsonseStr =responseString.toString();

              System.out.println(repsonseStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
