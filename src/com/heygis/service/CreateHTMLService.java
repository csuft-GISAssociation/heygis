package com.heygis.service;

import java.util.List;
import java.util.Random;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceThree;

public class CreateHTMLService {
	public String createHTML(List list,String sourceType){
		if(sourceType.equals("3")){
			List<SourceThree> li = list;
			String html = "";
			for(SourceThree sourceThree : li){
				String st = "style"+(new Random().nextInt(5)+1);
				String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
				html += "<article class="+st+">";
				html += " <span class='image'>";
				html += "<img src="+bg+" alt='' />";
				html += "</span>";
				html += "<div class='detail'>";
				html += "<h2>"+sourceThree.getName()+"</h2>";
				html += "<h4>下载次数:"+sourceThree.getDownload_times()+"</h4>";
				html += "<h5>文件大小:"+sourceThree.getFile_size()+"</h5>";
				html += "<h5>上传时间:"+sourceThree.getUpload_time() +"</h5>";
				html += "<div class='content'>";
				html += "<p>"+sourceThree.getIntroduction() +"</p>";
				html += "<a class='btn btn-primary btn-lg' href='"+sourceThree.getDownload_link_offical()+"'>官方下载地址</a> | ";
				html += "<a class='btn btn-primary btn-lg' href='"+sourceThree.getDownload_link()+"'>本站下载地址</a>";
				html += "</div></div></article>";
			}
			return html;
		}
		return null;
		
	}
}
