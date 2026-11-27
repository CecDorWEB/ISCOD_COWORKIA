import { Component } from '@angular/core';
import { Site } from './site';
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';
import { Zone } from './zone';
import { Post } from './post';

@Component({
  selector: 'app-space',
  imports: [FormsModule, NgFor, NgIf],
  templateUrl: './space.component.html',
  styleUrl: './space.component.css',
})
export class SpaceComponent {
  title = 'Consulter les espaces de coworking';

  selectedSite?: Site;
  selectedZone?: Zone;
  selectedPost?: Post;

  sites: Site[] = [
    {
      id: 1,
      name: 'République',
      zones: [
        {
          id: 1,
          name: 'Atlas',
          acronyme: 'AT1',
          posts: [
            {
              id: 1,
              code: 'AT1-01',
            },
            {
              id: 2,
              code: 'AT1-02',
            },
          ],
        },
        {
          id: 2,
          name: 'Betha',
          acronyme: 'BE1',
          posts: [
            {
              id: 1,
              code: 'BE1-01',
            },
          ],
        },
      ],
    },
  ];
}
