package xyz.zzyandzzy.utility.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by zzyandzzy on 2017/10/13.
 */

public class SuperToastUtils {
    @ColorInt
    public static int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
    @ColorInt
    public static int ERROR_COLOR = Color.parseColor("#D50000");
    @ColorInt
    public static int INFO_COLOR = Color.parseColor("#3F51B5");
    @ColorInt
    public static int SUCCESS_COLOR = Color.parseColor("#388E3C");
    @ColorInt
    public static int WARNING_COLOR = Color.parseColor("#FFA900");
    @ColorInt
    public static int NORMAL_COLOR = Color.parseColor("#353A3E");

    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
}
