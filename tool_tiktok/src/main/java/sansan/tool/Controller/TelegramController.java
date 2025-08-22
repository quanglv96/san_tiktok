package sansan.tool.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansan.tool.DTO.RequestDTO;
import sansan.tool.Service.TelegramService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/telegram")
public class TelegramController {

    @Resource
    private TelegramService telegramService;
    @PostMapping("/send-message-admin")
    public String sendMessageAdmin(@RequestBody RequestDTO requestDTO) {
        telegramService.sendException(requestDTO.getMessage(), requestDTO.getUrl());
        return "Message sent successfully!";
    }
}
