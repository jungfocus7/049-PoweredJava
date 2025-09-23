package hbx.atests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class TesterPrograme {
    private static void println(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws Exception {
        println("Hello, World!");

        URL turl = new URL("https://www22.sooplive.co.kr/?mobile");
        HttpURLConnection thuc = (HttpURLConnection)turl.openConnection();
        thuc.setRequestMethod("GET");
        thuc.setConnectTimeout(5000);
        thuc.setReadTimeout(5000);

        int tst = thuc.getResponseCode();
        if (tst != HttpURLConnection.HTTP_OK) {
            println("Error: HTTP Response Cod " + tst);
        }

        BufferedReader tbfrd = new BufferedReader(new InputStreamReader(thuc.getInputStream()));
        StringBuilder tsb = new StringBuilder();
        String tls = null;
        while ((tls = tbfrd.readLine()) != null) {
            tsb.append(tls);
            tsb.append(System.lineSeparator());
        }

        String trs = tsb.toString();
        println(trs);
        Files.write(Paths.get("tmp.txt"), trs.getBytes(StandardCharsets.UTF_8));

        println("마무리");
    }
}
