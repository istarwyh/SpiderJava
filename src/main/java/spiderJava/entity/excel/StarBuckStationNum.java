package spiderJava.entity.excel;

import com.lkx.util.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: StatBuckStationNum
 * @Author: YiHui
 * @Date: 2020-11-26 15:17
 * @Version: ing
 */
@Getter
@Setter
@ToString
public class StarBuckStationNum {
    @Excel( title = "市")
    private String city;
    @Excel( title = "streetAddressLine1")
    private String streetAddressLine1;
    @Excel( title = "streetAddressLine2")
    private String streetAddressLine2;
    @Excel( title = "streetAddressLine3")
    private String streetAddressLine3;
    @Excel( title = "网点数目")
    private Integer staionNum;
}
