"# restClientforHttp" 
模拟火狐浏览器的RESTClient
public static void main(String[] args) {
        try {
            DefaultHttpClient Client = new DefaultHttpClient();

            HttpGet httpGet = new HttpGet("http://192.168.*.*:15672/api/queues/");
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

          //  System.out.println(.fromObject(repsonseStr));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
