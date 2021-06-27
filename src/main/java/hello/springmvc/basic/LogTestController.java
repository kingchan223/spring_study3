package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@controller는 문자열을 반환하면 뷰 리졸빙한 결과가 반환되지만 @RestController는 진짜 그냥 문자열이 반환된다.
//즉 httpResponse의 body에 반환 문자열을 담아 보낸다.
@Slf4j// == private final Logger log = LoggerFactory.getLogger(getClass());//getClass()는 현재 클래스
public class LogTestController {

    @RequestMapping(value="/log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("info log={}", name);
        log.debug("info log={}", name);
        log.info("info log={}", name);
        log.warn("info log={}", name);
        log.error("info log={}", name);

        return "ok";
    }
}
