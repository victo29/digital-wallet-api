CREATE TABLE wallets(
    id BIGSERIAL PRIMARY KEY,
    balance NUMERIC(10,2) NOT NULL,
    user_id UUID NOT NULL UNIQUE,
    transaction_pin_id BIGINT NOT NULL UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL ,
    updated_at TIMESTAMP WITH TIME ZONE,

     CONSTRAINT fk_wallet_user
            FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE,

        CONSTRAINT fk_wallet_pin
            FOREIGN KEY (transaction_pin_id)
            REFERENCES transactions_pin(id)
            ON DELETE CASCADE
);