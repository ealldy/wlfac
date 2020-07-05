package com.yunlu.mechanismmodel.wlfac.util;

/**
 * @author haozhiqiang 2019/9/18
 **/
public class TypeChecked {

    public static boolean doubelChecked(Object o) {
        if(o instanceof Double) {
            return true;
        }else {
            try{
                Double.parseDouble(String.valueOf(o));
            }catch (NumberFormatException e){
                return false;
            }
            return true;
        }
    }
}
