package DataTest.demo.Service;

import DataTest.demo.DTO.CareEduResponseDTO;

import DataTest.demo.Exception.ApiException;
import DataTest.demo.Exception.Enum.ApiErrorCode;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@Service
public class CareEduService {

    private static final int PAGE_NO = 1;
    private static final int NUM_OF_ROWS = 10;
    private static final String API_TYPE = "xml";

    private final String serviceKey;
    private final WebClient careEduWebClient;

    public CareEduService(
        @Value("${private.key}") String serviceKey,
        @Qualifier("careEduWebClient") WebClient careEduWebClient) {
        this.serviceKey = serviceKey;
        this.careEduWebClient = careEduWebClient;
    }

    /**
     * 아이돌봄교육기관 전체 검색
     * @return 기관정보 리스트
     */
    public List<CareEduResponseDTO.CareEduDTO> getCareEduData() {
        CareEduResponseDTO responseDTO = careEduWebClient.get()
            .uri(uriBuilder -> URI.create(uriBuilder
                .queryParam("pageNo", PAGE_NO)
                .queryParam("numOfRows", NUM_OF_ROWS)
                .queryParam("type", API_TYPE)
                .build() + "&serviceKey=" + serviceKey)) // serviceKey를 직접 추가하여 인코딩을 피함
            .retrieve()
            .bodyToMono(CareEduResponseDTO.class)
            .block();

        if (responseDTO != null && responseDTO.getBody().getItem() != null) {
            return responseDTO.getBody().getItem();
        } else {
            throw new ApiException(ApiErrorCode.CARE_EDU_NULL_DATA);
        }
    }

    /**
     * Xml 형식으로 데이터를 받음
     * 아이돌봄교육기관 조건부 검색
     * @param eduInstNm 기관명 이름으로 검색
     * @return 기관정보 리스트
     */
    public List<CareEduResponseDTO.CareEduDTO> getCareEduData(String eduInstNm) {
        try {
            return careEduWebClient.get()
                .uri(uriBuilder -> URI.create(uriBuilder
                    .queryParam("pageNo", PAGE_NO)
                    .queryParam("numOfRows", NUM_OF_ROWS)
                    .queryParam("type", API_TYPE)
                    .queryParam("eduInstNm", eduInstNm)
                    .build() + "&serviceKey=" + serviceKey)) // serviceKey를 직접 추가하여 인코딩을 피함
                .retrieve()
                .bodyToMono(CareEduResponseDTO.class)
                .block().getBody().getItem();
        }catch (NullPointerException e){
            throw new ApiException(ApiErrorCode.CARE_EDU_NULL_DATA);
        }
    }
}
