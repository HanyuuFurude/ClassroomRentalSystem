package jsontree;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTree {
	public static int ID = 0;

	// 从json文件中读取json字符串
	public String getJsonStr2() {
		Scanner in = new Scanner(System.in);
		System.out.println("输入.json文件位置");
		String filepath = in.nextLine();
		String fileName = String.valueOf(filepath);
		/*
		 * 例如： String fileName =
		 * String.valueOf("C:\\Users\\83723\\Desktop\\IMGS\\data.json");
		 */
		File file = new File(fileName);
		BufferedReader reader = null;
		String jsonStr = "";
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				jsonStr = jsonStr + tempString + "\n";
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return jsonStr;
	}

	public static String unicodeToCn(String unicode) {
		/** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格 */
		String[] strs = unicode.split("\\\\u");
		String returnStr = "";
		// 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
		for (int i = 1; i < strs.length; i++) {
			returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
		}
		return returnStr;
	}

	@SuppressWarnings("rawtypes")
	public void analysisJson(Object objJson, String parent_type, int n) {
		JSONObject jsonObject = (JSONObject) objJson;
		JSONArray arresult = jsonObject.getJSONArray("statusCode");
		int counter = 0;
		while (true) {
			try {
				JSONObject inn = arresult.getJSONObject(counter);
				String no = inn.getString("no");
				String info = inn.getString("info");
				if (no == Integer.toString(counter)) {
					System.out.println(no + " " + info);
				}
				System.out.println(no + " " + info);
				counter++;
			} catch (Exception e) {
				break;
			}
		}
	}

	private static String readString2(String FILE_IN) {
		StringBuffer str = new StringBuffer("");
		File file = new File(FILE_IN);
		try {
			FileReader fr = new FileReader(file);
			int ch = 0;
			while ((ch = fr.read()) != -1) {
				// System.out.print((char) ch);
				str = str.append((char) ch);
			}

			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File reader出错");
		}
		return str.toString();
	}

	// Unicode转中文
	public static byte[] uncompress(byte[] b) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		GZIPInputStream gunzip = new GZIPInputStream(in);
		byte[] buffer = new byte[256];
		int n;
		while ((n = gunzip.read(buffer)) >= 0) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

	public static void main(String[] args) throws IOException {
		JsonTree hw = new JsonTree();
		String File = "statuscode.json";
		String ret = hw.readString2(File);
		// 处理返回的字符串

		JSONObject jsonObject = JSONObject.parseObject(ret);
		/*
		 * 也可以： JSONObject jsonObject = JSONObject.parseObject(hw.getJsonStr2());
		 * 从.json文件中中读取json数据
		 */
		hw.analysisJson(jsonObject, "Object", 33);
		
	}
}
