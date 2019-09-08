export const API_BASE_URL = 'http://localhost:8080';
export const ACCESS_TOKEN = 'accessToken';
export const CURRENT_USER = 'currentUser';

export const OAUTH2_REDIRECT_URI = 'http://localhost:4200/oauth2/redirect'

export const GOOGLE_AUTH_URL = API_BASE_URL + '/oauth2/authorize/google?redirect_uri=' + OAUTH2_REDIRECT_URI;
export const FACEBOOK_AUTH_URL = API_BASE_URL + '/oauth2/authorize/facebook?redirect_uri=' + OAUTH2_REDIRECT_URI;
export const MY_SERVICE_AUTH_URL = API_BASE_URL + '/oauth2/authorize/myService?redirect_uri=' + OAUTH2_REDIRECT_URI;