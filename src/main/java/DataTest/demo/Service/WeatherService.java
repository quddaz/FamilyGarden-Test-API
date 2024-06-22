package DataTest.demo.Service;

import DataTest.demo.DTO.WeatherForecastResponseDTO;
import DataTest.demo.Exception.ApiException;
import DataTest.demo.Exception.Enum.ApiErrorCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Service
@Slf4j
public class WeatherService {
    private static final int PAGE_NO = 1;
    private static final int NUM_OF_ROWS = 100;
    private static final String API_TYPE = "XML";
    private final String serviceKey;
    private final WebClient weatherForecastWebClient;

    public WeatherService(
        @Value("${private.key}") String serviceKey,
        @Qualifier("weatherForecastWebClient") WebClient weatherForecastWebClient
    ){
        this.serviceKey=serviceKey;
        this.weatherForecastWebClient=weatherForecastWebClient;
    }

    public List<WeatherForecastResponseDTO.Item> getWeatherForecastData(String base_date, String base_time, String nx, String ny) {
        try {
            return weatherForecastWebClient.get()
                .uri(uriBuilder -> URI.create(uriBuilder
                    .queryParam("pageNo", PAGE_NO)
                    .queryParam("numOfRows", NUM_OF_ROWS)
                    .queryParam("dataType", API_TYPE)
                    .queryParam("base_date", base_date)
                    .queryParam("base_time", base_time)
                    .queryParam("nx", nx)
                    .queryParam("ny", ny)
                    .build() + "&serviceKey=" + serviceKey))
                .retrieve()
                .bodyToMono(WeatherForecastResponseDTO.class)
                .block().getBody().getItems();
        }catch (NullPointerException e){
            throw new ApiException(ApiErrorCode.WEATHER_NULL_DATA);
        }
    }

}
