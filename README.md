# 가족뜰 공공데이터
## 사용 API
- 여성가족부 정책 뉴스 조회
    - [여성가족부 정책 뉴스 조회 서비스 | 공공데이터포털 (data.go.kr)](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15058733)
- 여성가족부 보도 자료 조회
    - [여성가족부 정책 뉴스 조회 서비스 | 공공데이터포털 (data.go.kr)](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15058733)
- 여성가족부 아이돌봄기관 조회
    - [여성가족부_아이돌봄교육기관 | 공공데이터포털 (data.go.kr)](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15109775)
- 한국 건강가정진흥원 공동육아나눔터 조회
    - [데이터 상세 | 공공데이터포털 (data.go.kr)](https://www.data.go.kr/tcs/dss/selectFileDataDetailView.do?publicDataPk=15055830)
- 기상청 단기예보 조회
    - [기상청_단기예보 ((구)_동네예보) 조회서비스 | 공공데이터포털 (data.go.kr)](https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15084084#tab_layer_detail_function)

## 기본 규격
```json
{
"code": "요청상태코드",
"message": "메시지",
"data": [],
"timestamp": "요청시간"
}
```
```json
{
"code": 200,
"message": "API 요청 성공",
"data": [],
"timestamp": "2024-06-22T08:35:40.983192508"
}
```
## 뉴스 관련 API
### 여성가족부 정책 뉴스 조회
- https://port-0-familygarden-test-api-lxfol2lf38345220.sel5.cloudtype.app/api/policy-news
- 여성가족부의 정책 뉴스 관련 조회입니다.
- 썸네일 Url는 미리보기용으로 제공되는 Url입니다. 
```json
"data" : [
    {
        "등록일": "string (YYYY-MM-DD)",
        "썸네일Url": "string (URL)",
        "제목": "string",
        "보기Url": "string (URL)"
    }
]
```
### 여성가족부 보도 자료 조회
- https://port-0-familygarden-test-api-lxfol2lf38345220.sel5.cloudtype.app/api/press-news
- 여성가족부의 보도 자료 관련 조회입니다.
- 보도 자료란 여성가족부터 언론에 배포한 보도 자료를 말합니다.
```json
"data" : [
    {
        "등록일": "string (YYYY-MM-DD)",
        "제목": "string",
        "보기Url": "string (URL)"
    }
]
```
## 지도 관련 API 
### 여성가족부 아이돌봄기관 조회
- https://port-0-familygarden-test-api-lxfol2lf38345220.sel5.cloudtype.app/api/childcare-centers
- 여성가족부가 제공하는 통합 아이돌봄기관 조회입니다. 검색에는 전체 검색이 가능하고 조건 검색이 가능합니다.
- 조건 검색은 3가지 파라미터로 가능합니다(기관명, 지역명, 시군구명)
- 많은 정보를 제공하므로 그 기관에 대한 다양한 정보를 표시할 수 있습니다. 
```json
"data" : [
    {
        "교육기관명": "경상남도 건강가정지원센터",
        "시": "경남",
        "구": "창원시",
        "도로명주소": "경상남도 창원시 마산회원구 봉암북7길 21 경남테크노파크 정보산업진흥본부 4동 305호",
        "지번주소": "경상남도 창원시 마산회원구 봉암동 541 4동 305호",
        "위도": 35.22469641,
        "경도": 128.598327,
        "홈페이지주소": "https://gsnd.familynet.or.kr/center/",
        "대표전화번호": "0557162363",
        "팩스번호": "05057002112",
        "이메일주소": "gsnd@familynet.or.kr",
        "사업자등록번호": "6098264957",
        "운영상태": "Y",
        "운영시작일자": "20200101",
        "운영종료일자": "20231231",
        "운영시간": "월-일 09:00~18:00",
        "휴무정보": "",
        "인근지하철역명": "",
        "인근버스정류장명": "창원대학교입구",
        "인증일자": "20221215",
        "노출여부": "Y",
        "비고": ""
    }
]
```
### 공동육아나눔터 조회
- https://port-0-familygarden-test-api-lxfol2lf38345220.sel5.cloudtype.app/api/childcare-centers
- 정부에서 실행하는 공동육아나눔터(육아 품앗이) 장소를 조회하는 서비스입니다.
- 시군구, 시도 별로 검색이 필요합니다.
```json
    "data": [
        {
            "공동육아나눔터연락처": "070-7458-2249",
            "시군구": "강남구",
            "시도": "서울",
            "연번": 1,
            "운영기관": "강남구가족센터",
            "주소": "서울특별시 강남구 개포로 617-8"
        }
    ]
```
### 날씨 조회 
- https://port-0-familygarden-test-api-lxfol2lf38345220.sel5.cloudtype.app/api/weather-forecast?base_date=20240622&base_time=0630&nx=55&ny=127
- 날씨 정보를 조회합니다.
```json
    "data": [
        {
            "기준일자": "20240622",
            "기준시간": "0600",
            "카테고리": "PTY",
            "nx": 55,
            "ny": 127,
            "관측값": 0
        }
    ]
```
