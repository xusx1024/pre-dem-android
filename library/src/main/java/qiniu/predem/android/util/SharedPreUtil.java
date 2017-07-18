package qiniu.predem.android.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Misty on 17/6/16.
 */

public class SharedPreUtil {
    private static final String TAG = "SharedPreUtil";

    private static final String FILE_NAME = "dem_sdk";

    private static final String LAST_CONFIGURATION_TIME = "last_time";

    private static final String HTTP_MONITOR_ENABLE = "http_monitor_enable";
    private static final String CRASH_REPORT_ENABLE = "crash_report_enable";
    private static final String WEBVIEW_ENABLE = "webview_enable";
    private static final String DEVICE_SYMBOLICATION_ENABLE = "on_device_symbolication_enabled";
    private static final String NETWORK_DIAGNOSIS_ENABLE = "lag_monitor_enable";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.edit();
    }

    /**
     * http 上报开关
     * @param context
     * @param enable
     */
    public static void setHttpMonitorEnable(Context context, boolean enable) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(HTTP_MONITOR_ENABLE, enable);
        editor.apply();
    }

    /**
     * crash 上报开关
     * @param context
     * @param enable
     */
    public static void setCrashReportEable(Context context, boolean enable) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(CRASH_REPORT_ENABLE, enable);
        editor.apply();
    }

    /**
     * webview 上报开关
     * @param context
     * @param enable
     */
    public static void setWebviewEnable(Context context, boolean enable){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(WEBVIEW_ENABLE, enable);
        editor.apply();
    }

    /**
     * 自定义数据上报开关
     * @param context
     * @param enable
     */
    public static void setDeviceSymbolicationEable(Context context, boolean enable) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(DEVICE_SYMBOLICATION_ENABLE, enable);
        editor.apply();
    }

    /**
     * 网络诊断上报开关
     * @param context
     * @param enable
     */
    public static void setNetWorkDiagnosisEable(Context context, boolean enable) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(NETWORK_DIAGNOSIS_ENABLE, enable);
        editor.apply();
    }

    public static void setLastTime(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        long time = System.currentTimeMillis();
        editor.putLong(LAST_CONFIGURATION_TIME, time);
        editor.apply();
    }

    public static boolean getHttpMonitorEnable(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getBoolean(HTTP_MONITOR_ENABLE, false);
    }

    public static boolean getCrashReportEnable(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getBoolean(CRASH_REPORT_ENABLE, false);
    }

    public static boolean getWebviewEnable(Context context){
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getBoolean(WEBVIEW_ENABLE, false);
    }

    public static boolean getNetWorkDiagnosisEnable(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getBoolean(NETWORK_DIAGNOSIS_ENABLE, false);
    }

    public static boolean getDeviceSymbolicationEable(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getBoolean(DEVICE_SYMBOLICATION_ENABLE, false);
    }

    public static long getConfigurationLastTime(Context context) {
        SharedPreferences sh = getSharedPreferences(context);
        return sh.getLong(LAST_CONFIGURATION_TIME, -1);
    }
}
