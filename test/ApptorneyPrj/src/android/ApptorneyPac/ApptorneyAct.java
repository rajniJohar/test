package android.ApptorneyPac;

import java.net.URL;

import javax.security.auth.PrivateCredentialPermission;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.AdapterView.OnItemClickListener;

public class ApptorneyAct extends Activity {
	SitesList sitesList=null;
	ListView lv;
	Button backBtn;
	
	//static int counter=0;
	final String str="http://www.apptorney.com/iphone/xml/ip";
    String str1="main.xml";
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        backBtn=(Button)findViewById(R.id.backBtn);
        Log.e("","b4 try");
        lv=(ListView)findViewById(R.id.listView1);  
       
        sitesList=parsefunc(str1);
        listbind(sitesList);
               
	}
	private void listbind(SitesList sitesList2) {
		// TODO Auto-generated method stub
		
		final String ar_title[]=new String[sitesList.getTitle().size()];
        final String ar_type[]=new String[sitesList.getType().size()];
        final String ar_child[]=new String[sitesList.getChild().size()];
        final String ar_url[]=new String[sitesList.getUrl().size()];
        final String ar_parent;
        
        for(int i=0; i<sitesList.getTitle().size(); i++)
		{
        		ar_title[i]= sitesList.getTitle().get(i);
        		System.out.println("----"+ar_title[i]);
        		ar_type[i]=sitesList.getType().get(i);
        		System.out.println("-------" +ar_type[i]);
        		ar_child[i]=sitesList.getChild().get(i);
        		ar_url[i]=sitesList.getUrl().get(i);
        		
		}
        ar_parent=sitesList.getParent();
    	System.out.println("++++++++++++++"+ar_parent);
    	ArrayAdapter< String> adapter=new ArrayAdapter<String>(this,R.layout.list,R.id.listItems,ar_title);
    	lv.setAdapter(adapter);
    	lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    //	lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ar_title));
    	
    	lv.setOnItemClickListener(new OnItemClickListener() {
        	
        	String childnode;
        	
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				System.out.println("-----"+ar_type[position]);
				if(ar_type[position].contentEquals("node"))
				{
				System.out.println("" + ar_type[position]);
				childnode=ar_child[position];
				sitesList=parsefunc(childnode);
				listbind(sitesList);
				}
				else if(ar_type[position].contentEquals("link"))
				{
					childnode=ar_url[position];
					System.out.println("+++++++++" +childnode);
					
					Intent intent=new Intent(ApptorneyAct.this,webviewAct.class);
					intent.putExtra("str", childnode);
					startActivity(intent);
									
					/*Intent intent=new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(childnode));
					startActivity(intent);*/
				}
				else if(ar_type[position].contentEquals("mailapp"))
				{
					
				}
				else
				{
					System.out.println("------------end");
				}
				 backBtn.setVisibility(View.VISIBLE);
			}
			
		}
        );
       
       
        backBtn.setOnClickListener(new OnClickListener() {
	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		if(ar_parent.contentEquals(str1))
        				{
        			
        					startActivity(new Intent(ApptorneyAct.this,ApptorneyAct.class));
        				}
        		else{
        		System.out.println("---------------------" );
        		sitesList=parsefunc(ar_parent);
        		listbind(sitesList);
        		}
        		
        }});}
        
    	

	private SitesList parsefunc(String str2) {
		
		final String str="http://www.apptorney.com/iphone/xml/ip";
		String parent=str + "/" +str2;
		// TODO Auto-generated method stub
		 try
	        {
	        	SAXParserFactory spf=SAXParserFactory.newInstance();
	        	SAXParser sp=spf.newSAXParser();
	        	XMLReader xr=sp.getXMLReader();
	        	URL sourceUrl=new URL(parent);
	        	//URL sourceUrl=new URL("http://www.apptorney.com/iphone/xml/ip/main.xml");
	        	Log.e("", "in try");
	        	MyXmlHandler myXmlHandler=new MyXmlHandler();
	        	xr.setContentHandler(myXmlHandler);
	        	xr.parse(new InputSource(sourceUrl.openStream()));
	        	Log.e("", "after parsing");
	        }
	        catch (Exception e) {
				// TODO: handle exception
	        	System.out.println("XML Parsing Excpetion = " + e);
			}
	      
	        return sitesList=MyXmlHandler.sitesList;
	}

}
/* for(int i=0; i<sitesList.getType().size(); i++)
{
   		ar_type[i]=sitesList.getType().get(i);
   		System.out.println("-------" +ar_type[i]);
}
for(int i=0; i<sitesList.getChild().size(); i++)
{
		ar_child[i]=sitesList.getChild().get(i);
		System.out.println("-------" +ar_child[i]);
}
for(int i=0; i<sitesList.getUrl().size(); i++)
{
		ar_url[i]=sitesList.getUrl().get(i);
}
*/	
        


    
    
    

	