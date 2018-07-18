package cn.edu.lingnan.util;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
	private StringBuffer sb =  new StringBuffer();
	private HashMap<String,String> hm = new HashMap<String,String>();
	/**
     * Receive notification of the start of an element.
     *
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the start of
     * each element (such as allocating a new tree node or writing
     * output to a file).</p>
     *
     * @param uri The Namespace URI, or the empty string if the
     *        element has no Namespace URI or if Namespace
     *        processing is not being performed.
     * @param localName The local name (without prefix), or the
     *        empty string if Namespace processing is not being
     *        performed.
     * @param qName The qualified name (with prefix), or the
     *        empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *        there are no attributes, it shall be an empty
     *        Attributes object.
     * @exception org.xml.sax.SAXException Any SAX exception, possibly
     *            wrapping another exception.
     * @see org.xml.sax.ContentHandler#startElement
     */
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
        throws SAXException
    {
       sb.delete(0, sb.length());
    }
    
    public void endElement (String uri, String localName, String qName)
        throws SAXException
    {
    	 hm. put(qName.toLowerCase(),sb.toString().trim());
    }
    
    public void characters (char ch[], int start, int length)
        throws SAXException
    {
        sb.append(ch,start, length);
    }
    
    public HashMap<String,String> getHashMap(){
    	return hm;
    }
}
