package DataTest.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class ChildcareCenterResponseDTO {

    @JsonProperty("data")
    private List<ChildcareCenterDTO> data;

    @Getter
    public static class ChildcareCenterDTO {

        @JsonProperty("공동육아나눔터연락처")
        private String contactNumber;

        @JsonProperty("시군구")
        private String district;

        @JsonProperty("시도")
        private String city;

        @JsonProperty("연번")
        private int serialNumber;

        @JsonProperty("운영기관")
        private String operatingAgency;

        @JsonProperty("주소")
        private String address;
    }
}
