package DataTest.demo.Service;

import DataTest.demo.DTO.ChildcareCenterResponseDTO;
import DataTest.demo.Exception.ApiException;
import DataTest.demo.Exception.Enum.ApiErrorCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class ChildCenterService {

    private static final int PAGE_NO = 1;
    private static final int NUM_OF_ROWS = 400;
    private static final String API_TYPE = "JSON";

    private final String serviceKey;
    private final WebClient childCenterWebClient;

    public ChildCenterService(
        @Value("${private.key}") String serviceKey,
        @Qualifier("childCenterWebClient") WebClient childCenterWebClient) {
        this.serviceKey = serviceKey;
        this.childCenterWebClient = childCenterWebClient;
    }

    /**
     * 공동육아나눔터 전체 검색
     * @return
     */
    public ChildcareCenterResponseDTO getChildcareCenterData() {
        return childCenterWebClient.get()
            .uri(uriBuilder -> URI.create(uriBuilder
                .queryParam("page", PAGE_NO)
                .queryParam("perPage", NUM_OF_ROWS)
                .queryParam("returnType", API_TYPE)
                .build()+ "&serviceKey="+serviceKey))
            .retrieve()
            .bodyToMono(ChildcareCenterResponseDTO.class)
            .block();
    }

}
