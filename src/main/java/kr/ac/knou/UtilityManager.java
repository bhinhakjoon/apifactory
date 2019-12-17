package kr.ac.knou;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;


public class UtilityManager {
	
	
	public static String callApi(String apiUrl,Map<String, String> parameters){
	    String uploadPath = "/Users/kwakinsuk/git/second/src/main/webapp/resources/";
		try {
		String outline = parameters.get("text");
		String type = parameters.get("type");
		String method = parameters.get("method");
		String clientId = parameters.get("clientId");
		String clientSecret = parameters.get("clientSecret");
    	//after reading file
    	String text = URLEncoder.encode(outline,"UTF-8");
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod(method);
        if(type.equals("naver")){
        	con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        }
        
        // post request
        String postParams = "speaker="+parameters.get("speaker")+"&speed=0&text=" + text;
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(postParams);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        BufferedReader br;
        if(responseCode==200) { // 정상 호출
            InputStream is = con.getInputStream();
            int read = 0;
            byte[] bytes = new byte[1024];
            // 랜덤한 이름으로 mp3 파일 생성
            //String tempname = Long.valueOf(new Date().getTime()).toString();
            String filename = parameters.get("id");
            File f = new File(uploadPath+filename+".mp3");
           // f.createNewFile();
           boolean  bool = f.createNewFile();
            // print
            System.out.println("File created: "+bool);

            OutputStream outputStream = new FileOutputStream(f);
            while ((read =is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            is.close();
            return "/resources/"+filename+".mp3";
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            return "300";
        }
    } catch (Exception e) {
        System.out.println(e);
        return "400";
    }
	
	
		
		
	}
	

}
