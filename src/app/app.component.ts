import { Component } from '@angular/core';
import mydata from '../assets/data/data.json';
import { ProjectDetails, SocialLinks, StudentDetails, TechnologyUsed } from './assignment1';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'portfolio';
  personal:StudentDetails=mydata.name;
  social:SocialLinks=mydata.SocialLinks;
  project:ProjectDetails[]=mydata.projects;
  technology:TechnologyUsed=mydata.technologyused;
  darkMode: boolean = false;


  toggleCheckbox() {
    this.darkMode = !this.darkMode;
  }

  
 
}
