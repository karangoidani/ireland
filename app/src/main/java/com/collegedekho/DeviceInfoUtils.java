

package com.collegedekho;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * class for device info specific methods
 *
 */
public class DeviceInfoUtils {

    /**
     * @param pContext
     * @return
     */
    @SuppressLint("MissingPermission")
    public static String getUniqueId(Context pContext) {
        String deviceImei = null;
        if (pContext.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_TELEPHONY)) {
            TelephonyManager telephonyManager = (TelephonyManager) pContext
                    .getSystemService(Context.TELEPHONY_SERVICE);
            deviceImei = telephonyManager.getDeviceId();
        }
            return deviceImei;
       // }
    }

    /**
     * @return
     */
    public static String getModelDesc() {
        String modelDesc = Build.MANUFACTURER;
        modelDesc += " " + Build.MODEL;
        return modelDesc;
    }
}
