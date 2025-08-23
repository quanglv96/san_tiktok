package sansan.tool.Client;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sansan.tool.Config.AppConfig;
import sansan.tool.Config.SanException;
import sansan.tool.DTO.ShoplusDTO.ReqLogin;
import sansan.tool.DTO.ShoplusDTO.ResLogin;
import sansan.tool.utils.CommonUtils;
import sansan.tool.utils.KeyConfig;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class ShoplusClient {

    @Resource
    private RestTemplate restTemplate;
    private ResLogin resLogin;

    private ResLogin login(){
        String url = AppConfig.SHOPLUS.get(KeyConfig.URL_LOGIN);
        String body = AppConfig.SHOPLUS.get(KeyConfig.BODY_LOGIN);
        ReqLogin reqLogin = CommonUtils.convertJsonToObject(body, ReqLogin.class);
        if (reqLogin == null) {
            throw new SanException("Failed to parse login request body");
        }
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ReqLogin> httpEntity = new HttpEntity<>(reqLogin, header);
        ResponseEntity<ResLogin> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, ResLogin.class);
        if(ObjectUtils.isEmpty(response)
                || ObjectUtils.isEmpty(response.getBody())
                || !response.getBody().getSuccess()
                || ObjectUtils.isEmpty(response.getBody().getData())
                || ObjectUtils.isEmpty(response.getBody().getData().getToken())){
            throw new SanException("Login failed, response is empty");
        }
        resLogin = response.getBody();
        resLogin.setExpired(LocalDateTime.now().plusDays(5)); // Set expiration date to 5 days ago
        return response.getBody();
    }

    public ResLogin getLogin() {
        if (ObjectUtils.isEmpty(resLogin) || resLogin.getExpired().isBefore(LocalDateTime.now())) {
            return login();
        }
        return resLogin;
    }
}