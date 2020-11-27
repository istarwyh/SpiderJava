package spiderJava.entity.excel;

import com.lkx.util.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: KFCStionNUm
 * @Author: YiHui
 * @Date: 2020-11-25 16:29
 * @Version: ing
 */
@Getter
@Setter
@ToString
public class KFCStationNum {
    @Excel( title = "省")
    private String province;
    @Excel( title = "市或区")
    private String county;
    @Excel( title = "KFC地址")
    private String station;
    @Excel( title = "网点数目")
    private Integer staionNum;
}
