package UploadJson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsingMaven {
    static String testExId = "";
    static Process proc;

    public static void main(String[] args) throws Exception {

        //Code used to run commands from cmd prompt
        try {
            String dir = System.getProperty("user.dir") + "\\cuketest\\GVDAuto";
            String cukeCommand = "chcp 65001 && cuke --run --profile Profile2";
            proc = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd \"" + dir + "\" && " + cukeCommand + " && EXIT\"");

        } catch (Exception e) {
            System.out.println("An error occurred while making a command line call");
            e.printStackTrace();

        } finally {
            //wait for the json file to have some data init
            String projectDir = System.getProperty("user.dir");
            String file = projectDir + "\\cuketest\\GVDAuto\\reports\\GVDAuto__report.json";
            File f = new File(file);
            while (f.exists() && !f.isDirectory()) {
                System.out.println("file not exists");
            }
            Thread.sleep(10000);
            BufferedReader br = new BufferedReader(new FileReader(file));
            while(br.readLine()==null){
                System.out.println("text not exists");
            }

            //code to upload the json file to Xray
            HttpPost post;
            HttpPut put;

            String json = readFileAsString(file);
            System.out.println(json);
            //getting the access token from client id and password
            String POST_PARAMS1 = "{\"client_id\":\"DD2BDE3B59284B22A8EAB7E91B9515DC\",\"client_secret\":\"56f7f33c4c86694f6ae7fef577f6a5358dd791a2ef9495fa604703423a48c485\"}";
            System.out.println("Request: " + POST_PARAMS1);
            HttpResponse response1 = null;
            String line = "";
            StringBuilder result1 = new StringBuilder();
            post = new HttpPost("https://xray.cloud.xpand-it.com/api/v2/authenticate");
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Accept", "application/json");
            post.setEntity(new StringEntity(POST_PARAMS1));
            HttpClient client1 = HttpClientBuilder.create().build();
            response1 = client1.execute(post);
            System.out.println("Response Code : " + response1.getStatusLine().getStatusCode());
            BufferedReader reader = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
            while ((line = reader.readLine()) != null) {
                result1.append(line);
            }
            System.out.println("Response of the authenticate: " + result1.toString());
            String password = result1.toString().replaceAll("\"", "");
            post.releaseConnection();

            //JSON parser object to parse read file
            String POST_PARAMS = json;
            System.out.println("Request: " + POST_PARAMS);
            HttpResponse response = null;
            String line2 = "";
            StringBuilder result = new StringBuilder();
            post = new HttpPost("https://xray.cloud.xpand-it.com/api/v2/import/execution/cucumber");
            String authHeader1 = "Bearer " + password;
            post.setHeader("AUTHORIZATION", authHeader1);
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Accept", "application/json");
            post.setEntity(new StringEntity(POST_PARAMS));
            HttpClient client2 = HttpClientBuilder.create().build();
            response = client2.execute(post);
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line2 = reader2.readLine()) != null) {
                result.append(line2);
            }
            System.out.println("Response of the import results: " + result.toString());
            Pattern pattern = Pattern.compile("key\":\"(.*?)\",\"self");
            Matcher matcher = pattern.matcher(result.toString());
            while (matcher.find()) {
                System.out.println(matcher.group(1));
                testExId = matcher.group(1);
            }
            System.out.println("test execution id: " + testExId);
            post.releaseConnection();
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd");
            DateTimeFormatter prettyFormatter = DateTimeFormatter.ofPattern("MM/dd");
            String formattedDate = date.format(formatter);
            String prettyDate = date.format(prettyFormatter);
// to change the name
            String userName = "akoduri@globalvision.co";
            String password1 = "gmHZ3tEIfPYNNp7QibBcF810";
            String credentialString = userName + ":" + password1;
            String encodedAuth = Base64.getEncoder().encodeToString(credentialString.getBytes());
            String POST_PARAM = "{\"fields\":{\"summary\":\"" + prettyDate + " GVD Validation Test Execution\"}}";
            System.out.println("Request: " + POST_PARAM);
            HttpResponse resp = null;

            put = new HttpPut("https://globalvisioninc.atlassian.net/rest/api/2/issue/" + testExId + "");
            String authHeader = "Basic " + encodedAuth;
            put.setHeader("AUTHORIZATION", authHeader);
            put.setHeader("Content-Type", "application/json");
            put.setHeader("Accept", "application/json");
            put.setEntity(new StringEntity(POST_PARAM));
            HttpClient client = HttpClientBuilder.create().build();
            resp = client.execute(put);
            System.out.println("Response Code : " + resp.getStatusLine().getStatusCode());

        }

    }

    public static String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
