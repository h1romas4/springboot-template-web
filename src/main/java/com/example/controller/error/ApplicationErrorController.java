package com.example.controller.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ApplicationErrorController implements ErrorController {
    /**
     * for html
     */
    @RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView html(HttpServletRequest request) {
        String template = "error";
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (statusCode != null && statusCode.toString().equals("404")) {
            status = HttpStatus.NOT_FOUND;
            template = "404";
        }

        ModelAndView mav = new ModelAndView();
        mav.setStatus(status);
        mav.setViewName(template);
        mav.addObject("timestamp", new Date());
        mav.addObject("status", status.value());
        mav.addObject("path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));

        return mav;
    }

    /**
     * for json
     */
    @RequestMapping
    public ResponseEntity<Map<String, Object>> json(HttpServletRequest request) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (statusCode != null && statusCode.toString().equals("404")) {
            status = HttpStatus.NOT_FOUND;
        }

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("path", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));

        return new ResponseEntity<>(body, status);
    }
}
