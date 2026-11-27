import { Component, OnInit } from '@angular/core';
import { Site } from './site';
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf } from '@angular/common';
import { Zone } from './zone';
import { Post } from './post';
import { SpaceService } from '../space.service';

@Component({
  selector: 'app-space',
  imports: [FormsModule, NgFor, NgIf],
  templateUrl: './space.component.html',
  styleUrl: './space.component.css',
})
export class SpaceComponent implements OnInit {
  title = 'Consulter les espaces de coworking';

  selectedSite?: Site;
  selectedZone?: Zone;
  selectedPost?: Post;

  sites: Site[] = [];

  constructor(private spaceService: SpaceService) {}

  ngOnInit(): void {
    this.spaceService.getSites().subscribe({
      next: (data) => {
        this.sites = data;
        console.log(data);
      },
      error: (err) => {
        console.error(err);
      },
    });
  }
}
