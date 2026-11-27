import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SpaceComponent } from './space/space.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'spaces',
    component: SpaceComponent,
  },
];
