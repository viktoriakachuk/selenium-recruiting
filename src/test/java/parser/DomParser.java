package parser;

import entity.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser {
    public User parseUser(String role){
        User user = new User();
        try
        {
            File xmlFile = new File("loginuser.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
            for(int tmp = 0; tmp < nodeList.getLength(); tmp++)
            {
                Node node = nodeList.item(tmp);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element)node;
                    if (element.getAttribute("name").equals(role))
                    {
                        String login = element.getElementsByTagName("login").item(0).getChildNodes().item(0).getNodeValue();
                        String password = element.getElementsByTagName("password").item(0).getChildNodes().item(0).getNodeValue();
                        user.setRole(role);
                        user.setLogin(login);
                        user.setPassword(password);
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return user;
    }
}
