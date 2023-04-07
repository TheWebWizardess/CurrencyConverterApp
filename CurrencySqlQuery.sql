CREATE TABLE dbo.CurrencyRates (
    id INT PRIMARY KEY IDENTITY(1,1),
    fromCurrency NVARCHAR(3),
    toCurrency NVARCHAR(3),
    rate FLOAT
);

INSERT INTO dbo.CurrencyRates (fromCurrency, toCurrency, rate)
VALUES ('USD', 'EUR', 0.85),
       ('EUR', 'USD', 1.18),
       ('USD', 'GBP', 0.76),
       ('GBP', 'USD', 1.32);

INSERT INTO dbo.CurrencyRates (fromCurrency, toCurrency, rate)
VALUES ('USD', 'JPY', 109.42),
       ('JPY', 'USD', 0.0091),
       ('USD', 'AUD', 1.29),
       ('AUD', 'USD', 0.77),
       ('USD', 'CAD', 1.26),
       ('CAD', 'USD', 0.79),
       ('USD', 'CHF', 0.94),
       ('CHF', 'USD', 1.06),
       ('USD', 'CNY', 6.49),
       ('CNY', 'USD', 0.15),
       ('USD', 'HKD', 7.77),
       ('HKD', 'USD', 0.13),
       ('USD', 'NZD', 1.39),
       ('NZD', 'USD', 0.72),
       ('USD', 'KRW', 1140.16),
       ('KRW', 'USD', 0.0009),
       ('USD', 'MXN', 20.10),
       ('MXN', 'USD', 0.05),
       ('USD', 'SGD', 1.35),
       ('SGD', 'USD', 0.74),
       ('USD', 'INR', 74.15),
       ('INR', 'USD', 0.013),
       ('USD', 'RUB', 74.68),
       ('RUB', 'USD', 0.013),
       ('USD', 'ZAR', 14.23),
       ('ZAR', 'USD', 0.070);

INSERT INTO dbo.CurrencyRates (fromCurrency, toCurrency, rate)
VALUES ('USD', 'BRL', 5.67),
('BRL', 'USD', 0.18),
('USD', 'DKK', 6.20),
('DKK', 'USD', 0.16),
('USD', 'NOK', 8.28),
('NOK', 'USD', 0.12),
('USD', 'SEK', 8.37),
('SEK', 'USD', 0.12),
('USD', 'TRY', 9.33),
('TRY', 'USD', 0.11),
('USD', 'AED', 3.67),
('AED', 'USD', 0.27),
('USD', 'ILS', 3.24),
('ILS', 'USD', 0.31),
('USD', 'SAR', 3.75),
('SAR', 'USD', 0.27),
('USD', 'THB', 32.75),
('THB', 'USD', 0.03),
('USD', 'IDR', 14395.90),
('IDR', 'USD', 0.00007);

