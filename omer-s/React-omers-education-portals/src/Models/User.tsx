// src\Models\User.tsx
import { Enrollment } from "./Enrollment";
import { Review } from "./Review";
export interface User {
    id: number;
    username: string;
    email: string;
    password: string;
    role: string;
    enrollments?: Enrollment[];
    reviews?: Review[];
  }
  