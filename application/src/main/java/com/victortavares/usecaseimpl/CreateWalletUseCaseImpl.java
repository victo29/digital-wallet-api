package com.victortavares.usecaseimpl;

import com.victortavares.core.domain.Wallet;
import com.victortavares.geteway.CreateWalletGetway;
import com.victortavares.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private CreateWalletGetway createWalletGetway;

    public CreateWalletUseCaseImpl(CreateWalletGetway createWalletGetway) {
        this.createWalletGetway = createWalletGetway;
    }

    @Override
    public void create(Wallet wallet) {
        createWalletGetway.create(wallet);
    }
}
