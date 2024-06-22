package DataTest.demo.Service;

import DataTest.demo.DTO.NewsResponseDTO;
import DataTest.demo.Exception.ApiException;
import DataTest.demo.Exception.Enum.ApiErrorCode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@Service
public class NewsService {

    private static final int PAGE_NO = 1;
    private static final int NUM_OF_ROWS = 10;
    private static final String API_TYPE = "xml";
    private final WebClient policyNewsWebClient;
    private final WebClient pressNewsWebClient;
    private final String serviceKey;

    public NewsService(
        @Value("${private.key}") String serviceKey,
        @Qualifier("PolicyNewsWebClient") WebClient policyNewsWebClient,
        @Qualifier("PressNewsWebClient") WebClient pressNewsWebClient){
        this.serviceKey = serviceKey;
        this.policyNewsWebClient = policyNewsWebClient;
        this.pressNewsWebClient = pressNewsWebClient;
    }
    public List<NewsResponseDTO.NewsDTO> getPolicyNews() {
        NewsResponseDTO responseDTO = policyNewsWebClient.get()
            .uri(uriBuilder -> URI.create(uriBuilder
                .queryParam("pageNo", PAGE_NO)
                .queryParam("numOfRows", NUM_OF_ROWS)
                .queryParam("type", API_TYPE)
                .build() + "&serviceKey=" + serviceKey)) // serviceKey를 직접 추가하여 인코딩을 피함
            .retrieve()
            .bodyToMono(NewsResponseDTO.class)
            .block();

        if (responseDTO != null && responseDTO.getBody().getItem() != null) {
            return responseDTO.getBody().getItem();
        } else {
            throw new ApiException(ApiErrorCode.NEWS_NULL_DATA);
        }
    }
    public List<NewsResponseDTO.NewsDTO> getPressNews() {
        try {
            return pressNewsWebClient.get()
                .uri(uriBuilder -> URI.create(uriBuilder
                    .queryParam("pageNo", PAGE_NO)
                    .queryParam("numOfRows", NUM_OF_ROWS)
                    .queryParam("type", API_TYPE)
                    .build() + "&serviceKey=" + serviceKey)) // serviceKey를 직접 추가하여 인코딩을 피함
                .retrieve()
                .bodyToMono(NewsResponseDTO.class)
                .block().getBody().getItem();
        }catch(NullPointerException e){
            throw new ApiException(ApiErrorCode.NEWS_NULL_DATA);
        }
    }

}
