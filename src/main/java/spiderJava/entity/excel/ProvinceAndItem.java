package spiderJava.entity.excel;

import com.lkx.util.Excel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author MBin_王艺辉istarwyh
 */
@Getter
@Setter
@ToString
public class ProvinceAndItem {
    @Excel(title = "省份")
    private String province;
    @Excel(title = "名单")
    private String item;
}
