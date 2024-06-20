import { Component,Input } from '@angular/core';
import {ProjectDetails} from '../assignment1';


@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent {

  @Input() project!: ProjectDetails[];
  @Input() darkMode!: Boolean;

}
