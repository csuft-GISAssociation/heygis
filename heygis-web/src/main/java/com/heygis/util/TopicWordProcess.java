package com.heygis.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 待修改，迁移到service里最好
 */
public class TopicWordProcess {
//	public static void main(String []args){
//		String word = "aaaaaa\nbbbbbb\nvvvvvvv\nccccccc\n<pre class='prettyprint'>\n</pre>\nsssssss\ndddddd\nccccccc\n<pre class='prettyprint'>\n</pre>\nsssssss\ndddddd";
//		String s= process(word,word.indexOf("<pre class"));
//		System.out.println(s);
////		System.out.println(word.indexOf("</pre",113));
//	}
	public static String process(String word,int b0){
		word = word.substring(0, b0).replaceAll("\n","<br>") + word.substring(b0, word.length());
		Stack<pre> b = new Stack<pre>();
		int i,ifinally = b0, i1 = word.length()+10,i2 = word.length()+10;
		pre pb;
		for(i = 0;(i= min((i1=word.indexOf("<pre cl",i+1)),(i2=word.indexOf("</pre>",i+1))))>0 ;){
			if(i1<i2&&i1!=-1){
				if(!b.empty()){
					//System.out.println("b.peek().i"+b.peek().i);
					//System.out.println("b.peek().posi"+b.peek().posi);
					if(b.peek().i==2 && b.peek().posi<i1){
						pb = b.peek();
						int oldlength = word.length();
						word=word.substring(0, pb.posi)
								+word.substring(pb.posi, i1).replaceAll("\n","<br>")
								+word.substring(i1, word.length());
						i += word.length() - oldlength;
					}
				}
				b.push(new pre(1,i1));
			}
			else{
				b.push(new pre(2,i2+6));
			}
			ifinally = i;
			//System.out.println(i);
		}
//		if(i1>i2)i=i1;
//		else i=i2;
		word =  word.substring(0,ifinally) + word.substring(ifinally, word.length()).replaceAll("\n","<br>");
		return word;
	}
	static int min(int a, int b){
		if(a==-1&&b!=-1) return b;
		if(a!=-1&&b==-1) return a;
		if(a<b) return a;
		else return b;
	}
}
class pre{
	int i;
	int posi;
	public pre(int _i,int _posi){
		this.i=_i;
		this.posi=_posi;
	}
}
