package DataTest.demo.DTO;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;
@Getter
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CareEduResponseDTO {
    @XmlElement(name = "header")
    private Header header;
    @XmlElement(name = "body")
    private Body body;

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Header {
        @XmlElement(name = "resultCode")
        private String resultCode;
        @XmlElement(name = "resultMsg")
        private String resultMsg;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "resultType")
        private String resultType;
        @XmlElement(name = "numOfRows")
        private int numOfRows;
        @XmlElement(name = "totalCount")
        private int totalCount;
        @XmlElement(name = "pageNo")
        private int pageNo;
        @XmlElementWrapper(name = "items")
        @XmlElement(name = "item")
        private List<CareEduDTO> item;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CareEduDTO {
        @XmlElement(name = "eduInstNm")
        private String educationalInstitutionName;
        @XmlElement(name = "ctpvNm")
        private String city;
        @XmlElement(name = "sggNm")
        private String district;
        @XmlElement(name = "roadNmAddr")
        private String roadAddress;
        @XmlElement(name = "lotnoAddr")
        private String lotAddress;
        @XmlElement(name = "lat")
        private double latitude;
        @XmlElement(name = "lot")
        private double longitude;
        @XmlElement(name = "hmpgAddr")
        private String homepageAddress;
        @XmlElement(name = "rprsTelno")
        private String representativePhoneNumber;
        @XmlElement(name = "fxno")
        private String faxNumber;
        @XmlElement(name = "emlAddr")
        private String emailAddress;
        @XmlElement(name = "brno")
        private String businessNumber;
        @XmlElement(name = "operYn")
        private String operationStatus;
        @XmlElement(name = "operBgngYmd")
        private String operationStartDate;
        @XmlElement(name = "operEndYmd")
        private String operationEndDate;
        @XmlElement(name = "operHrCn")
        private String operationHours;
        @XmlElement(name = "hldyCn")
        private String holidayInformation;
        @XmlElement(name = "nrbSbwNm")
        private String neighborhoodSubwayName;
        @XmlElement(name = "nrbBusStnNm")
        private String nearbyBusStationName;
        @XmlElement(name = "crtrYmd")
        private String certificationDate;
        @XmlElement(name = "expsrYn")
        private String exposureStatus;
        @XmlElement(name = "rmrkCn")
        private String remarks;
    }
}
