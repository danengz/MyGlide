package com.yu.myglide.bean;

import android.graphics.Bitmap;
import android.util.Log;

public class Value {

    private static final String TAG = Value.class.getSimpleName();

    public interface ValueCallback {

        /**
         * 监听的方法（Value不再使用了）
         * @param key
         * @param value
         */
        public void valueNonUseListener(String key, Value value);

    }

    private static Value value;

    private Value() {}

    public static Value getInstance() {
        if (value == null) {
            synchronized (Value.class){
                if (value == null) {
                    value = new Value();
                }
            }
        }
        return value;
    }

    //对应的key
    private String key;

    //计数器
    private int count;

    //图片
    private Bitmap bitmap;

    //不再被使用反馈
    private ValueCallback valueCallback;


    /**
     * 使用一次计数器+1
     */
    public void useAction() {
        if (bitmap.isRecycled()) { // 已经被回收了
            Log.d(TAG, "useAction: 已经被回收了");
            return;
        }
        Log.d(TAG, "useAction: 加一 count:" + count);
        count ++;
    }

    /**
     * 使用完成（不使用）计数器-1
     * count<=0，通知外界
     */
    public void nonUseAction() {
        count--;
        if (count <= 0 && valueCallback != null) {
            valueCallback.valueNonUseListener(key, this);
        }
        Log.d(TAG, "useAction: 减一 count:" + count);
    }

    /**
     * TODO 释放
     */
    public void recycleBitmap() {
        if (count > 0) {
            Log.d(TAG, "recycleBitmap: 引用计数大于0，证明还在使用中，不能去释放...");
            return;
        }

        if (bitmap.isRecycled()) { // 被回收了
            Log.d(TAG, "recycleBitmap: mBitmap.isRecycled() 已经被释放了...");
            return;
        }

        bitmap.recycle();

        value = null;

        System.gc();
    }


    // ----setter & getter------------------

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public ValueCallback getValueCallback() {
        return valueCallback;
    }

    public void setValueCallback(ValueCallback valueCallback) {
        this.valueCallback = valueCallback;
    }
}
