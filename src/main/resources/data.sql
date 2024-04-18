-- Insert users
INSERT INTO `_user` (locked,`matricule`, `username`, `password`) VALUES
  (FALSE,'user0', 'user_zero', '$2a$10$2uZkgCA.T0BHPl2Bf4dVIelvwmGvgQMlEYEn3Ie7XMsPSiohEa85a'),
  (FALSE,'user1', 'user_one', '$2a$10$2uZkgCA.T0BHPl2Bf4dVIelvwmGvgQMlEYEn3Ie7XMsPSiohEa85a'),
  (FALSE,'user2', 'user_two','$2a$10$2uZkgCA.T0BHPl2Bf4dVIelvwmGvgQMlEYEn3Ie7XMsPSiohEa85a');



-- Example data for clients and accounts (replace with your desired values)
INSERT INTO `clients` (`id`, `name`, `phone_number`) VALUES
  ('client_1', 'Diddi', '1234567890'),
  ('client_2', 'Charles', '0987654321'),
  ('client_3', 'John', '123456789');

INSERT INTO `account` (`account_id`, `account_number`, `client_id`, `account_type`, `value`) VALUES
  ('compte_1', '123456789', 'client_1', 1, 1000000),  -- Replace 1 with appropriate account type code
  ('compte_2', '987654321', 'client_2', 2, 1500000),
  ('compte_3', '1234567890', 'client_3', 3, 3000000);   -- Replace 2 with appropriate account type code

-- Example transaction (replace user IDs and account IDs with actual values)
INSERT INTO `operation` (`id`, `creation_date`, `value`, `type`, `user_id`, `operator_id`, `recipient_id`) VALUES
  ('trans_1', '2024-04-04', 5000, 'deposit', 'user1', 'compte_1', 'compte_1');