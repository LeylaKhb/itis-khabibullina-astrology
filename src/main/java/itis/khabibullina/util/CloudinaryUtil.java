package itis.khabibullina.util;


import com.cloudinary.Cloudinary;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryUtil {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null) {
            Map<String, String> configMap = new HashMap<>();
            configMap.put("cloud_name", "dphkmjgiy");
            configMap.put("api_key", "437352785774432");
            configMap.put("api_secret", "6rhJZtcDoaoopGNV8K46yv2WmKc");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}
