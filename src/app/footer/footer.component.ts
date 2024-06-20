import { Component, Input } from '@angular/core';
import { StudentDetails, TechnologyUsed } from '../assignment1';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  @Input() student!:StudentDetails;
  @Input() technology!:TechnologyUsed;
  @Input() darkMode!: Boolean;
  

}
