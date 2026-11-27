import { Component, OnInit } from '@angular/core';
import { Site } from './site';
import { FormsModule } from '@angular/forms';
import { NgFor, NgIf, DatePipe } from '@angular/common';
import { Zone } from './zone';
import { Post } from './post';
import { SpaceService } from '../space.service';

@Component({
  selector: 'app-space',
  imports: [FormsModule, NgFor, NgIf, DatePipe],
  templateUrl: './space.component.html',
  styleUrl: './space.component.css',
})
export class SpaceComponent implements OnInit {
  title = 'Consulter les espaces de coworking';

  selectedSite?: Site;
  selectedZone?: Zone;
  selectedPost?: Post;
  startedDate?: Date;
  endingDate?: Date;

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

  get datesBetween(): Date[] {
    if (!this.startedDate || !this.endingDate) {
      return [];
    }

    const dates: Date[] = [];
    const current = new Date(this.startedDate);
    const end = new Date(this.endingDate);

    while (current <= end) {
      dates.push(new Date(current));
      current.setDate(current.getDate() + 1);
    }

    return dates;
  }

  get displayedPosts(): Post[] {
    if (this.selectedPost) {
      return [this.selectedPost];
    }

    return this.selectedZone?.posts ?? [];
  }
}
