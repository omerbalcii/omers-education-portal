import { User } from "./User";
import { Course } from "./Course";

export interface Enrollment {
  id: number;
  user: User;
  course: Course;
  enrollmentDate: string;
}
