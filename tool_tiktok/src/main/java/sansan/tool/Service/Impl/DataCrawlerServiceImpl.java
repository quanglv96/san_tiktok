package sansan.tool.Service.Impl;

import org.springframework.stereotype.Service;
import sansan.tool.Client.ShoplusClient;
import sansan.tool.DTO.ShoplusDTO.ResLogin;
import sansan.tool.Service.DataCrawlerService;

import javax.annotation.Resource;
@Service
public class DataCrawlerServiceImpl implements DataCrawlerService {
    @Resource
    private ShoplusClient shoplusClient;

    @Override
    public ResLogin login() {
        return shoplusClient.getLogin();
    }
}
