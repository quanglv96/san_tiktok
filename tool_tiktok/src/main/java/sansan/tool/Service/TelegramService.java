package sansan.tool.Service;

import sansan.tool.DTO.TelegramDTO.ReceiveMessageDTO;

import java.util.Map;

public interface TelegramService {
    void sendException(String message, String url);
    void sendTransferLink(String link, String traceId);

    void receiveMessage(ReceiveMessageDTO update);
}
