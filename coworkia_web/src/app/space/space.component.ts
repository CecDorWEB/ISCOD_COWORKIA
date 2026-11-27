import { Component } from '@angular/core';
import { Space } from './space';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-space',
  imports: [FormsModule],
  templateUrl: './space.component.html',
  styleUrl: './space.component.css',
})
export class SpaceComponent {
  title = 'Consulter les espaces de coworking';

  space: Space = {
    id: 1,
    name: 'Windstorm',
  };
}
