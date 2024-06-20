import { Component ,Input} from '@angular/core';
import { SocialLinks } from '../assignment1';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  @Input() socialLinks!: SocialLinks;
  @Input() darkMode!: Boolean;


}
