package com.chenjf.test;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chenjf.util.jsoup.JdbcUtils;

public class JsoupTest {

	public static void main(String[] args) {
		JsoupTest test = new JsoupTest();
		//test.index();
		test.city("50", "50.html");
		//test.county("510800000000", "51/5108.html");
	}

	public void index() {
		JdbcUtils dbtool = new JdbcUtils();
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/index.html";
		String sql = "";
		String id = "";
		String nexthtmlpath = "";
		try {
			Document doc = Jsoup.parse(new URL(url), 1000);
			//dbtool.executeSql("delete from area");
			Elements links = doc.getElementsByTag("a");
			for (Element link : links) {
				String linkHref = link.attr("href");
				String linkText = link.text();
				if (linkHref.indexOf(".html") > 0) {
					id = linkHref.replace(".html", "");
					int num=Integer.valueOf(id);
					if(num==32) {
					nexthtmlpath = linkHref;
					sql = "insert into area(id,pid,areaname,htmlpath) values(" + id + ",'0','" + linkText + "','"
							+ nexthtmlpath + "')";
					System.out.println(sql);
					dbtool.executeSql(sql);
					//city(id, nexthtmlpath);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void city(String pid, String htmlpath) {
		JdbcUtils dbtool = new JdbcUtils();
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + htmlpath;
		String sql = "";
		String id = "", areaname = "";
		String linkhref = "";
		try {
			Document doc = Jsoup.parse(new URL(url), 1000);
			Elements citytr = doc.getElementsByClass("citytr");// 城市
			for (Element tr : citytr) {
				Elements links = tr.getElementsByTag("a");
				id = links.first().text();
				linkhref = links.first().attr("href");
				areaname = links.last().text();
				sql = "insert into area(id,pid,areaname,htmlpath) values(" + id + ",'" + pid + "','" + areaname + "','"
						+ linkhref + "')";
				System.out.println(sql);
				dbtool.executeSql(sql);
				county(id, linkhref);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void county(String pid, String htmlpath) {
		JdbcUtils dbtool = new JdbcUtils();
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + htmlpath;
		String sql = "";
		String id = "", areaname = "";
		String linkhref = "";
		try {
			//Document doc = Jsoup.parse(new URL(url), 1000);
			Document doc =Jsoup.connect(url).get();
			Elements trs = doc.getElementsByClass("countytr");// 区/县
			for (Element tr : trs) {
				Elements links = tr.getElementsByTag("a");
				if(links.first()!=null) {
					id = links.first().text();
					linkhref = links.first().attr("href");
					areaname = links.last().text();
					linkhref = htmlpath.substring(0, htmlpath.indexOf("/")) + "/" + linkhref;
					sql = "insert into area(id,pid,areaname,htmlpath) values(" + id + ",'" + pid + "','" + areaname + "','"
						+ linkhref + "')";
					System.out.println(sql);
					dbtool.executeSql(sql);
					town(id, linkhref);
				}
			}
		} catch (Exception e) {
			System.out.println(url);
			e.printStackTrace();
		}
	}

	public void town(String pid, String htmlpath) {
		JdbcUtils dbtool = new JdbcUtils();
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + htmlpath;
		String sql = "";
		String id = "", areaname = "";
		String linkhref = "";
		try {
			Document doc =Jsoup.connect(url).get();
			Elements trs = doc.getElementsByClass("towntr");// 镇/街道
			for (Element tr : trs) {
				Elements links = tr.getElementsByTag("a");
				id = links.first().text();
				linkhref = links.first().attr("href");
				areaname = links.last().text();
				linkhref = htmlpath.substring(0, htmlpath.lastIndexOf("/")) + "/" + linkhref;
				sql = "insert into area(id,pid,areaname,htmlpath) values(" + id + ",'" + pid + "','" + areaname + "','"
						+ linkhref + "')";
				System.out.println(sql);
				dbtool.executeSql(sql);
				Thread.sleep(1000); // 设置暂停的时间1 秒
				village(id, linkhref);
			}
		} catch (Exception e) {
			System.out.println(url);
			e.printStackTrace();
		}
	}

	public void village(String pid, String htmlpath) {
		JdbcUtils dbtool = new JdbcUtils();
		String url = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/" + htmlpath;
		String sql = "";
		String id = "", areaname = "";
		try {
			sql = "select count(1) num from area where pid='" + pid + "'";
			int count = dbtool.query(sql);
			if (count == 0) {
				Document doc = Jsoup.parse(new URL(url), 1000);
				Elements villagetr = doc.getElementsByClass("villagetr");// 城市
				for (Element tr : villagetr) {
					Elements tds = tr.getElementsByTag("td");
					id = tds.first().text();
					areaname = tds.last().text();
					sql = "insert into area(id,pid,areaname) values(" + id + ",'" + pid + "','" + areaname + "')";
					dbtool.executeSql(sql);
					
				}
			}
		} catch (Exception e) {
			System.out.println(url);
			e.printStackTrace();
		}
	}
}
