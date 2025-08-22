package sansan.tool.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sansan.tool.DTO.ExceptionDTO;
import sansan.tool.Service.TelegramService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Resource
    private TelegramService telegramService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleException(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        // Lấy thông tin API đang gọi
        String uri = request.getRequestURI();
        telegramService.sendException(e.getMessage(), uri);

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SanException.class)
    public ResponseEntity<ExceptionDTO> handleSanException(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage());
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        // Send error message to Telegram
        String uri = request.getRequestURI();
        telegramService.sendException(e.getMessage(), uri);
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
