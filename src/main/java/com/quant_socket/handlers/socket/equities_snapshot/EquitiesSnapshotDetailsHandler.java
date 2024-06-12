package com.quant_socket.handlers.socket.equities_snapshot;

import com.quant_socket.services.EquitiesSnapshotService;
import com.quant_socket.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;

@Component
@Slf4j
@RequiredArgsConstructor
public class EquitiesSnapshotDetailsHandler extends TextWebSocketHandler {

    private final EquitiesSnapshotService service;

    private String isinCode;

    @Override
    public void afterConnectionEstablished(WebSocketSession ws) throws Exception {
        final URI uri = ws.getUri();
        if(uri != null && uri.getQuery() != null) {
            isinCode = service.getQueryValue(uri.getQuery(), "isin_code");
            if(isinCode != null) {
                service.addSession(ws, isinCode);
            }
        } else {
            ws.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession ws, CloseStatus status) throws Exception {
        final URI uri = ws.getUri();
        if(uri != null && uri.getQuery() != null) {
            if(isinCode != null) service.removeSession(ws, isinCode);
        } else {
            ws.close();
        }
    }
}
