

DownloadFileUtil下载工具类（生成excel表格并进行下载）

```java
package com.cn21.ux.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class DownloadFileUtil {

    public static void downloadForChannelAndVersion(HttpServletResponse response, String[] titles, String[] attributes,
                                                    String[] types, List<Map<String, Object>> infosList) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("第一页");// 建立新的sheet对象
        XSSFRow row = sheet.createRow((short) 0);// 在sheet里创建一行，参数为行号，第一行
        // 用于设置标题
        // 设置列宽
        for (int i = 0; i < titles.length; i++) {
            sheet.setColumnWidth((short) i, (short) (30 * 256));
        }
        // 设置标题
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = row.createCell((short) i);
            cell.setCellValue(titles[i]);
        }
        // 填充内容
        for (int i = 0; i < infosList.size(); i++) {
            XSSFRow contentrow = sheet.createRow((i + 1));
            for (int j = 0; j < attributes.length; j++) {
                XSSFCell cell = contentrow.createCell(j);
                changeType(cell, String.valueOf(infosList.get(i).get(attributes[j])), types[j]);
            }
        }

        OutputStream out = response.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wb.write(byteArrayOutputStream);

        response.setHeader("Content-Length", "" + byteArrayOutputStream.size());

        wb.write(out);
        out.flush();
        out.close();
    }

    public static void changeType(XSSFCell cell, Object param, String type) {
        if (type.equals("String")) {
            cell.setCellValue(String.valueOf(param));
            return;
        }
        if (type.equals("Integer")) {
            try {
                int i = Integer.valueOf(String.valueOf(param));
                cell.setCellValue(i);
                return;
            } catch (Exception e) {
                cell.setCellValue(String.valueOf(param));
            }

        }
        if (type.equals("Double")) {
            try {
                double i = Double.valueOf(String.valueOf(param));
                cell.setCellValue(i);
                return;
            } catch (Exception e) {
                cell.setCellValue(String.valueOf(param));
            }
        }
        if (type.equals("Long")) {
            try {
                long i = Long.valueOf(String.valueOf(param));
                cell.setCellValue(i);
                return;
            } catch (Exception e) {
                cell.setCellValue(String.valueOf(param));
            }
        }
    }

}
```

使用实例：使用controller，在里面加入如下代码

```java
@RequestMapping(value = "/downloadDetailedInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
public Object downloadSDKDetailedInfo(){

//生成下载文件的名字
        String downFileName = StringUtil.genDownloadFileName(NAME_crash, userid, DateUtils.wrapTimeByFormat(DATATIME_FORMAT_1, DATATIME_FORMAT_2, dateaxis));

        try {
            downFileName = new String(downFileName.getBytes("GB2312"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

Map<String, Object> result = new HashMap<>();

        //无数据
        if (tmpList == null || tmpList.size() < 1) {

            return CommonResultUtil.getNoResultResult();
        }

        //总条数
        int totalNum = Integer.valueOf(String.valueOf(tmpList.get(tmpList.size() - 1).get(TOTALCOUNT)));
        tmpList.remove(tmpList.size() - 1);

        List<Object> res = new ArrayList<>();
        res.addAll(tmpList);

        //如果超过最大显示条数，则用界限值
        totalNum = totalNum > QUALITY_MAX_SHOW ? QUALITY_MAX_SHOW : totalNum;

        List<Map<String, Object>> resList = tmpList.subList(0, totalNum - 1);

        //下载文件
        return downloadFileMethod(response, fieldList, downFileName, resList, getSelectFieldName(topic), getSelectFieldList(topic));

}
```

