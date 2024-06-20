package DataTest.demo.Config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class WebClientConfig {
    @Value("${child.center.baseurl}")
    private String child_center_baseUrl;
    @Value("${care.edu.baseurl}")
    private String care_edu_baseUrl;
    @Value("${press.news.baseurl}")
    private String press_news_baseurl;
    @Value("${policy.news.baseurl}")
    private String policy_news_baseurl;
    @Bean
    @Qualifier("childCenterWebClient")
    public WebClient childCenterWebClient() {
        return WebClient.builder()
            .baseUrl(child_center_baseUrl)
            .build();
    }
    @Bean
    @Qualifier("PolicyNewsWebClient")
    public WebClient policyNewsWebClient() {
        return WebClient.builder()
            .baseUrl(policy_news_baseurl)
            .build();
    }
    @Bean
    @Qualifier("PressNewsWebClient")
    public WebClient pressNewsWebClient() {
        return WebClient.builder()
            .baseUrl(press_news_baseurl)
            .build();
    }
    @Bean
    @Qualifier("careEduWebClient")
    public WebClient careEduWebClient() {
        return WebClient.builder()
            .baseUrl(care_edu_baseUrl)
            .build();
    }
}