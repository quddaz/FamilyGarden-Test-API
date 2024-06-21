package DataTest.demo.DTO;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;
@Getter
@XmlRootElement(name = "응답")
@XmlAccessorType(XmlAccessType.FIELD)
public class CareEduResponseDTO {
    @XmlElement(name = "헤더")
    private Header header;
    @XmlElement(name = "본문")
    private Body body;

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Header {
        @XmlElement(name = "결과코드")
        private String resultCode;
        @XmlElement(name = "결과메시지")
        private String resultMsg;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "결과유형")
        private String resultType;
        @XmlElement(name = "행개수")
        private int numOfRows;
        @XmlElement(name = "총개수")
        private int totalCount;
        @XmlElement(name = "페이지번호")
        private int pageNo;
        @XmlElementWrapper(name = "항목들")
        @XmlElement(name = "항목")
        private List<CareEduDTO> item;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CareEduDTO {
        @XmlElement(name = "교육기관명")
        private String educationalInstitutionName;
        @XmlElement(name = "시도명")
        private String city;
        @XmlElement(name = "구군명")
        private String district;
        @XmlElement(name = "도로명주소")
        private String roadAddress;
        @XmlElement(name = "지번주소")
        private String lotAddress;
        @XmlElement(name = "위도")
        private double latitude;
        @XmlElement(name = "경도")
        private double longitude;
        @XmlElement(name = "홈페이지주소")
        private String homepageAddress;
        @XmlElement(name = "대표전화번호")
        private String representativePhoneNumber;
        @XmlElement(name = "팩스번호")
        private String faxNumber;
        @XmlElement(name = "이메일주소")
        private String emailAddress;
        @XmlElement(name = "사업자번호")
        private String businessNumber;
        @XmlElement(name = "운영여부")
        private String operationStatus;
        @XmlElement(name = "운영시작일")
        private String operationStartDate;
        @XmlElement(name = "운영종료일")
        private String operationEndDate;
        @XmlElement(name = "운영시간")
        private String operationHours;
        @XmlElement(name = "휴일정보")
        private String holidayInformation;
        @XmlElement(name = "인근지하철명")
        private String neighborhoodSubwayName;
        @XmlElement(name = "인근버스정류장명")
        private String nearbyBusStationName;
        @XmlElement(name = "인증일자")
        private String certificationDate;
        @XmlElement(name = "노출여부")
        private String exposureStatus;
        @XmlElement(name = "비고")
        private String remarks;
    }
}
