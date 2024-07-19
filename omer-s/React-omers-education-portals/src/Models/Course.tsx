export interface Course {
    id: number;
    name: string;
    title: string;
    description: string;
    enrollments: Enrollment[];
    lessons: Lesson[];
    reviews: Review[];
  }
  
  export interface User {
    id: number;
    username: string;
    email: string;
    password: string;
    role: string;
  }
  
  export interface Enrollment {
    id: number;
    user: User;
    course: Course;
    enrollmentDate: string;
  }
  
  export interface Lesson {
    id: number;
    name: string;
    content: string;
    course: Course;
  }
  
  export interface Review {
    id: number;
    rating: number;
    comment: string;
    user: User;
    course: Course;
  }
  