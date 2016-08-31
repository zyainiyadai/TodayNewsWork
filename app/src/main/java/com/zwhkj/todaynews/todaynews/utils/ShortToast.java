package com.zwhkj.todaynews.todaynews.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 类描述：公用Toast
 * 时间：2016/2/18 17:34
 * 版本：
 */
public class ShortToast {

    private static Toast toast;
    public static synchronized Toast getToast(Context context,String message){
        if (toast == null) {
            toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM,0,60);
        }else{
            toast.setText(message);
        }

        return toast;
    }
}
