package learn.tomcat9.performance.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TestController {

    @GetMapping("/request")
    public ResponseEntity<Double> request() throws InterruptedException {

        log.info("요청 시작");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread.sleep(3_000L);

        stopWatch.stop();
        double responseSeconds = stopWatch.getTotalTimeSeconds();
        log.info("요청 끝. 응답시간: {}초", responseSeconds);
        return ResponseEntity.ok(responseSeconds);
    }
}
