package com.yunlu.mechanismmodel.wlfac.controller;


import com.alibaba.fastjson.JSONObject;
import com.yunlu.mechanismmodel.wlfac.util.ApiResult;
import com.yunlu.mechanismmodel.wlfac.util.TypeChecked;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


import static java.lang.Math.sin;
import static java.lang.Math.atan;

@RestController
@RequestMapping("/model/1/wlfac")
@Api("/model/1/wlfac")
public class ApiController {
    @ResponseBody
    @RequestMapping(value="/calculate", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
    public ApiResult wlfacCalculate(@RequestParam(value = "f")  Object f,
                                       @RequestParam(value = "D")  Object D,
                                       @RequestParam(value = "B")  Object B,
                                       @RequestParam(value = "C")  Object C,
                                       @RequestParam(value = "E")  Object E,
                                       @RequestParam(value = "v")  Object velocity,
                                       @RequestParam(value = "vr")  Object tangential_velocity,
                                       @RequestParam(value = "ω")  Object omega,
                                       @RequestParam(value = "R")  Object wheel_radius)
    {

        if(!TypeChecked.doubelChecked(f)){
            return new ApiResult<>(0, "failed", "参数f数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(D)){
            return new ApiResult<>(0, "failed", "参数D数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(B)){
            return new ApiResult<>(0, "failed", "参数B数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(C)){
            return new ApiResult<>(0, "failed", "参数C数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(E)){
            return new ApiResult<>(0, "failed", "参数E数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(velocity)){
            return new ApiResult<>(0, "failed", "参数v数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(tangential_velocity)){
            return new ApiResult<>(0, "failed", "参数vr数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(omega)){
            return new ApiResult<>(0, "failed", "参数ω数据类型应该为Double");
        }
        if(!TypeChecked.doubelChecked(wheel_radius)){
            return new ApiResult<>(0, "failed", "参数R数据类型应该为Double");
        }

        double Static_friction = Double.valueOf(String.valueOf(f));                  //f轮胎的静摩擦系数
        double CrestD= Double.valueOf(String.valueOf(D));                            //D峰值因子
        double RigidityB = Double.valueOf(String.valueOf(B));                        //B刚度因子
        double Curve_shape=Double.valueOf(String.valueOf(C));                        //C曲线形状因子
        double Curve_curvature=Double.valueOf(String.valueOf(E));                    //E曲线曲率因子
        double Vehicle_speed=Double.valueOf(String.valueOf(velocity));               //v汽车行驶速度
        double wheel_tangentialV=Double.valueOf(String.valueOf(tangential_velocity));//vr车轮的切向速度
        double wheel_angularV=Double.valueOf(String.valueOf(omega));                 //ω车轮角速度
        double wheel_R=Double.valueOf(String.valueOf(wheel_radius));                 //R车轮半径

        double S=(Vehicle_speed-wheel_tangentialV)/Vehicle_speed;                    //S滑移率

        JSONObject data = new JSONObject();
        data.put("S",S);
        data.put("μ(S)",Static_friction+CrestD*sin(Curve_shape*atan(RigidityB*S-Curve_curvature*(RigidityB*S-atan(RigidityB*S)))));
        data.put("note", "关于车轮滑移率S的纵向附着系数");
        return new ApiResult<>(0, "successful", data);
    }


    @ResponseBody
    @RequestMapping(value="/show", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
    public ApiResult wlfacShow(@RequestParam("model") String model){

        JSONObject data = new JSONObject();
        try {
            if("1".equals(model)) {
                String introduction = "\t本微服务主要为汽车轮胎设计人员提供车轮纵向附着系数和车轮滑移率之间的关系。\n" +
                        "\t主要使用一套形式相同的公式来完整地表达纵向力、横向力、回证力矩以及纵向力、横向力等联合作用工况。";
                data.put("introduction", introduction);
                return new ApiResult<>(0, "successful", data);
            }else{
                data.put("lightIntensity", null);
                return new ApiResult<>(1, "没有该编号对应的模型！", data);
            }
        }catch(Exception e){
            data.put("lightIntensity", null);
            return new ApiResult<>(1, "发生未知异常！", data);
        }
    }
}
