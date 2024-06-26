package DataTest.demo.Controller;

import DataTest.demo.Base.ResponseDto;
import DataTest.demo.Service.CareEduService;
import DataTest.demo.Service.ChildCenterService;
import DataTest.demo.Service.NewsService;
import DataTest.demo.Service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ApiController {
    private final ChildCenterService childCenterService;
    private final CareEduService careEduService;
    private final NewsService policyNewsService;
    private final WeatherService weatherSerivce;
    @GetMapping("/childcare-centers")
    public ResponseEntity<ResponseDto<?>> getChApi(){
        return ResponseEntity.ok().body(ResponseDto.of("공동육아나눔터 조회 성공", childCenterService.getChildcareCenterData()));
    }
    @GetMapping("/care-edu")
    public ResponseEntity<ResponseDto<?>> getEduApi(
        @RequestParam(value = "eduInstNm") String eduInstNm) {
        return ResponseEntity.ok().body(ResponseDto.of("아이돌봄교육기관 조회 성공", careEduService.getCareEduData(eduInstNm)));
    }
    @GetMapping("/policy-news")
    public ResponseEntity<ResponseDto<?>> getPoNewApi(){
        return ResponseEntity.ok().body(ResponseDto.of("정책뉴스 조회 성공",policyNewsService.getPolicyNews()));
    }
    @GetMapping("/press-news")
    public ResponseEntity<ResponseDto<?>> getPrNewApi(){
        return ResponseEntity.ok().body(ResponseDto.of("보도뉴스 조회 성공",policyNewsService.getPressNews()));
    }
    @GetMapping("/weather-forecast")
    public ResponseEntity<ResponseDto<?>> getWeFoApi(
        @RequestParam(value = "base_date") String base_date,
        @RequestParam(value = "base_time") String base_time,
        @RequestParam(value = "nx") String nx,
        @RequestParam(value = "ny") String ny
    ){
        return ResponseEntity.ok().body(ResponseDto.of("단기 예보 조회 성공",weatherSerivce.getWeatherForecastData(base_date,base_time,nx,ny)));
    }
}
