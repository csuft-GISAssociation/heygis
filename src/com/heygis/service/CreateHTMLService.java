package com.heygis.service;

import java.util.List;
import java.util.Random;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;

public class CreateHTMLService {
	public String createHTML(List list,String sourceType){
		if(sourceType.equals("1")){
			List<SourceOne> li = list;
			String html = "";	
			for(SourceOne sourceOne : li){
				String st = "style"+(new Random().nextInt(5)+1);
				String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
				html += "<article class="+st+">";
				html += " <span class='image'>";
				html += "<img src="+bg+" alt='' />";
				html += "</span>";
				html += "<div class='detail'>";
				html += "<h2>"+sourceOne.getName()+"("+sourceOne.getLevel()+")</h2>";
				html += "<h4>作者:"+sourceOne.getUploader()+"</h4>";
				html += "<h4>下载次数:"+sourceOne.getDownload_times()+"</h4>";
				html += "<h5>文件大小:"+sourceOne.getFile_size()+"</h5>";
				html += "<h5>上传时间:"+sourceOne.getUpload_time() +"</h5>";
				html += "<div class='content'>";
				html += "<p>"+sourceOne.getIntroduction() +"</p>";
				html += "<a class='btn btn-primary btn-lg' href='"+sourceOne.getDownload_link()+"'>本站下载地址</a>";
				html += "</div></div></article>";
			}
			return html;
		}
		if(sourceType.equals("2")){
			List<SourceTwo> li = list;
			String html = "";	
			for(SourceTwo sourceTwo : li){
				String st = "style"+(new Random().nextInt(5)+1);
				String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
				html += "<article class="+st+">";
				html += " <span class='image'>";
				html += "<img src="+bg+" alt='' />";
				html += "</span>";
				html += "<div class='detail'>";
				html += "<h2>"+sourceTwo.getName()+"</h2>";
				html += "<h4>作者:"+sourceTwo.getUploader()+"</h4>";
				html += "<h4>下载次数:"+sourceTwo.getDownload_times()+"</h4>";
				html += "<h5>文件大小:"+sourceTwo.getFile_size()+"</h5>";
				html += "<h5>上传时间:"+sourceTwo.getUpload_time() +"</h5>";
				html += "<div class='content'>";
				html += "<p>"+sourceTwo.getIntroduction() +"</p>";
				html += "<a class='btn btn-primary btn-lg' href='"+sourceTwo.getDownload_link()+"'>本站下载地址</a>";
				html += "</div></div></article>";
			}
			return html;
		}
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
				html += "<a class='btn btn-primary btn-md' href='"+sourceThree.getDownload_link_offical()+"'>官方下载地址</a> | ";
				html += "<a class='btn btn-primary btn-md' href='"+sourceThree.getDownload_link()+"'>本站下载地址</a>";
				html += "</div></div></article>";
			}
			return html;
		}
		if(sourceType.equals("4")){
			List<SourceFour> li = list;
			String html = "";	
			for(SourceFour sourceFour : li){
				String st = "style"+(new Random().nextInt(5)+1);
				String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
				html += "<article class="+st+">";
				html += " <span class='image'>";
				html += "<img src="+bg+" alt='' />";
				html += "</span>";
				html += "<div class='detail'>";
				html += "<h2>"+sourceFour.getName()+"</h2>";
				html += "<h4>下载次数:"+sourceFour.getDownload_times()+"</h4>";
				html += "<h5>文件大小:"+sourceFour.getFile_size()+"</h5>";
				html += "<h5>上传时间:"+sourceFour.getUpload_time() +"</h5>";
				html += "<div class='content'>";
				html += "<p>"+sourceFour.getIntroduction() +"</p>";
				html += "<a class='btn btn-primary btn-lg' href='"+sourceFour.getDownload_link()+"'>本站下载地址</a>";
				html += "</div></div></article>";
			}
			return html;
		}
		return null;
		
	}
}
