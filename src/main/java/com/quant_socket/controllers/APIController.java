package com.quant_socket.controllers;

import com.quant_socket.models.response.Response;
import com.quant_socket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class APIController {

    @Autowired
    private ProductService productService;

    @PostMapping("/issue/higher")
    public ResponseEntity<Response> getHigher(@RequestParam(required = false) String type) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("상승상위 증권을 불러왔습니다.");
        res.setData(productService.orderHigher(type));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/issue/lower")
    public ResponseEntity<Response> getLower(@RequestParam(required = false) String type) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("하락상위 증권을 불러왔습니다.");
        res.setData(productService.orderLower(type));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/issue/total-price")
    public ResponseEntity<Response> getHavingCount(@RequestParam(required = false) String type) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("시총상위 증권을 불러왔습니다.");
        res.setData(productService.orderHavingCount(type));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/issue/trading-count")
    public ResponseEntity<Response> getTradingCount(@RequestParam(required = false) String type) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("거래상위 증권을 불러왔습니다.");
        res.setData(productService.orderTradingCount(type));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/issue/from-isincode")
    public ResponseEntity<Response> getFromIsinCodes(@RequestParam(required = false) String[] code) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("상품을 조회했습니다.");
        if(code != null) res.setData(productService.fromIsinCodes(List.of(code)));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/chart/minute")
    public ResponseEntity<Response> getChartFromMinute(@RequestParam(required = false) String code) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("분 차트를 조회했습니다.");
        res.setData(productService.minuteChartFromCode(code));
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/chart/day")
    public ResponseEntity<Response> getChartFromDay(@RequestParam(required = false) String code) {
        final Response res = new Response();
        res.setStatusCode(HttpStatus.OK);
        res.setMessage("일 차트를 조회했습니다.");
        res.setData(productService.dayChartFromCode(code));
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
