package text_n;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class Readxml {
	private static DocumentBuilderFactory dbFactory = null;
	private static DocumentBuilder db = null;
	private static Document document = null;
	private static List<Han_dynasty> emperors = null;

	static {
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			db = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static List<Han_dynasty> getEmperors(String fileName) throws Exception {
		// ������ URI �����ݽ���Ϊһ�� XML �ĵ�,������Document����
		document = db.parse(fileName);
		// ���ĵ�˳�򷵻ذ������ĵ����Ҿ��и���������Ƶ����� Element �� NodeList
		NodeList emperorsList = document.getElementsByTagName("emperor");
		emperors = new ArrayList<Han_dynasty>();
		// ����emperors
		for (int i = 0; i < emperorsList.getLength(); i++) {
			Han_dynasty emperor = new Han_dynasty();
			// ��ȡ��i��emperor���
			org.w3c.dom.Node node = emperorsList.item(i);
			// ��ȡ��i��emperor����������
			NamedNodeMap namedNodeMap = node.getAttributes();
			// ��ȡ��֪��Ϊid������ֵ
			String id = namedNodeMap.getNamedItem("id").getTextContent();
			emperor.setId(id);

			// ��ȡemperor�����ӽڵ�,������Test���͵Ļ���
			NodeList cList = node.getChildNodes();

			// ��һ��emperor��������Լ�������
			ArrayList<String> contents = new ArrayList<>();

			for (int j = 1; j < cList.getLength(); j += 2) {

				org.w3c.dom.Node cNode = cList.item(j);
				String content = cNode.getFirstChild().getTextContent();
				contents.add(content);
				//System.out.println(cList.getLength());
			}

			emperor.setName(contents.get(0));
			emperor.setPosthumous_title(contents.get(1));
			emperor.setReign(Integer.parseInt(contents.get(2)));

			emperors.add(emperor);
		}

		return emperors;

	}

	public static void main(String args[]) {
		String fileName = "src/text_n/Han_dynasty.xml";
		try {
			List<Han_dynasty> list = Readxml.getEmperors(fileName);
			for (Han_dynasty emperor : list) {
				System.out.println(emperor);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
