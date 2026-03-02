CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    from_wallet_id BIGINT NOT NULL,
    to_wallet_id BIGINT NOT NULL,
    transaction_value NUMERIC(10,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE  NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE ,

    CONSTRAINT fk_transaction_from_wallet
            FOREIGN KEY (from_wallet_id)
            REFERENCES wallets(id),

        CONSTRAINT fk_transaction_to_wallet
            FOREIGN KEY (to_wallet_id)
            REFERENCES wallets(id)
);
