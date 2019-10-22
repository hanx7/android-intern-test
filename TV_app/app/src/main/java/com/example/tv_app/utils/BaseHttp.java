package com.example.tv_app.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseHttp extends Thread {

    private String url;
    private final int buff_size = 8192;

    public BaseHttp(String url ){
        this.url = url;
    }

    public String getString(){
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

    public byte[] getContent()
    {
        try {
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
            System.out.println(e.getMessage());
        }
        return null;
    }


}