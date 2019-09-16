INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('fooClientIdPassword', 'secret', 'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 'http://localhost:8080/login', null, 36000, 36000, null, true, null, null);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('sampleClientId', 'secret', 'read,write,foo,bar',
	'implicit', 'http://localhost:8080/login', null, 36000, 36000, null, false, null, false);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove, user_id, client_name)
VALUES
	('barClientIdPassword', 'secret', 'bar,read,write',
	'password,authorization_code,refresh_token', 'http://localhost:8080/oauth2/callback/myService', null, 36000, 36000, null, true, null, false);		
	
INSERT INTO role (`name`) VALUES('ROLE_USER');
INSERT INTO role (`name`) VALUES('ROLE_ADMIN');
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'user1', 1);
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'user2', 2);
INSERT INTO user (password, username, role_id) VALUES ('$2a$08$ykRg8pnUT//37v8YPR5tk.YsUWxWi800ObT8TGuZlvI9SgPHiS6HK', 'user3', 1);