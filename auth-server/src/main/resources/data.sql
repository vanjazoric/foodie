INSERT INTO role (`name`) VALUES('ROLE_USER');
INSERT INTO role (`name`) VALUES('ROLE_ADMIN');
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$BLA9EDAQ.w4kwa1o.YUotu0Lp0FnWNH51ALUGgJZ6/8arl.YPUki2', 'user1', 1);
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$BLA9EDAQ.w4kwa1o.YUotu0Lp0FnWNH51ALUGgJZ6/8arl.YPUki2', 'user2', 2);
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$BLA9EDAQ.w4kwa1o.YUotu0Lp0FnWNH51ALUGgJZ6/8arl.YPUki2', 'user3', 1);

INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('fooClientIdPassword', '$2a$08$UoK.DyIJsKHvpUf85mb6AefpvddKOTJPBHkPIsZvoyW5Eg7kop/7y', 'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 'http://localhost:8080/login', null, 36000, 36000, null, true, 2, 'App1');
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('sampleClientId', '$2a$08$UoK.DyIJsKHvpUf85mb6AefpvddKOTJPBHkPIsZvoyW5Eg7kop/7y', 'read,write,foo,bar',
	'implicit', 'http://localhost:8080/login', null, 36000, 36000, null, false, 2, 'App2');
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('foodie', '$2a$08$UoK.DyIJsKHvpUf85mb6AefpvddKOTJPBHkPIsZvoyW5Eg7kop/7y', 'profile_picture,phone_number,address',
	'password,authorization_code,refresh_token', 'http://localhost:8080/oauth2/callback/myService', null, 36000, 36000, null, false, 2, 'Foodie');		