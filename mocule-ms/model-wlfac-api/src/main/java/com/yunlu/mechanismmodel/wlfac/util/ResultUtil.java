package com.yunlu.mechanismmodel.wlfac.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozhiqiang 2019/9/19
 **/
public class ResultUtil {

    public final static int OK = 200;
    public final static int ERROR = 999;

    private final static Map<Integer, String> MESSAGES = new HashMap<>();

    static {
        MESSAGES.put(OK, "successful");
        MESSAGES.put(ERROR, "failed");
    }

    public static ApiResult getOKResult(Object data) {
        return new ApiResult<>(OK, "", data);
    }

    public static ApiResult getErrorResult() {
        return new ApiResult(ERROR, getMessage(ERROR));
    }

    public static ApiResult getErrorResult(String message) {
        return new ApiResult(ERROR, message);
    }

    public static String getMessage(int code) {
        String msg = MESSAGES.get(code);
        return msg == null ? "" : msg;
    }
}
