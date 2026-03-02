CREATE TABLE transactions_pin(
    id BIGSERIAL PRIMARY KEY,
    pin TEXT NOT NULL,
    attempt INTEGER  NOT NULL,
    blocked BOOLEAN  NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE  NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE
);