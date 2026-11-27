import { Post } from './post';

export interface Zone {
  id: number;
  name: string;
  acronyme: string;
  posts: Array<Post>;
}
