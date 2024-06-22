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
        private String 교육기관명;

        @XmlElement(name = "ctpvNm")
        private String 시;

        @XmlElement(name = "sggNm")
        private String 구;

        @XmlElement(name = "roadNmAddr")
        private String 도로명주소;

        @XmlElement(name = "lotnoAddr")
        private String 지번주소;

        @XmlElement(name = "lat")
        private double 위도;

        @XmlElement(name = "lot")
        private double 경도;

        @XmlElement(name = "hmpgAddr")
        private String 홈페이지주소;

        @XmlElement(name = "rprsTelno")
        private String 대표전화번호;

        @XmlElement(name = "fxno")
        private String 팩스번호;

        @XmlElement(name = "emlAddr")
        private String 이메일주소;

        @XmlElement(name = "brno")
        private String 사업자등록번호;

        @XmlElement(name = "operYn")
        private String 운영상태;

        @XmlElement(name = "operBgngYmd")
        private String 운영시작일자;

        @XmlElement(name = "operEndYmd")
        private String 운영종료일자;

        @XmlElement(name = "operHrCn")
        private String 운영시간;

        @XmlElement(name = "hldyCn")
        private String 휴무정보;

        @XmlElement(name = "nrbSbwNm")
        private String 인근지하철역명;

        @XmlElement(name = "nrbBusStnNm")
        private String 인근버스정류장명;

        @XmlElement(name = "crtrYmd")
        private String 인증일자;

        @XmlElement(name = "expsrYn")
        private String 노출여부;

        @XmlElement(name = "rmrkCn")
        private String 비고;
    }

}