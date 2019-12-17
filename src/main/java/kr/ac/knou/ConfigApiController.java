package kr.ac.knou;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/*")
public class ConfigApiController {
	
	@Autowired
	ConfigApiService apiService;

	
	@RequestMapping("list")
	public String list(ModelMap model){
		List<ConfigApi> list = apiService.list();
		model.addAttribute("lists",list);
		return "list";
		
	}
	
	@RequestMapping("form")
	public String form(){
		return "form";
	}
	
	
	@RequestMapping("save")
	public String save(@ModelAttribute ConfigApi api,@ModelAttribute TtsAttr ttsAttr) throws JsonProcessingException{
		
		apiService.create(api);
		
		if(ttsAttr!=null){
			String url = api.getUrl();
			Map<String,String> params = new ConcurrentHashMap<String,String>();
			params.put("id", api.getId());
			params.put("text", ttsAttr.getText());
			params.put("type", api.getType());
			params.put("method", "POST");
			params.put("clientId", api.getClientId());
			params.put("clientSecret", api.getClientSecret());
			params.put("speaker", ttsAttr.getSpeaker());
			String req = UtilityManager.callApi(url, params);
			ttsAttr.setFilePath(req);
			ObjectMapper mapper = new ObjectMapper();
			Object toJson = mapper.writeValueAsString(ttsAttr);
			System.out.println("ddddddd"+toJson.toString());
			apiService.updateAttr(api.getId(), toJson.toString());
		}
		return "redirect:/api/list";
	}
	
	@RequestMapping("read")
	public String retrieve(HttpServletRequest req,ModelMap model) throws JsonParseException, JsonMappingException, IOException{
		String id = req.getParameter("id");
		ConfigApi api = apiService.retrieve(id);
		Object obj = apiService.readAttr(id);
		if(obj != null){
			ObjectMapper mapper = new ObjectMapper();
			TtsAttr attr = mapper.readValue(obj.toString(), TtsAttr.class);	
			model.addAttribute("attr", attr);
		}
		
		model.addAttribute("api",api);
		
		return "form";
		
	}
	
	@RequestMapping("download")
	public ModelAndView callDownload(@RequestParam (value="filePath") String filePath,HttpServletResponse response) throws Exception {
	String root ="/Users/kwakinsuk/git/second/src/main/webapp/";
	File downloadFile = new File(root+filePath);
	
	if(!downloadFile.canRead()){
	    throw new Exception("File can't read(파일을 찾을 수 없습니다)");
	}
	
	return new ModelAndView("fileDownloadView", "downloadFile",downloadFile);
	
	}
	
	@RequestMapping("login.html")
	public String logout(){
		return "redirect:/api/list";
		
	}
}

