INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('fooClientIdPassword', '$2a$08$us0UjfG2tSE2qS76D.nI5uDiYJUPhvn8RBwJu323ePSCazOc2Ir9u', 'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 'http://localhost:8080/login', null, 36000, 36000, null, true);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('sampleClientId', 'secret', 'read,write,foo,bar',
	'implicit', 'http://localhost:8080/login', null, 36000, 36000, null, false);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('barClientIdPassword', '$2a$08$us0UjfG2tSE2qS76D.nI5uDiYJUPhvn8RBwJu323ePSCazOc2Ir9u', 'bar,read,write',
	'password,authorization_code,refresh_token', 'http://localhost:8080/oauth2/callback/myService', null, 36000, 36000, null, true);
	
	
INSERT INTO role (`name`) VALUES('ROLE_USER');
INSERT INTO user (`activated`, `activation_key`, `password`, `reset_password_key`, `username`) VALUES ('1', 'key', '$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'hyh', 'user1');
INSERT INTO user (`activated`, `activation_key`, `password`, `reset_password_key`, `username`) VALUES ('1', 'key', '$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'hyh', 'user2');
INSERT INTO user (`activated`, `activation_key`, `password`, `reset_password_key`, `username`) VALUES ('1', 'key', '$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'hyh', 'user3');
INSERT INTO user_roles VALUES (2, 1);
INSERT INTO user_roles VALUES (3, 1);