package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }


    @ResponseBody // "ok"를 응답 메세지 바디에 담아서 응답한다.(RestController와 같은 효과)
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){ /* ("username") ("age")를 생략하는 대신 요청 파라미터 변수명과 같아야한다.*/

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    /* @RequestParam을 생략하는 대신 요청 파라미터 변수명과 같아야한다.*/
    public String requestParamV4(String username, int age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false)  Integer age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    /* @RequestParam을 생략하는 대신 요청 파라미터 변수명과 같아야한다.*/
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,//defaultValue는 빈문자열도 처리
            @RequestParam(required = false, defaultValue = "-1")  Integer age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    /* @RequestParam을 생략하는 대신 요청 파라미터 변수명과 같아야한다.*/
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam Integer age){
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
        log.info("username = {}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); //toString자동으로 만들어준다.

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1-1")
    public String modelAttributeV1_1(@ModelAttribute HelloData helloData){
        log.info("username = {}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); //toString자동으로 만들어준다.

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username = {}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); //toString자동으로 만들어준다.

        return "ok";
    }
}
