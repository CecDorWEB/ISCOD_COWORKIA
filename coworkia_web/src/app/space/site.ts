import { Zone } from './zone';

export interface Site {
  id: number;
  name: string;
  zones: Array<Zone>;
}
