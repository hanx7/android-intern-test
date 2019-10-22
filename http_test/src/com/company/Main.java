package com.company;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import org.json.JSONObject;


public class Main {

    public static void main(String[] args) {
	// write your code here
        BaseHttp bh = new BaseHttp("http://api.tvmaze.com/shows/1/episodes");
        String s = bh.getString();
        System.out.println(s);
        // received json string need to delete [] at 2 ends
        JSONArray json_arr = JSONArray.fromObject(s);
        String obj_str = json_arr.getJSONObject(0).optString("url");
        System.out.println(obj_str);
//        try {
//            JSONObject obj0 = new JSONObject(obj0_str);
//            System.out.println(obj0.optString("url"));
//            System.out.println(obj0.optString("name"));
//
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }
}
