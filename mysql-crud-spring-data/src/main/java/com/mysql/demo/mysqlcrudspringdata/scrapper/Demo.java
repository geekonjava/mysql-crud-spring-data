package com.mysql.demo.mysqlcrudspringdata.scrapper;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class Demo {
	
	public static void main(String[] args) throws IOException {
		String url = "https://github.com/velesin/jasmine-jquery";
		Document doc = Jsoup.connect(url).get();
		String data[] = doc.title().replace("GitHub - ", "").split(":");
		Elements catArray = doc.getElementsByClass("topic-tag");
		Elements socialCount = doc.getElementsByClass("social-count");
		Elements download = doc.getElementsByClass("js-anon-download-zip-link");
		String authorURL = getAuthorURL(url);
		Document authorDoc = Jsoup.connect(authorURL).get();
		Elements aImage = authorDoc.select("a[itemprop=image]");
		Elements aName = authorDoc.select("span[itemprop=name]");
		Elements aUserName = authorDoc.select("span.vcard-username");
		String readMeText = doc.getElementById("readme").text();
		String readMeHTML = doc.getElementById("readme").html();
		
		String downloadLink = download.attr("href");
		System.out.println("Download::"+downloadLink);
//		System.out.println(readMeHTML);
//		String authorUserName = data[0].split("/")[0];
//		String description = data[1];
//		String title = getTitle(url).toUpperCase();
//		for(Element cat: catArray) {
//			System.out.println(cat.text());
//		}
//		for(Element sc: socialCount) {
//			System.out.println(sc.text());
//		}
//		System.out.println();
		
////////////////Author Information
		
		String authorProfilePic = aImage.attr("href");
		String authorName = aName.text();
		String authorUserName = aUserName.text();
		
//		System.out.println(authorName+" --- "+authorUserName);
		
		String gitScorURL = "http://www.gitscore.com/user/"+authorUserName+"/calculate";
		try {
			System.out.println(gitScorURL);
			String genreJson = IOUtils.toString(new URL(gitScorURL));
	        JSONObject obj = new JSONObject(genreJson);
	        String authorLocation = obj.getJSONObject("user").getString("avatar");

	        System.out.println(authorLocation);
	        System.out.println(obj.get("position"));

//	        JSONArray arr = obj.getJSONArray("posts");
//	        for (int i = 0; i < arr.length(); i++) {
//	            String post_id = arr.getJSONObject(i).getString("post_id");
//	            System.out.println(post_id);
//	        }
        } catch (Exception e) {
            e.printStackTrace();
        } 	
		
		
	}
	
	public static String getTitle(String url) {
		int lastSlash = url.lastIndexOf("/");
		String title = url.substring(lastSlash + 1, url.length());
		return title.contains("-")? title.replaceAll("-", " "): title;
		
	}
	
	public static String getAuthorURL(String url) {
		int lastSlash = url.lastIndexOf("/");
		String start = url.substring(0, lastSlash);
		return start;
	}

}
