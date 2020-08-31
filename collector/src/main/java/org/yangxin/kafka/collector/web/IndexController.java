package org.yangxin.kafka.collector.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangxin
 * 2020/08/31 17:18
 */
@Slf4j
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        log.info("我是一条info日志");
        log.warn("我是一条warn日志");
        log.error("我是一条error日志");

        return "index";
    }
}
