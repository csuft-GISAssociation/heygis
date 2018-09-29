package com.heygis.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.heygis.dto.ForumPost;
import com.heygis.dto.ForumPostPage;
import com.heygis.dto.ForumsThreadPage;
import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;
import com.heygis.dao.ForumPostDAOImpl;
import com.heygis.dao.ForumThreadDAOImpl;
import com.heygis.service.AddPostService;
import com.heygis.service.SourceServie;

/**
 * @author RC
 *
 */
public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//		String s = "<pre class='prettyprint'>#include<stdio.h>}}for(j=0;j<=count-1;j++)printf(,a[j]);}</pre>";
//		System.out.println(s.indexOf("pre class='prettyprint'"));
		
		//System.out.println(new UserDAOImpl().EncoderByMd5("123456"));
}
	/**
	 * getThreasPage测试
	 */
	public static void threadPageTest(){
		ForumsThreadPage ftp = new ForumThreadDAOImpl().getThreadPage(1, 1);
		for(int i=0;i<5;i++){
			if(ftp.getThread(i) == null){
				System.out.println("break");
				break;
				}
			System.out.println(ftp.getThread(i).getAuthor());
			System.out.println(ftp.getThread(i).getAuthorAuthor());
		}
//		System.out.println(fpp.getPost(5).getMessage());
	}
	/**
	 * addThread测试
	 */
	public static void addThread(){
//		addthread测试
//		new ForumThreadDAOImpl().addThread(new ForumThread(0, 1, 1, 1, "sa", 1, "@qq.com", "diyiceshitie", new Date(),new Date(),"", 0, 0, 0, 0, 0, 0));
	}
	/**
	 * addPost测试
	 */
	public static void addpost2(){
//		addpost测试
//		ForumPost post = new ForumPost(0, 1, 3, 0, "sm", 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0);
//		addPost(post);
		Thread mt = new myThread(new ForumPost(0, 1, 3, 0, "sm1", 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0));
		Thread mt2 = new myThread(new ForumPost(0, 1, 3, 0, "sz2", 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0));
		Thread mt3 = new myThread(new ForumPost(0, 1, 3, 0, "sm3", 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0));
		Thread mt4 = new myThread(new ForumPost(0, 1, 3, 0, "sz4", 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0));
		mt.start();
		mt2.start();
		mt3.start();
		mt4.start();
		for(int i=0;i<10;i++){
			new myThread(new ForumPost(0, 1, 3, 0, "sz-"+i, 0, "1018@qq.com", "ceshi1", new Date(), "ceshi1", "127.0.0.1", 2, 0)).start();
		}
	}
	/**
	 * addPost测试
	 */
	public static void addPost(ForumPost post){
		ForumPostDAOImpl fpdi = new ForumPostDAOImpl();
		if(fpdi.addPost(post) != 0){
			System.out.println("ok");
		}else{
			System.out.println("no");
		}
	}
	/**
	 * getPostPage测试
	 */
	public static void postPageTest(){
		ForumPostPage fpp = new ForumPostDAOImpl().getPostPage(3, 1);
		for(int i=0;i<5;i++){
			if(fpp.getPost(i) == null){
				System.out.println("break");
				break;
				}
			System.out.println(fpp.getPost(i).getPosition());
			System.out.println(fpp.getPost(i).getMessage());
		}
//		System.out.println(fpp.getPost(5).getMessage());
	}
	/**
	 * source模块测试
	 */
	public static void souceTest(){
		SourceServie ss = new SourceServie();
		System.out.println("1");
		List<SourceOne> li = ss.getSourceOneList();
		System.out.println("11");
		List<SourceTwo> lii = ss.getSourceTwoList();
		System.out.println("111");
		List<SourceThree> liii = ss.getSourceThreeList();
		List<SourceFour> l = ss.getSourceFourList();
		System.out.println(li.size());
		System.out.println(lii.size());
		System.out.println(liii.size());
		System.out.println(l.size());
	}

}
class myThread extends Thread{
	ForumPost post = null;
	myThread(ForumPost post){
		this.post = post;
	}
	@Override
	public void run() {
		AddPostService aps = AddPostService.getInstance();
		aps.getFpdi().addPost(post);
	}
	
}
