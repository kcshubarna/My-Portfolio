import { Component, Input } from '@angular/core';
import { SocialLinks, StudentDetails } from '../assignment1';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  @Input() personalDetails!: StudentDetails;
  @Input() socialLinks!: SocialLinks;
  @Input() darkMode!: Boolean;




}
