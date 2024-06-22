package DataTest.demo.DTO;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;

import java.util.List;

@Getter
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsResponseDTO {
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
        @XmlElement(name = "totalCount")
        private int totalCount;

        @XmlElement(name = "pageNo")
        private int pageNo;

        @XmlElement(name = "numOfRows")
        private int numOfRows;

        @XmlElementWrapper(name = "items")
        @XmlElement(name = "item")
        private List<NewsDTO> item;
    }

    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class NewsDTO {
        @XmlElement(name = "regDt")
        private String 등록일;

        @XmlElement(name = "thumbUrl")
        private String 썸네일Url;

        @XmlElement(name = "title")
        private String 제목;

        @XmlElement(name = "viewUrl")
        private String 보기Url;
    }
}