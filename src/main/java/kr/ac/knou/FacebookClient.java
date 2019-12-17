package kr.ac.knou;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookClient  {
	
	private final String APP_API_KEY = "2002453880015638";
	private final String APP_SECRET_KEY = "29d88687568da26839acf2b70c8f8ca0";
	private Facebook facebook;


	public void getFaceBookClientInstance(String accessToken) {
		try {
			facebook = new FacebookTemplate(accessToken);
		} catch (Exception e) {
			System.out.println("facebook Instance Error ,, please again from the beginning OAuth certification...");
			new ModelAndView("/social/facebookSignin.do");
		}
	}
	
		@RequestMapping(value="/social/facebook" , method = RequestMethod.GET)
		public void facebookSignin(HttpServletResponse response) throws Exception {
			
			StringBuffer urlsb = new StringBuffer();
			
			String url = "http://www.facebook.com/dialog/oauth?client_id="+
					APP_API_KEY+"&redirect_uri=http://localhost:8080/api/list";
			
			//urlsb.append("redirect:");
			urlsb.append(url);
			
			//return urlsb.toString();
			
			System.out.println("rediresturl : " + urlsb.toString());
			
			response.sendRedirect(urlsb.toString());
		}




}
