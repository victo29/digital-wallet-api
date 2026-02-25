package com.victortavares.infrastructure.controller;

import com.victortavares.core.domain.Transaction;
import com.victortavares.infrastructure.dto.request.TransferRequest;
import com.victortavares.infrastructure.dto.response.BaseResponse;
import com.victortavares.infrastructure.dto.response.ConsultBalanceResponse;
import com.victortavares.usecase.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    private final ConsultBalanceUseCase consultBalanceUseCase;
    private final  TransferUseCase transferUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final TransactionPinValidateUseCase transactionPinValidateUseCase;
    private final UserNotificationUseCase userNotificationUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase, CreateTransactionUseCase createTransactionUseCase, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase, UserNotificationUseCase userNotificationUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {
        var balance =  consultBalanceUseCase.consult(taxNumber);

        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer( @RequestBody TransferRequest transferRequest) throws Exception {
        var from =  findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.fromTaxNumber());
        transactionPinValidateUseCase.validate(from.getTransactionPin(), transferRequest.pin());
        var to =  findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.toTaxNumber());
        var transaction = createTransactionUseCase.create(from, to, transferRequest.value());
        transactionValidateUseCase.validate(transaction);
        transferUseCase.transfer(transaction);
        userNotificationUseCase.notificate(transaction, from.getUser().getEmail());
        return BaseResponse.<String>builder().success(true).message("Transfer completed successfully").build();
    }
}
