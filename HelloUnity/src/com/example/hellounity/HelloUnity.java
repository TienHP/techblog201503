package com.example.hellounity;

import android.os.Build;

import com.unity3d.player.UnityPlayerActivity;

public class HelloUnity extends UnityPlayerActivity {
	
	public static String getInforString(String name){
		return "Hello "+name+"\nSystem Info:"+getDeviceInforString();
	}
	
	public static String getDeviceInforString() {
		StringBuilder infor = new StringBuilder();
	    String manufacturer = Build.MANUFACTURER;
	    String model = Build.MODEL;
	    if (model.startsWith(manufacturer)) {
	        infor.append("MODEL: " + capitalize(model));
	    } else {
	        infor.append("MODEL: " + capitalize(manufacturer) + " " + model);
	    }
	    infor.append('\n');
	    infor.append("CPU ID: "+Build.CPU_ABI);
	    infor.append('\n');
	    infor.append("DISPLAY TYPE: "+Build.DISPLAY);
	    infor.append('\n');
	    infor.append("VERSION OS:"+Build.VERSION.RELEASE);
	    infor.append('\n');
	    infor.append("BOOTLOADER: "+ Build.BOOTLOADER);
	    return infor.toString();
	}

	private static String capitalize(String s) {
	    if (s == null || s.length() == 0) {
	        return "";
	    }
	    char first = s.charAt(0);
	    if (Character.isUpperCase(first)) {
	        return s;
	    } else {
	        return Character.toUpperCase(first) + s.substring(1);
	    }
	} 
}
