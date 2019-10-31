```java
public class CloneUtils{

    @SuppressWarnings("unchecked")
    public static <T> T deepClone(T src) {
        T dest = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            out.close();
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            dest = (T) in.readObject();
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return dest;
    }

}
```

