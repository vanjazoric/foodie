INSERT IGNORE INTO role (id, name) VALUES(1, 'ROLE_CUSTOMER');
INSERT IGNORE INTO role (id, name) VALUES(2, 'ROLE_DELIVERY');
INSERT IGNORE INTO role (id, name) VALUES(3, 'ROLE_ADMIN');

INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('1', '0', 'Sir, sunka, pecurke, kecap', 'Pica Capricciosa', '350.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('2', '0', 'Punjena sirom i sunkom', 'Gurmanska pljeskavica', '320.00', '0', '200 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('3', '0', 'Kuvano sa mirođijom', 'Boranija', '300.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('4', '0', 'Pelat, parmezan, mleveno meso', 'Spaghetti Bolognese', '580.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('5', '0', 'Mocarela, paradajz, maslinovo ulje', 'Pica Margarita', '320.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('6', '0', '4 vrste sira', 'Spaghetti Carbonara', '540.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('7', '0', '', 'Palačinka sa nutelom i bananom', '185.00', '0', '200 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('8', '0', 'Preliv od čokolade i višnja na vrhu', 'Krofna sa čokoladom i višnjom', '170.00', '0', '80 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('9', '0', 'Kora, banane, šlag', 'Kolač sa bananom', '235.00', '0', '100 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('10', '0', 'Prilozi: krompir i sos', 'Karađorđeva šnicla', '870.00', '0', '380 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('11', '0', '10 komada', 'Porcija ćevapa', '400.00', '0', '200 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('12', '0', 'Tofu, orašasti plodovi, gljive', 'Tofu burger', '250.00', '0', '150 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('13', '0', 'Prilozi: kupus, šargarepa, sos', 'Piletina sa kikirikijem', '350.00', '0', '300 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('14', '0', 'Prilozi za burger: majonez, kečap, krastavac', 'Burger + pomfrit', '250.00', '0', '250 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('15', '0', 'Šunka, trapist, šampinjoni, namaz', 'Index sendvič', '280.00', '0', '150 g');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('16', '0', '', 'Coca cola', '80.00', '1', '500 ml');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('17', '0', '', 'Ledeni čaj', '80.00', '1', '500 ml');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('18', '0', '', 'Milk shake', '250.00', '1', '500 ml');
INSERT IGNORE INTO `foodie`.`item` (`id`, `deleted`, `description`, `name`, `price`, `type`, `weight`) VALUES ('19', '0', '', 'Smoothie sa jagodom i bananom', '250.00', '1', '300 ml');

INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('1', 'Nikole Pašića 27', '0', '0', 'fontana.jpg', 'Fontana');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('2', 'Sutjeska 2', '0', '0', 'plavaFrajla.jpg', 'Plava Frajla');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('3', 'Ribarsko ostrvo bb', '0', '0', 'piknik.jpg', 'Piknik');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('4', 'Teodora Mandića 2', '0', '0', 'sabbiadoro.jpg', 'Sabbiadoro');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('5', 'Bulevar Oslobođenja 50', '0', '0', 'minuta.jpg', 'Minuta');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('6', 'Bulevar Oslobođenja 133', '0', '0', 'haohao.jpg', 'Hao-Hao');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('7', 'Braće Ribnikar 7', '0', '0', 'tasty.jpg', 'Tasty');
INSERT IGNORE INTO `foodie`.`restaurant` (`id`, `address`, `category`, `deleted`, `logo`, `name`) VALUES ('8', 'Jevrejska 42' , '0', '0', 'rekalibracija.jpg', 'Rekalibracija');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('7', '8');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('7', '9');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('1', '2');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('1', '3');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('1', '10');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('1', '11');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('4', '1');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('4', '4');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('4', '5');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('4', '6');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('5', '14');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('5', '15');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('6', '13');
INSERT IGNORE INTO `foodie`.`restaurant_food_items` (`restaurant_id`, `food_items_id`) VALUES ('8', '12');

INSERT IGNORE INTO `foodie`.`restaurant_drinks` (`restaurant_id`, `drinks_id`) VALUES ('1', '16');
INSERT IGNORE INTO `foodie`.`restaurant_drinks` (`restaurant_id`, `drinks_id`) VALUES ('1', '17');
INSERT IGNORE INTO `foodie`.`restaurant_drinks` (`restaurant_id`, `drinks_id`) VALUES ('5', '18');
INSERT IGNORE INTO `foodie`.`restaurant_drinks` (`restaurant_id`, `drinks_id`) VALUES ('7', '19');

INSERT IGNORE INTO `foodie`.`user` (`id`, `email`, `email_verified`, `first_name`, `last_name`, `password`, `phone_number`, `provider`, `username`, `role_id`) VALUES ('1', 'admin@gmail.com', '1', 'Admin', 'Admin', '$2y$08$4ivx.w3MfTFpiVkSedyRFepisMNLuI9osIat8cKs0IWOCWNYgH.mm', '0668929298', 'local', 'admin', '3');
INSERT IGNORE INTO `foodie`.`user` (`id`, `email`, `email_verified`, `first_name`, `last_name`, `password`, `phone_number`, `provider`, `username`, `role_id`) VALUES ('2', 'delivery.guy@gmail.com', '1', 'Delivery', 'Guy', '$2y$08$4ivx.w3MfTFpiVkSedyRFepisMNLuI9osIat8cKs0IWOCWNYgH.mm', '0682528655', 'local', 'delivery_guy', '2');
INSERT IGNORE INTO `foodie`.`user` (`id`, `email`, `email_verified`, `first_name`, `image_url`, `last_name`, `password`, `phone_number`, `provider`, `username`, `role_id`) VALUES ('3', 'customer@gmail.com', '1', 'Vanja', 'http://localhost:8080/image/3', 'Zorić', '$2y$08$4ivx.w3MfTFpiVkSedyRFepisMNLuI9osIat8cKs0IWOCWNYgH.m', '0643891303', 'local', 'vanja', '1');
INSERT IGNORE INTO `foodie`.`customer` (`id`) VALUES ('3');
INSERT IGNORE INTO `foodie`.`delivery_guy` (`id`) VALUES ('2');

INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('1', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('2', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('3', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('4', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('5', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('6', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('7', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('8', 'Lift ne radi', '0', '3', '2');
INSERT IGNORE INTO `foodie`.`orders` (`id`, `note`, `status`, `customer_id`, `delivery_guy_id`) VALUES ('9', 'Lift ne radi', '0', '3', '2');

INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('1', '1', '1');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('2', '2', '16');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('3', '1', '8');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('4', '1', '9');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('5', '1', '12');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('6', '1', '19');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('7', '1', '9');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('8', '3', '17');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('9', '1', '1');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('10', '1', '13');
INSERT IGNORE INTO `foodie`.`order_item` (`id`, `quantity`, `item_id`) VALUES ('11', '2', '7');


INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('1', '1');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('1', '2');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('2', '3');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('2', '4');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('3', '5');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('3', '6');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('3', '7');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('4', '8');
INSERT IGNORE INTO `foodie`.`orders_order_items` (`order_id`, `order_items_id`) VALUES ('4', '9');

