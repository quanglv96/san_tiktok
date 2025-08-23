package sansan.tool.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansan.tool.DTO.ShoplusDTO.ResLogin;
import sansan.tool.Service.DataCrawlerService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/data-crawler")
public class DataCrawlerController {

    @Resource
    private DataCrawlerService dataCrawlerService;

    @GetMapping("/login-shoplus")
    public ResLogin loginShoplus() {
       return dataCrawlerService.login();
    }
}
