package spiderJava.entity.excel;

import com.lkx.util.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: RegionOfChina
 * @Author: YiHui
 * @Date: 2020-11-09 10:03
 * @Version: ing
 */
@Getter
@Setter
@ToString
public class RegionOfChina extends CodeOfRegion{
    @Excel(title = "编码")
    private String regionCode;
    @Excel(title = "省")
    private String province;
    @Excel(title = "市")
    private String city;
    @Excel(title = "区")
    private String county;
}
