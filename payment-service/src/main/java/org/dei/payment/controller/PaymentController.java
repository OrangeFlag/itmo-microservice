package org.dei.payment.controller;

import org.dei.payment.api.PaymentAPI;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
interface PaymentController extends PaymentAPI {
}
