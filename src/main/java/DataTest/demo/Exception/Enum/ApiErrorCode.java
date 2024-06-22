package DataTest.demo.Exception.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ApiErrorCode implements ErrorCode{
    CARE_EDU_DATA_FETCH_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"아이돌봄기관 조회 중 오류 발생"),
    CARE_EDU_NULL_DATA(HttpStatus.NOT_FOUND, "아이돌봄기관 데이터가 없습니다."),
    JSON_PARSING_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "JSON 파싱 중 오류가 발생했습니다."),
    CHILDCARE_CENTER_DATA_FETCH_FAILED(HttpStatus.INTERNAL_SERVER_ERROR,"공동육아나눔터 API 조회 중 오류 발생"),
    NEWS_NULL_DATA(HttpStatus.NOT_FOUND, "뉴스 데이터가 없습니다."),
    WEATHER_NULL_DATA(HttpStatus.NOT_FOUND, "일기예보 데이터가 없습니다.");
    private HttpStatus httpStatus;
    private String message;
}