import { User } from "./User";
import { Course } from "./Course";

export interface Review {
  id: number;
  rating: number;
  comment: string;
  user: User;
  course: Course;
}
