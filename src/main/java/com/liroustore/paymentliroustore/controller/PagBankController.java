package com.liroustore.paymentliroustore.controller;

//import com.liroustore.paymentliroustore.models.PaymentTransaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagbank")
@Log4j2
public class PagBankController {

//    @PostMapping("/notify")
//    public ResponseEntity<?> onStatusChange(@RequestBody PaymentTransaction paymentTransaction) {
//        return ResponseEntity.ok("notificando!");
//    }

    @GetMapping
    public ResponseEntity<String> testar(){
        log.info("Servidor iniciado");
        return ResponseEntity.ok("Vê lá se deu certo");
    }
}
