package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class BaseHttp extends Thread {

    private String url;
    private final int buff_size = 8192;

    public BaseHttp(String url ){
        this.url = url;
    }

    protected String getString()
    {
        try {
            // URL Concatenate
            URL obj = new URL(url);

            // GET Connection Initialization
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            // GET Server Text Reply
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String response = "";
            while ((inputLine = in.readLine()) != null)
                response += inputLine;
            in.close();
            return response;
        }
        catch (Exception e){
            //return getHttp(remote_url);
            return "GET Error = " + e.getMessage();
        }
    }

    public byte[] getHttp()
    {
        try {
            // return content collection
            URL obj = new URL(this.url);
            // GET Connection Initialization
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            // GET Server Content Reply
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buff = new byte[this.buff_size];
            byte[] b_res;
            int read_len;
            while ((read_len = is.read(buff)) > 0)
                output.write(buff, 0, read_len);
            output.close();
            is.close();
            return output.toByteArray();
        }
        catch (Exception e){
            return e.getMessage().getBytes();
        }
    }

    public void postHttp(byte[] content){
        try{
            // URL Concatenate
            URL url = new URL(this.url);
            // POST Connection Initialization
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod("POST");
            // Send Content to Server
            OutputStream os = conn.getOutputStream();
            os.write(content); //transfer the image string into binary code
            os.close();
        }
        catch (Exception e){
            System.out.println("POST Error = " + e.getMessage());
        }
    }

}
