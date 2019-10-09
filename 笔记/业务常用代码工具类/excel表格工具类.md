将数据转化为excel格式下载：

```java
public static void downloadExcelFile(HttpServletResponse response, String[] titles, String[] attributes,
                                                    String[] types, List<Map<String, Object>> infosList ,String sheetName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 建立新HSSFWorkbook 对象
        HSSFSheet sheet = wb.createSheet();
        // 建立新的sheet对象
        wb.setSheetName( 0, sheetName  );
        HSSFRow row = sheet.createRow( (short)0 );
        // 在sheet里创建一行，参数为行号，第一行
        // 用于设置标题
        // 设置列宽
        for( int i = 0; i < titles.length; i++ ) {
            sheet.setColumnWidth( (short)i, (short)(30 * 256) );
        }
        // 设置标题
        for( int i = 0; i < titles.length; i++ ) {
            HSSFCell cell = row.createCell( (short)i );
            cell.setCellValue( titles[i] );
        }
        // 填充内容
        for( int i = 0; i < infosList.size(); i++ ) {
            HSSFRow contentRow = sheet.createRow( (short)(i + 1) );
            for( int j = 0; j < attributes.length; j++ ) {
                HSSFCell cell = contentRow.createCell( (short)j );
                changeType( cell, String.valueOf( infosList.get( i ).get( attributes[j] ) ), types[j] );
            }
        }

        OutputStream out = response.getOutputStream();

        wb.write( out );

        out.flush();
        out.close();
        wb.close();

    }
```

