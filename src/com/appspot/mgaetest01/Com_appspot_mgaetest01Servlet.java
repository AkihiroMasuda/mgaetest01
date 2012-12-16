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
		String query = req.getParameter("q");
		String rpp = req.getParameter("rpp");
		
		resp.setContentType("text/plain;");
		
//		final String strUrl = "https://api.twitter.com/1.1/search/tweets.json?q=horiday";		
//		final String strUrl = "https://api.twitter.com/1.1/search/tweets.json?q=%23freebandnames&since_id=24012619984051000&max_id=250126199840518145&result_type=mixed&count=4";
		String strUrl = "http://search.twitter.com/search.json?";
		if (query!=null){
			strUrl += "q=" + query;
		}else{
			strUrl += "q=blue%20angels";
		}
		if (rpp!=null){
			strUrl += "&rpp=" + rpp;
		}else{
			strUrl += "&rpp=5";
		}
		strUrl +=  "&include_entities=true&result_type=mixed";
		String result = exeGET(strUrl);
		
		req.setAttribute("geturl", strUrl);
		req.setAttribute("jsonres", result);
		showHtml("/WEB-INF/index.jsp", req, resp);
	}

	// pathで指定したHTMLまたはjspファイルをクライアントに表示
	private void showHtml(String path, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
//		RequestDispatcher rd = getServletC�@ontext().getRequestDispatcher("/myindex.html");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	// strUrlへのGET発行。結果をStringで返す。
	private String exeGET(String strUrl)
			throws IOException {
		URL urlObj;
		String ret = new String("");
		try {
			urlObj = new URL(strUrl);
			// URLへのGET発行
			HttpURLConnection urlCon = (HttpURLConnection)urlObj.openConnection();
			urlCon.setRequestMethod("GET");
			BufferedReader urlIn = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			// String形式で結果を取得
			String tmp = new String();
			while((tmp = urlIn.readLine()) != null){
				ret = ret + tmp;
			}
			// URL閉じる
			urlIn.close();
			urlCon.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		return ret;
	}
	
	// bodyで渡した文字列をクライアントに表示
	private void showString(String body, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.write(body);
	}
	
}
