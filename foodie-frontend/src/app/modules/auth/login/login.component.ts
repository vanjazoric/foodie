import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthService } from '../../../services/auth.service';
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL, MY_SERVICE_AUTH_URL } from 'src/app/constants/constants';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    readonly GOOGLE_AUTH_URL = GOOGLE_AUTH_URL;
    readonly FACEBOOK_AUTH_URL = FACEBOOK_AUTH_URL;
    readonly MY_SERVICE_AUTH_URL = MY_SERVICE_AUTH_URL;

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authService: AuthService
    ) {
        console.log(this.authService.currentUserValue);
        // redirect to home if already logged in
        if (this.authService.currentUserValue) {
            console.log("QQQQQQQQQQQQQQQQ");
            this.router.navigate(['/']);
        }
    }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            email: ['', Validators.required],
            password: ['', Validators.required]
        });

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        this.authService.login(this.f.email.value, this.f.password.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate([this.returnUrl]);
                    console.log(data);
                    console.log("You're successfully logged in!");
                },
                error => {
                    this.loading = false;
                    console.log('Oops! Something went wrong. Please try again!');
                });
    }
}