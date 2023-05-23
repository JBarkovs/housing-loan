import {Component} from '@angular/core'
import {FormBuilder, Validators} from "@angular/forms"
import {HttpClient} from "@angular/common/http"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  //TODO add global FormBuilderService.getForm() passing controlsConfig
  form = this.fb.group({
    principleAmount: ['', Validators.required],
    periodYears: ['', Validators.required],
    loanTypeId: ['']
  })

  constructor(private httpClient: HttpClient, private fb: FormBuilder) {
  }

  onSubmit(): void {
    //TODO get loanTypeId from parent component or from a server call
    this.form.controls['loanTypeId'].setValue(1)

    //TODO add global httpService with .get() .post() ...
    this.httpClient.get('http://localhost:8080/rest/housing', {
      params: this.form.value
    })
      .subscribe(response => {
        console.log(response)})
  }
}
