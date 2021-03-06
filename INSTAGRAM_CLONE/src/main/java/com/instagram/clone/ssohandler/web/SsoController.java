package com.instagram.clone.ssohandler.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.clone.common.properties.ApplicationProperties;
import com.instagram.clone.ssohandler.domain.vo.Response;
import com.instagram.clone.ssohandler.domain.vo.TokenRequestResult;
import com.instagram.clone.ssohandler.service.OAuthService;

@Controller
@RequestMapping("/ssoclient")
public class SsoController implements ApplicationProperties {

	private static final Logger log = LoggerFactory.getLogger(SsoController.class);

	@Autowired
	private OAuthService oauthService;

	private String getOAuthClientId() {
		return SYSTEM_NAME + "_id";
	}

	private String getOAuthRedirectUri() {
		return String.format("http://" + CLIENT_DOMAIN + ":%d/ssoclient/oauthCallback", SERVER_PORT);
	}

	@RequestMapping(value = "/oauthCallback", method = RequestMethod.GET)
	public String oauthCallback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state,
			HttpServletRequest request, ModelMap map) {

		String oauthState = (String) request.getSession().getAttribute("oauthState");
		request.getSession().removeAttribute("oauthState");
		log.debug("\n## code, oauthState, state : " + code + "," + oauthState + "," + state);

		TokenRequestResult tokenRequestResult = null;

		if (oauthState == null || oauthState.equals(state) == false) {

			tokenRequestResult = new TokenRequestResult();
			tokenRequestResult.setError("not matched state");
		} else {

			tokenRequestResult = oauthService.requestAccessTokenToAuthServer(code, request);
		}

		if (tokenRequestResult.getError() == null) {

			return "redirect:/feed/";
		} else {

			map.put("result", tokenRequestResult);
			return "/feed/";
		}
	}

	@RequestMapping(value = "/sso", method = RequestMethod.GET)
	public String sso(HttpServletRequest request) {

		System.out.println("----------------------------------------/sso-----------------------------");

		String state = UUID.randomUUID().toString();
		request.getSession().setAttribute("oauthState", state);

		StringBuilder builder = new StringBuilder();
		builder.append("redirect:");
		builder.append("http://" + SSO_DOMAIN + ":" + SSO_SERVER_PORT + "/oauth/authorize");
		builder.append("?response_type=code");
		builder.append("&client_id=");
		builder.append(getOAuthClientId());
		builder.append("&redirect_uri=");
		builder.append(getOAuthRedirectUri());
		builder.append("&scope=");
		builder.append("read");
		builder.append("&state=");
		builder.append(state);

		System.out.println(builder.toString());
		return builder.toString();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:http://" + SSO_DOMAIN + ":" + SSO_SERVER_PORT + "/userLogout?clientId=" + getOAuthClientId();
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public Response logoutFromAuthServer(@RequestParam(name = "tokenId") String tokenId,
			@RequestParam(name = "userName") String userName) {

		Response response = oauthService.logout(tokenId, userName);

		log.debug("\n## logout secceeded {}", userName);
		System.out.println("\n## logout secceeded " + userName);
		return response;
	}

}
