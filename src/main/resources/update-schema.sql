create table bank_transfer (bank_code varchar(255), id varchar(255) not null, recipient_account varchar(255), primary key (id));

create table card_payment (mcc_code integer, card_id varchar(255), id varchar(255) not null, merchant_id varchar(255), name varchar(255), primary key (id));

create table payment (amount numeric(38,2) not null, created_at timestamp(6), currency varchar(255) not null, id varchar(255) not null, status varchar(255), user_id varchar(255) not null, primary key (id));

create table person_to_person_transfer (id varchar(255) not null, note varchar(255), recipient_id varchar(255) not null, sender_id varchar(255) not null, primary key (id));

ALTER TABLE payment
    ADD amount DECIMAL;

ALTER TABLE payment
    ADD created_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE payment
    ADD currency VARCHAR(255);

ALTER TABLE payment
    ADD id VARCHAR(255);

ALTER TABLE payment
    ADD status VARCHAR(255);

ALTER TABLE payment
    ADD user_id VARCHAR(255);

ALTER TABLE bank_transfer
    ADD bank_code VARCHAR(255);

ALTER TABLE bank_transfer
    ADD id VARCHAR(255);

ALTER TABLE bank_transfer
    ADD recipient_account VARCHAR(255);

ALTER TABLE card_payment
    ADD card_id VARCHAR(255);

ALTER TABLE card_payment
    ADD id VARCHAR(255);

ALTER TABLE card_payment
    ADD mcc_code INTEGER;

ALTER TABLE card_payment
    ADD merchant_id VARCHAR(255);

ALTER TABLE card_payment
    ADD name VARCHAR(255);

ALTER TABLE person_to_person_transfer
    ADD id VARCHAR(255);

ALTER TABLE person_to_person_transfer
    ADD note VARCHAR(255);

ALTER TABLE person_to_person_transfer
    ADD recipient_id VARCHAR(255);

ALTER TABLE person_to_person_transfer
    ADD sender_id VARCHAR(255);

ALTER TABLE bank_transfer
    ADD CONSTRAINT pk_banktransfer PRIMARY KEY (id);

ALTER TABLE card_payment
    ADD CONSTRAINT pk_cardpayment PRIMARY KEY (id);

ALTER TABLE payment
    ADD CONSTRAINT pk_payment PRIMARY KEY (id);

ALTER TABLE person_to_person_transfer
    ADD CONSTRAINT pk_persontopersontransfer PRIMARY KEY (id);

ALTER TABLE bank_transfer
    ADD CONSTRAINT FK_BANKTRANSFER_ON_ID FOREIGN KEY (id) REFERENCES payment (id);

ALTER TABLE card_payment
    ADD CONSTRAINT FK_CARDPAYMENT_ON_ID FOREIGN KEY (id) REFERENCES payment (id);

ALTER TABLE person_to_person_transfer
    ADD CONSTRAINT FK_PERSONTOPERSONTRANSFER_ON_ID FOREIGN KEY (id) REFERENCES payment (id);