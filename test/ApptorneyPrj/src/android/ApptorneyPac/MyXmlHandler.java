package android.ApptorneyPac;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyXmlHandler extends DefaultHandler{

	Boolean currentElement=false;
	String currentValue=null;
	public static SitesList sitesList=null;
	public static SitesList getSitesList()
	{
		return sitesList;
	}
	public static void setSitesList(SitesList sitesList)
	{
		MyXmlHandler.sitesList=sitesList;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		currentElement = true;

		if (localName.equals("root_menu"))
		{
		
		sitesList = new SitesList();
		String Parent=attributes.getValue("parent");
		sitesList.setParent(Parent);
		} else if (localName.equals("menu_item")) {
		
		String Type = attributes.getValue("type");
		sitesList.setType(Type);
		String Title=attributes.getValue("title");
		sitesList.setTitle(Title);
		String Child=attributes.getValue("child");
		sitesList.setChild(Child);
		String Url=attributes.getValue("url");
		sitesList.setUrl(Url);
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		currentElement = false;
		if (localName.equalsIgnoreCase("menu_item"))
		{
			
		}
		else
		{
			
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if (currentElement) {
			currentValue = new String(ch, start, length);
			currentElement = false;
			}
	}
}
