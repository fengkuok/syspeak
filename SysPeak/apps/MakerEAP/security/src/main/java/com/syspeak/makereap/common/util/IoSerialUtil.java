package com.syspeak.makereap.common.util;


import java.io.*;

/**
 * 序列化和反序列化
 */
public class IoSerialUtil {

    /**
     * 对象序列化
     *
     * @param serializedObject
     * @return
     */
    public static byte[] serialize(Serializable serializedObject) {
        byte[] results = null;

        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(serializedObject);
            results = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
            closeStream(baos);
        }

        return results;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Serializable deserialize(byte[] bytes) {
        Serializable serializedObject = null;

        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            serializedObject = (Serializable) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(ois);
            closeStream(bais);
        }

        return serializedObject;
    }

    /**
     * 关闭流
     *
     * @param os
     */
    private static void closeStream(Closeable os) {
        try {
            if (os != null) os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
