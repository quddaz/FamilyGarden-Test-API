package DataTest.demo.DTO;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;

@Getter
@XmlRootElement(name = "응답")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsResponseDTO {
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
        @XmlElement(name = "총개수")
        private int totalCount;

        @XmlElement(name = "페이지번호")
        private int pageNo;

        @XmlElement(name = "행개수")
        private int numOfRows;

        @XmlElementWrapper(name = "항목들")
        @XmlElement(name = "항목")
        private List<NewsDTO> item;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class NewsDTO {
        @XmlElement(name = "등록일")
        private String regDt;

        @XmlElement(name = "썸네일URL")
        private String thumbUrl;

        @XmlElement(name = "제목")
        private String title;

        @XmlElement(name = "보기URL")
        private String viewUrl;
    }
}
