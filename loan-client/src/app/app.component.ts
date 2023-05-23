import {Component, OnDestroy} from '@angular/core'
import {FormBuilder, Validators} from "@angular/forms"
import {HttpClient} from "@angular/common/http"
import {loanDto} from "./loan-dto";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy{
  loanData: loanDto | any
  //TODO add global FormBuilderService.getForm() passing controlsConfig
  form = this.fb.group({
    principleAmount: ['', Validators.required],
    periodYears: ['', Validators.required],
    loanTypeId: ['']
  })
  private subscription: Subscription

  constructor(private httpClient: HttpClient, private fb: FormBuilder) {
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  onSubmit(): void {
    //TODO get loanTypeId from parent component or from a server call
    this.form.controls['loanTypeId'].setValue(1)

    //TODO add global httpService with .get() .post() ...
    this.subscription = this.httpClient.get('http://localhost:8080/rest/housing', {
      params: this.form.value
    }).subscribe(response => {
      this.loanData = response})
  }

  getButtonText(): string {
    return this.loanData ? 'Recalculate' : 'Calculate'
  }
}
