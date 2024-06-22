package DataTest.demo.DTO;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherForecastResponseDTO {

    private Header header;
    private Body body;

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Header {
        @XmlElement(name = "resultCode")
        private String resultCode;

        @XmlElement(name = "resultMsg")
        private String resultMsg;
    }

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "dataType")
        private String dataType;

        @XmlElementWrapper(name = "items")
        @XmlElement(name = "item")
        private List<Item> items;

        @XmlElement(name = "numOfRows")
        private int numOfRows;

        @XmlElement(name = "pageNo")
        private int pageNo;

        @XmlElement(name = "totalCount")
        private int totalCount;
    }

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Item {
        @XmlElement(name = "baseDate")
        private String 기준일자;

        @XmlElement(name = "baseTime")
        private String 기준시간;

        @XmlElement(name = "category")
        private String 카테고리;

        @XmlElement(name = "nx")
        private int nx;

        @XmlElement(name = "ny")
        private int ny;

        @XmlElement(name = "obsrValue")
        private int 관측값;
    }
}
