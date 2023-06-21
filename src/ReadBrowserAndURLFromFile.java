import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

// this class is using to read the browser type and the Site URL from external file
// the file called "browserAndUrl.xml" that attached to this project and in my case i located it at: C:\Automation\ForProject\browserAndUrl.xml

public class ReadBrowserAndURLFromFile {



    public static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Users\\avivit\\Documents\\GitHub\\BuyMeProject\\browserAndUrl.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}




