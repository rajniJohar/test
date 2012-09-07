package android.ApptorneyPac;

import java.util.ArrayList;

public class SitesList {

	private ArrayList<String> type = new ArrayList<String>();
	private ArrayList<String> title=new ArrayList<String>();
	private ArrayList<String> child=new ArrayList<String>();
	private String parent;
	private ArrayList<String> url=new ArrayList<String>();
	
	public ArrayList<String> getUrl()
	{
		return url;
	}
	public String getParent()
	{
		return parent;
	}
	public ArrayList<String> getType()
	{
		return type;
	}
	public ArrayList<String> getTitle()
	{
		return title;
	}
	public ArrayList<String> getChild()
	{
		return child;
	}
	public void setUrl(String url)
	{
		this.url.add(url);
	}
	public void setParent(String parent)
	{
		this.parent=parent;
		//this.parent.add(parent);
	}
	public void setType(String type)
	{
		this.type.add(type);
	}
	public void setTitle(String title)
	{
		this.title.add(title);
	}
	public void setChild(String child)
	{
		this.child.add(child);
	}
	
}
