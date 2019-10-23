1.对传入的List<Map<String,Object>> list 里的某个long类型的字段进行排序

```java
public static void sortNumDesc(List<Map<String, Object>> list, String field){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                if("-".equals(o1.get(field))) return 1;
                else if("-".equals(o2.get(field))) return -1;
                else if((Long.valueOf(String.valueOf(o1.get(field)) )).equals(Long.valueOf(String.valueOf(o2.get(field))))){
                    return 0;
                }
                return (long)o1.get(field) < (long)o2.get(field) ? 1: -1;
            }
        });
    }
    public static void sortNumAsc(List<Map<String, Object>> list, String field){
        Collections.sort(list, (o1, o2) -> {
            if("-".equals(o1.get(field))) return -1;
            else if("-".equals(o2.get(field))) return 1;
            else if((Long.valueOf(String.valueOf(o1.get(field)) )).equals(Long.valueOf(String.valueOf(o2.get(field))))){
                return 0;
            }
            return (long)o1.get(field) < (long)o2.get(field) ? -1: 1;
        });
    }
```

注意：若转型为Long失败会报错。int转型不了为long

2.

```java
/**
     * 该方法必须以String 或 integer 的Object 类， type = 1：升序排序  || -1:降序排序   field : Map<String, Object> 下 key 的某个字段
     * @param list
     * @param field
     */
    public static void sortByObject(List<Map<String, Object>> list, String field, int type){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Object tmpOb1 = o1.get(field);
                Object tmpOb2 = o2.get(field);
                if (tmpOb1 instanceof Integer && (tmpOb2 instanceof Integer)){
                    int tmp1 = (int) tmpOb1;
                    int tmp2 = (int) tmpOb2;
                    if( tmp1 >= tmp2) return type;
                    else return -1 * type;
                }else if(tmpOb1 instanceof String && (tmpOb2 instanceof String)){
                    String tmp1 = (String) tmpOb1;
                    String tmp2 = (String) tmpOb2;
                    return tmp1.compareTo(tmp2) * type;
                }
                return type;
            }
        });

    }
```



3.按拼音排序

```java
/**
     * String 按pinyin排序
     * @param list
     * @param field
     * @param type
     */
    public static void sortByPinYin(List<Map<String, Object>> list, String field, int type){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                try {
                    Object tmpOb1 = o1.get(field);
                    Object tmpOb2 = o2.get(field);
                    if(tmpOb1 == null && tmpOb2 == null) return 0; //防止报Comparison method violates its general contract!错误
                    if(tmpOb1 == null ){
                        return -1 * type;
                    }
                    if(tmpOb2 == null ){
                        return type;
                    }
                    if (tmpOb1 instanceof Integer && (tmpOb2 instanceof Integer)){
                        int tmp1 = (int) tmpOb1;
                        int tmp2 = (int) tmpOb2;
                        if( tmp1 == tmp2 ) return 0;
                        if( tmp1 > tmp2 ) return type;
                        else return -1 * type;
                    }
                    if (tmpOb1 instanceof String && (tmpOb2 instanceof String)) {
                        String tmp1 = ChineseUtil.toPinYin((String) tmpOb1);
                        String tmp2 = ChineseUtil.toPinYin((String) tmpOb2);
                        if(tmp1.equalsIgnoreCase(tmp2)) return 0;
                        return tmp1.compareToIgnoreCase(tmp2) * type;
                    }
                    if(tmpOb1 instanceof List && (tmpOb2 instanceof List)){
//                        String tmp1 = ChineseUtil.toPinYin(())/
                        List tmpList1 = (List)tmpOb1;
                        List tmpList2 = (List)tmpOb2;
                        String tmp1 = String.valueOf(tmpList1.size() == 0 ? "":tmpList1.get(0));
                        String tmp2 = String.valueOf(tmpList2.size() == 0 ? "":tmpList2.get(0));
                        if(tmp1.equalsIgnoreCase(tmp2)) return 0;
                        return ChineseUtil.toPinYin(tmp1).compareToIgnoreCase(ChineseUtil.toPinYin(tmp2)) * type;
                    }
                    return 0;
                }catch (Exception e){
                    e.printStackTrace();
                    return 0;
                }
            }
        });

    }
```

中文转化为拼音的类：

```java
/**
     * 中文变拼音，这里的PinyinHelper在github上找
     *
     * @param chines
     * @return
     */
    public static String toPinYin(String chines) throws PinyinException {
        return PinyinHelper.convertToPinyinString(chines, "", PinyinFormat.WITHOUT_TONE);
    }
```



