package com.instagram.clone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.instagram.clone.common.socket.HttpSessionConfigurator;
import com.instagram.clone.model.vo.MemberVo;

@Controller
@ServerEndpoint(value = "/echo.do", configurator = HttpSessionConfigurator.class)
public class WebSocketChat {

	private static final List<Session> sessionList = new ArrayList<>();

	private Map<Session, EndpointConfig> configMap = Collections.synchronizedMap(new HashMap<>());

	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

	public WebSocketChat() {
		logger.info("----------------------WebSocketChat 객체 생성");
	}

	// handshake가 끝나면 @OnOpen이 호출된다.
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		logger.info("Open session id : " + session.getId());

		// userSession 클래스는 connection이 될 때마다 인스턴스 생성되는 값이기 때문에 키로서 사용할 수 있다.
		if (!configMap.containsKey(session)) {
			configMap.put(session, config);
		}

		// temp
		sessionList.add(session);
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		logger.info("Message From : " + message.split(",")[0] + " : " + message.split(",")[1]);

		if (configMap.containsKey(session)) {
			EndpointConfig config = configMap.get(session);
			HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.Session);

			try {
				final Basic basic = session.getBasicRemote();
				basic.sendText("내가쓴 : " + ((MemberVo) httpSession.getAttribute("login")).getMember_code() + " : " + message);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			sendAllSessionToMessage(session, message);
		}
	}

	// 모두에게 메시지 보내기
	private void sendAllSessionToMessage(Session self, String message) {
		logger.info("sendAllSessionToMessage : " + message.split(",")[0] + " : " + message.split(",")[1]);
		try {
			for (Session session : sessionList) {
				if (!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText("남이쓴 : " + message.split(",")[0] + " : " + message.split(",")[1]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
		System.out.println(session + " : " + e.getMessage());
	}

	@OnClose
	public void onClose(Session session) {
		logger.info("Session " + session.getId() + " has ended");
		sessionList.remove(session);
	}

}
