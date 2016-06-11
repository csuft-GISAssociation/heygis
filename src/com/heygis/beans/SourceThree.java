package com.heygis.beans;


public class SourceThree extends Source{
	private String name;
	private String introduction;
	private String file_size;
	private String download_link;
	private String download_link_offical;
	private String icon;
	private boolean cracking;
	private String upload_time;
	private long download_times;
	public SourceThree(){
		this.type = 3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	public String getDownload_link() {
		return download_link;
	}
	public void setDownload_link(String download_link) {
		this.download_link = download_link;
	}
	public String getDownload_link_offical() {
		return download_link_offical;
	}
	public void setDownload_link_offical(String download_link_offical) {
		this.download_link_offical = download_link_offical;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isCracking() {
		return cracking;
	}
	public void setCracking(boolean cracking) {
		this.cracking = cracking;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public long getDownload_times() {
		return download_times;
	}
	public void setDownload_times(long download_times) {
		this.download_times = download_times;
	}
	
}
