package spiderJava.controller;

import com.lkx.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spiderJava.entity.excel.OutOfPovertyRegion;
import spiderJava.entity.excel.ProvinceAndItem;
import spiderJava.entity.excel.RegionOfChina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: ShowPageController
 * @Author: YiHui
 * @Date: 2020-11-27 17:55
 * @Version: ing
 */
@Controller
public class ShowPageController {
    private final String folderPath = "./repository/";
    private final String folderPath2 = "./repository/CityLevel/";


    @PostMapping(value = "/test")
    public  String testImport(@RequestParam(value = "file")  MultipartFile file, Model model) throws Exception{
        List<OutOfPovertyRegion> outOfPovertyRegionList = this.getOutOfPoverty(file);
        model.addAttribute("resList",outOfPovertyRegionList);
        return "test";
    }


    private List<OutOfPovertyRegion> getOutOfPoverty(MultipartFile file) throws Exception{
         /*
          注意读取时文件表头可能因为隐藏的格式问题读取失败,此时可重写
         */
        List<ProvinceAndItem> excelList = ExcelUtil.readXls( file.getBytes(), ProvinceAndItem.class);
        List<RegionOfChina> regionOfChinaList = ExcelUtil.readXls( folderPath2+"中国省市区.xlsx",RegionOfChina.class);
        HashMap<String, String> countyCityMap = new HashMap<>(1024);
        for( RegionOfChina row : regionOfChinaList ){
            countyCityMap.put( row.getCounty(),row.getCity());
        }
        List<OutOfPovertyRegion> resList = new ArrayList<>();
        String pattern = "(\\d{4})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(Objects.requireNonNull(file.getOriginalFilename(),"file没有标识"));
        String year = "null";
//        find()这一步与Set的contains()方法不一样,它同时也是寻找匹配的过程.没有这一步将没有分组.
        if( m.find()) {
            year= m.group();
        }
        for (ProvinceAndItem row : excelList) {
            String[] counties = row.getItem().split("、");
            for (String s : counties) {
                OutOfPovertyRegion res = new OutOfPovertyRegion();
                res.setProvince(row.getProvince());
                res.setCity( countyCityMap.getOrDefault(s,"null"));
                res.setCounty(s);
                res.setOutOfPovertyYear(year);
                resList.add(res);
            }
        }
        ExcelUtil.exportExcel(folderPath2+ year +"res.xlsx",resList, OutOfPovertyRegion.class);
        return resList;
    }

}
