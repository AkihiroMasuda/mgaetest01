package com.appspot.mgaetest01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Com_appspot_mgaetest01Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain;");
//		resp.setCharacterEncoding("UTF-8");

//		final String strUrl = "http://homepage2.nifty.com/akidn8/android/download.html";
//		final String strUrl = "https://api.twitter.com/1.1/search/tweets.json?q=horiday";		
//		final String strUrl = "https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&max_id=250126199840518145&result_type=mixed&count=4";	
		final String strUrl = "http://search.twitter.com/search.json?q=blue%20angels&rpp=5&include_entities=true&result_type=mixed";	
		String result = exeGET(strUrl);
		showString(result, req, resp);
	}

	// 指定したプレーンテキストを表示する
	private void showString(String body, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//		resp.getOutputStream().println("gegege");
//		resp.getOutputStream().println(body);
		PrintWriter out = resp.getWriter();
		out.write(body);
	}
	
	// 指定したHTMLファイルを出力する。
	private void showHtml(String path, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//		RequestDispatcher rd = getServletC　ontext().getRequestDispatcher("/myindex.html");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	// strUrlで指定したホストにGETメソッドでアクセス。結果を返す。
	private String exeGET(String strUrl)
			throws IOException {
		URL urlObj;
		String ret = new String("");
		try {
			urlObj = new URL(strUrl);
			// URL接続
			HttpURLConnection urlCon = (HttpURLConnection)urlObj.openConnection();
			urlCon.setRequestMethod("GET");
			BufferedReader urlIn = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			// 結果をStringにセット
			String tmp = new String();
			while((tmp = urlIn.readLine()) != null){
				ret = ret + tmp;
			}
			// URL切断
			urlIn.close();
			urlCon.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
}
